package br.com.rafael.desafiobdr.backend.services;

import br.com.rafael.desafiobdr.backend.dto.RecordDto;
import org.springframework.http.ResponseEntity;

public interface RecordService {

    RecordDto criarInfracaoAutomatica();

    ResponseEntity<?> findAll();

    String geradorPlacaAleatoria();

    String geradorClasseVeiculoAleatoria();
}
