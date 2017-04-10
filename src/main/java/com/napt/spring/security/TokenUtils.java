package com.napt.spring.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

/**
 * Created by napt2017 on 4/6/2017.
 */
@Component
public class TokenUtils {
    //Constant
    final String AUDIENCE_UNKNOW="unknow";
    final String AUDIENCE_WEB = "web";
    final String AUDIENCE_MOBILE ="mobile";
    final String AUDIENCE_TABLET="tablet";

    //Secret for token
    private String secret = "napt2017";
    private Long expiration = 604800L;

    public Optional<String> getUsernameFromToken(String token){
        Optional<Claims> optClaims = getClaimsFromToken(token);
        if(optClaims.isPresent()){
            String username;
            try{
                username = optClaims.get().getSubject();
            }catch(Exception ex){
                username = null;
            }
            return Optional.ofNullable(username);
        }
        return Optional.empty();
    }

    private Optional<Claims> getClaimsFromToken(String token){
        Claims claims = null;
        if(token!=null){
            try {
                claims = Jwts.parser().setSigningKey(this.secret.getBytes(Charset.forName("UTF-8"))).parseClaimsJws(token).getBody();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return  Optional.ofNullable(claims);
    }

    public Optional<Date> getCreatedDateFromToken(String token){
        Optional<Claims> optClaims = getClaimsFromToken(token);
        if(optClaims.isPresent()){
            Date createdDate = null;
            try{
                createdDate = new Date((Long)optClaims.get().get("created"));
            }catch (Exception ex){
                ex.printStackTrace();
            }
            return Optional.ofNullable(createdDate);
        }
        return Optional.empty();
    }

    public Optional<Date> getExpirationDateFromToken(String token){
        Optional<Claims> optClaims = getClaimsFromToken(token);
        if(optClaims.isPresent()){
            return Optional.ofNullable(optClaims.get().getExpiration());
        }
        return Optional.empty();
    }

    public Optional<String> getAudienceFromToken(String token){
        Optional<Claims> optClaims = getClaimsFromToken(token);
        if(optClaims.isPresent()){
            String audience=null ;
            try{
                audience = optClaims.get().get("audience")!=null?optClaims.get().get("audience").toString():null;
            }catch (Exception ex){
                ex.printStackTrace();
            }
            return Optional.ofNullable(audience);
        }
        return Optional.empty();
    }

    private Date generateCurrentDate(){
        return new Date(System.currentTimeMillis());
    }

    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis()+expiration);
    }

    private boolean isTokenExpired(String token){
        Optional<Date> optExpired = getExpirationDateFromToken(token);
        if(optExpired.isPresent()){
            Date expiredDate = optExpired.get();
            return expiredDate.before(this.generateCurrentDate());
        }
        return true;
    }

    private boolean isCreatedBeforeLastPasswordReset(Date created,Date lastPasswordReset){
        return (lastPasswordReset!=null && created.before(lastPasswordReset));
    }

    private boolean ignoreTokenExpiration(String token){
        Optional<String> optAudience = this.getAudienceFromToken(token);
        if(optAudience.isPresent()){
            String audience = optAudience.get();
            return (this.AUDIENCE_TABLET.equals(audience)|| this.AUDIENCE_MOBILE.equals(audience));
        }
        return false;
    }

    public Optional<String> generateToken(UserDetails userDetails){
         String jwtString = null;
         try {
             jwtString = Jwts.builder()
                             .setSubject(userDetails.getUsername())
                             .setExpiration(this.generateExpirationDate())
                             .setIssuer(userDetails.getUsername())
                             .setId(System.currentTimeMillis()+"")
                             .claim("created",this.generateCurrentDate())
                             .claim("audience",AUDIENCE_WEB)
                             .signWith(SignatureAlgorithm.HS256, this.secret.getBytes("UTF-8"))
                             .compact();
         }catch (Exception ex){
             ex.printStackTrace();
         }

        return Optional.ofNullable(jwtString);
    }

    public boolean validateToken(String token,UserDetails userDetails){
        SpringSecurityUser user = (SpringSecurityUser) userDetails;
        Optional<String> optUsername = this.getUsernameFromToken(token);
        Optional<Date> optCreated = this.getCreatedDateFromToken(token); ;
        if(optUsername.isPresent() && optCreated.isPresent()){
            return (optUsername.get().equals(user.getUsername())
                    && !(this.isTokenExpired(token))
                    && !(this.isCreatedBeforeLastPasswordReset(optCreated.get(), user.getLastPasswordReset())));
        }

        return false;
    }

    public boolean canTokenBeRefreshed(String token,Date lastPasswordReset){
        Optional<Date> optCreated = this.getCreatedDateFromToken(token);
        if(optCreated.isPresent()){
            Date created = optCreated.get();
            return (!(this.isCreatedBeforeLastPasswordReset(created,lastPasswordReset)) && (!(this.isTokenExpired(token) ||this.ignoreTokenExpiration(token))));
        }
        return false;
    }

    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(this.generateExpirationDate())
                .signWith(SignatureAlgorithm.HS256, this.secret.getBytes(Charset.forName("UTF-8")))
                .compact();
    }

    public Optional<String> refreshToken(String token){
        Optional<Claims> optClaims = this.getClaimsFromToken(token);
        if(optClaims.isPresent()){
            Claims claims = optClaims.get();
            claims.put("created",this.generateCurrentDate());
            String refreshToken = null;
            try{
                refreshToken = this.generateToken(claims);
            }catch (Exception ex){
                ex.printStackTrace();
            }

            return Optional.ofNullable(refreshToken);
        }

        return Optional.empty();
    }

}
