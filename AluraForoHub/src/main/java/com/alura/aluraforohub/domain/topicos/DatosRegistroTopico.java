package com.alura.aluraforohub.domain.topicos;

import java.time.LocalDate;

public record DatosRegistroTopico(
        String titulo,
        String mensaje,
        LocalDate fecha,
        Boolean estatus,
        Long autor,
        Long curso
) {

}
