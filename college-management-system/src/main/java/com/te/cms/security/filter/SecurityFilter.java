package com.te.cms.security.filter;

import com.te.cms.utils.jwt.Jwtutils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {


    private final Jwtutils jwtutils;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken!=null && bearerToken.startsWith("bearer ")){
            String token = bearerToken.substring(7);
            String usernameFromToken= jwtutils.getUsername(token);
            UserDetails userFromDb = userDetailsService.loadUserByUsername(usernameFromToken);

            if (usernameFromToken!=null && userFromDb.getUsername()!=null
            && SecurityContextHolder.getContext().getAuthentication()==null){

                UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(
                        userFromDb.getUsername(),userFromDb.getPassword(),userFromDb.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            }


        }

filterChain.doFilter(request,response);


    }
}
//@Override
//protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//        throws ServletException, IOException {
//    String bearerToken = request.getHeader("Authorization");
//    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//        String token = bearerToken.substring(7);
//        String usernameFromToken = jwtUtils.getUsername(token);
//        UserDetails userFromDb = userDetailsService.loadUserByUsername(usernameFromToken);
//        if (usernameFromToken != null && userFromDb.getUsername() != null
//                && SecurityContextHolder.getContext().getAuthentication() == null) {
//            if (jwtUtils.validateToken(token, userFromDb.getUsername())) {
//
//                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                        userFromDb.getUsername(), userFromDb.getPassword(), userFromDb.getAuthorities());
//
//                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            }
//        }
//    }
//    filterChain.doFilter(request, response);
//}

