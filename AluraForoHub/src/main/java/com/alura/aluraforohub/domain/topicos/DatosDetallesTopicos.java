package com.alura.aluraforohub.domain.topicos;

import java.time.LocalDate;

public record DatosDetallesTopicos(Long id, String titulo, String mensaje, LocalDate fecha, Long autor, Long curso) {

    public DatosDetallesTopicos(Topicos topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getAutor(), topico.getCurso());
    }
}
