package br.com.rafael.desafiobdr.backend.controllers;

import br.com.rafael.desafiobdr.backend.dto.RecordDto;
import br.com.rafael.desafiobdr.backend.services.RecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/central")
public class RecordController {

    private final RecordService recordService;

    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(0);
    private List<RecordDto> lista = new ArrayList<>();


    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public ResponseEntity<?> listarInfracoes() {
        return new ResponseEntity<>(recordService.findAll(), HttpStatus.OK);
    }


    public void loop() {
        Runnable task = () -> {
            lista.add(recordService.criarInfracaoAutomatica());
        };
        executor.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);
    }

    @GetMapping("/iniciarLoop")
    @ResponseBody
    public List<RecordDto> iniciarLoop() {
        loop();
        return lista;
    }

    @GetMapping("/pararLoop")
    public void pararLoop() {
        executor.shutdown();
    }

}
