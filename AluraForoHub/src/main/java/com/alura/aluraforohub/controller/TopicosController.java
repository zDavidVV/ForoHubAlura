package com.alura.aluraforohub.controller;
import com.alura.aluraforohub.domain.topicos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/Topicos")
//@SecurityRequirement(name = "bearer-key")
@SuppressWarnings("all")
public class TopicosController {
    @Autowired
    private TopicosRepository repository;
    @PostMapping
    @Transactional
    @Operation(summary = "Registra un nuevo topico")
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriBuilder) {
        var topico = new Topicos(datos);
        repository.save(topico);

        var uri = uriBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetallesTopicos(topico));
    }

    @GetMapping
    @Operation(summary = "Obtiene el listado de topicos")
    public ResponseEntity<Page<DatosListaTopicos>> listar(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacion) {
        var page = repository.findAllByEstatusTrue(paginacion).map(DatosListaTopicos::new);
        return ResponseEntity.ok(page);
    }


    @PutMapping
    @Transactional
    @Operation(summary = "Actualiza la informacion del topico")
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionTopico datos) {
        var topicos = repository.getReferenceById(datos.id());
        topicos.actualizarTopicos(datos);

        return ResponseEntity.ok(new DatosDetallesTopicos(topicos));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Elimina un paciente a partir del ID")
    public ResponseEntity eliminar(@PathVariable Long id) {
        var Topicos = repository.getReferenceById(id);
        Topicos.eliminar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "obtiene los detalles para el Topico con el ID indicado")
    public ResponseEntity detallar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetallesTopicos(paciente));
    }
}
