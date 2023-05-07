package br.com.rafael.desafiobdr.backend.repositories;

import br.com.rafael.desafiobdr.backend.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

}
