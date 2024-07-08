package com.alura.aluraforohub.domain.topicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "topicos")
@Entity(name = "Topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDate fecha;
    private boolean estatus;
    private Long autor;
    private Long curso;

    public Topicos(DatosRegistroTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fecha = datos.fecha();
        this.estatus = true;
        this.autor = datos.autor();
        this.curso = datos.curso();
    }

    public void actualizarTopicos(DatosActualizacionTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.fecha() != null) {
            this.fecha = datos.fecha();
        }
    }

    public void eliminar() {
        this.estatus = false;
    }
}

