package br.com.rafael.desafiobdr.backend.services.impl;

import br.com.rafael.desafiobdr.backend.dto.RecordDto;
import br.com.rafael.desafiobdr.backend.models.Record;
import br.com.rafael.desafiobdr.backend.repositories.RecordRepository;
import br.com.rafael.desafiobdr.backend.services.RecordService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service @AllArgsConstructor
public class RecordServiceImpl implements RecordService {


    private RecordRepository recordRepository;



    @Override
    public RecordDto criarInfracaoAutomatica() {

        LocalDateTime momento = LocalDateTime.now();
        DateTimeFormatter formatoPedido = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime momentoFinal = LocalDateTime.parse(momento.format(formatoPedido),
                formatoPedido);
        int velocidade = ThreadLocalRandom.current().nextInt(80, 101);
        String placa = geradorPlacaAleatoria();
        String classeVeiculo = geradorClasseVeiculoAleatoria();

        Record infracao = new Record(momentoFinal, velocidade, placa,
                classeVeiculo);
        while (true) {
            try {

                Thread.sleep(3000); //espera 3 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Record infracaoSalva = recordRepository.save(infracao);
            return new RecordDto(infracaoSalva);
        }
    }

    @Override
    public ResponseEntity<?> findAll() {
        List<Record> records = recordRepository.findAll(Sort.by(Sort.Direction.ASC, "moment"));
        return new ResponseEntity<>(records.stream().map(RecordDto::new).collect(Collectors.toList()), HttpStatus.OK);
    }



    @Override
    public String geradorPlacaAleatoria() {
        Random random = new Random();
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder placa = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            placa.append(letras.charAt(random.nextInt(letras.length())));
        }
        placa.append("-");
        for (int i = 0; i < 4; i++) {
            placa.append(random.nextInt(10));
        }
        return placa.toString();
    }

    @Override
    public String geradorClasseVeiculoAleatoria() {
        String[] vehicleClasses = {"Carro", "Moto", "Caminhão", "Ônibus"};
        Random random = new Random();
        return vehicleClasses[random.nextInt(vehicleClasses.length)];
    }

}
