/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.documento;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    private final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @PostMapping
    public ResponseEntity<Documento> agregarDocumento(@RequestBody Documento documento) {
        Documento nuevoDocumento = documentoService.agregarDocumento(documento);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDocumento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documento> obtenerDocumento(@PathVariable Long id) {
        Documento documento = documentoService.obtenerDocumento(id);
        return ResponseEntity.ok(documento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDocumento(@PathVariable Long id) {
        documentoService.eliminarDocumento(id);
        return ResponseEntity.noContent().build();
    }
}