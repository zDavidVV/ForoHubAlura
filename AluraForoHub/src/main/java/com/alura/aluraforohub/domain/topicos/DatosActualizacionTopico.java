package com.alura.aluraforohub.domain.topicos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DatosActualizacionTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        LocalDate fecha,
        boolean estatus
) {
}
