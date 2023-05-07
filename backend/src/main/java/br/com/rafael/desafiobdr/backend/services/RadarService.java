package br.com.rafael.desafiobdr.backend.services;

import br.com.rafael.desafiobdr.backend.models.Record;

public interface RadarService {

    Record criarInfracaoAleatoria();

    String gerarPlacaAleatoria();
}
