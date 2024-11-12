/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.documento;

import org.springframework.stereotype.Service;

@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;

    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    public Documento agregarDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }

    public Documento obtenerDocumento(Long id) {
        return documentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Documento no encontrado"));
    }

    public void eliminarDocumento(Long id) {
        documentoRepository.deleteById(id);
    }
}
