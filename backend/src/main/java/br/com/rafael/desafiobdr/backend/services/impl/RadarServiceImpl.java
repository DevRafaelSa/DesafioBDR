package br.com.rafael.desafiobdr.backend.services.impl;

import br.com.rafael.desafiobdr.backend.models.Record;
import br.com.rafael.desafiobdr.backend.repositories.RecordRepository;
import br.com.rafael.desafiobdr.backend.services.RadarService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RadarServiceImpl implements RadarService {

    private RecordRepository recordRepository;


    public RadarServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }


    @Scheduled(fixedRate = 3000)
    @Override
    public Record criarInfracaoAleatoria() {
        // Gera uma velocidade aleatória entre 80 e 100 km/h
        Integer velocidade = ThreadLocalRandom.current().nextInt(80, 101);

        // Gera uma placa de veículo aleatória
        String placa = gerarPlacaAleatoria();

        // Gera uma classe de veículo aleatória
        String[] classesDeVeiculo = {"Carro", "Moto", "Caminhão", "Ônibus"};
        String classeVeiculo = classesDeVeiculo[ThreadLocalRandom.current().nextInt(0, classesDeVeiculo.length)];

        Record record = new Record(
                LocalDateTime.now(), velocidade, gerarPlacaAleatoria(), classeVeiculo
        );

        recordRepository.save(record);
        return record;
    }

    @Override
    public String gerarPlacaAleatoria() {
        // Gera letras aleatórias entre A e Z
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, letras.length());
            sb.append(letras.charAt(randomIndex));
        }

        // Gera números aleatórios entre 0 e 9
        String numeros = "0123456789";
        for (int i = 0; i < 4; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, numeros.length());
            sb.append(numeros.charAt(randomIndex));
        }

        return sb.toString();
    }
}
