package br.com.rafael.desafiobdr.backend.controllers;

import br.com.rafael.desafiobdr.backend.services.RecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/central")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public ResponseEntity<?> listarInfracoes() {
        return new ResponseEntity<>(recordService.findAll(), HttpStatus.OK);
    }

}
