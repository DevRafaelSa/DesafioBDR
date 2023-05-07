package br.com.rafael.desafiobdr.backend.controllers;

import br.com.rafael.desafiobdr.backend.controllers.dto.RecordDto;
import br.com.rafael.desafiobdr.backend.models.Record;
import br.com.rafael.desafiobdr.backend.services.RadarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Tag(name = "Central de Infrações", description = "API responsável pela central de infrações")
@RequestMapping("/api/central")
public class RecordController {

    private final RadarService radarService;

    public RecordController(RadarService radarService) {
        this.radarService = radarService;
    }


    @GetMapping
    @Cacheable(value = "infracoesCache", key = "'infracoes'")
    public ResponseEntity<?> getInfracao() {
        Record infracao = radarService.criarInfracaoAleatoria();
        return new ResponseEntity<>(new RecordDto(infracao), HttpStatus.OK);
    }

    @Scheduled(fixedRate = 3000)
    @CacheEvict(value = "infracoesCache", key = "'infracoes'")
    public void resetCache() {
        // Este método irá invalidar o cache a cada 3 segundos
    }

}
