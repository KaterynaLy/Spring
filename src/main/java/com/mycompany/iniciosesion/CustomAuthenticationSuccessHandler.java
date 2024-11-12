/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Verificar el rol del usuario autenticado
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("1"))) {
            // Redirigir a la página de admin
            response.sendRedirect("/protected/admin.html");
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("2"))) {
            // Redirigir a la página de usuario
            response.sendRedirect("/protected/paciente.html");
        } else {
            // Redirigir a una página predeterminada en caso de no coincidir roles
            response.sendRedirect("/login.html");
        }
    }
}










