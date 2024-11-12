/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author Administrador
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNombreUsuario(username);
        if (usuarioOpt.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        Usuario usuario = usuarioOpt.get();
        String rol = usuario.getRol().getNombreRol();
        return org.springframework.security.core.userdetails.User.withUsername(usuario.getNombreUsuario())
                .password(usuario.getPassword())
                .authorities(new SimpleGrantedAuthority(rol))
                .build();
    }
    

    public boolean authenticate(String nombre, String contraseña) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNombreUsuario(nombre);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return bCryptPasswordEncoder.matches(contraseña, usuario.getPassword());
        }
        return false;
    }
    
    public String encriptarContraseña(String contraseña){
        return bCryptPasswordEncoder.encode(contraseña);
    }
    
    public Optional<Usuario> findByNombreUsuario(String nombre) {
        return usuarioRepository.findByNombreUsuario(nombre);
    }
    
    public boolean checkPassword(Usuario usuario, String rawPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, usuario.getPassword());
    }
}
