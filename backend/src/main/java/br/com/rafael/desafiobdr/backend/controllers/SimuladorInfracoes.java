package br.com.rafael.desafiobdr.backend.controllers;

import br.com.rafael.desafiobdr.backend.dto.RecordDto;
import br.com.rafael.desafiobdr.backend.services.RecordService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



@Component
public class SimuladorInfracoes {

    private final RecordService recordService;

    public SimuladorInfracoes(RecordService recordService) {
        this.recordService = recordService;
    }

    @Scheduled(fixedRate = 3000)
    @ResponseBody
    public List<RecordDto> criandoInfracoes() {
        List<RecordDto> lista = new ArrayList<>();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(0);
        Runnable task = () -> {
            lista.add(recordService.criarInfracaoAutomatica());
        };
        executor.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);
        return lista;
    }
}
