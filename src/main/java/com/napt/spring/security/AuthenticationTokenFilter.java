package com.napt.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by napt2017 on 4/6/2017.
 */
public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {
    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        tokenUtils = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext()).getBean(TokenUtils.class);
        userDetailsService = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext()).getBean(UserDetailsService.class);

        HttpServletResponse httpServletResponse = (HttpServletResponse)res;
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods","POST,GET,PUT,OPTIONS,DELETE,PATCH");
        httpServletResponse.setHeader("Access-Control-Allow-Max-Age","3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, "+AppContant.tokenHeader);

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String authToken= httpServletRequest.getHeader(AppContant.tokenHeader);
        Optional<String> optUsername = this.tokenUtils.getUsernameFromToken(authToken);
        if(optUsername.isPresent() && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails =  this.userDetailsService.loadUserByUsername(optUsername.get());
            if(this.tokenUtils.validateToken(authToken,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        chain.doFilter(req,res);
    }
}
