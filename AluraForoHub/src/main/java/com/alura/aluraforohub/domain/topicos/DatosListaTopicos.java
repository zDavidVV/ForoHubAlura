package com.alura.aluraforohub.domain.topicos;

import java.time.LocalDate;

public record DatosListaTopicos(Long id, String titulo, String mensaje, LocalDate fecha) {
    public DatosListaTopicos(Topicos topicos){
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensaje(), topicos.getFecha());
    }
}
