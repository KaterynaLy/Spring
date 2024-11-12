/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author Administrador
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional <Usuario> findByNombreUsuario(String nombreUsuario);
}