package com.alura.aluraforohub.domain.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicosRepository extends JpaRepository<Topicos, Long> {
    Page<Topicos> findAllByEstatusTrue(Pageable paginacion);

    @Query("""
            select p.estatus
            from Topicos p
            where p.id=:idTopico
            """)
    Boolean findEstatusById(Long idTopico);
}
