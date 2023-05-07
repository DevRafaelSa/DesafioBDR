package br.com.rafael.desafiobdr.backend.dto;

import br.com.rafael.desafiobdr.backend.models.Record;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecordDto {

    private Long id;
    private LocalDateTime moment;
    private Integer velocidade;
    private String placa;
    private String classeVeiculo;

    public RecordDto(Record record) {
        this.id = record.getId();
        this.moment = record.getMoment();
        this.velocidade = record.getVelocidade();
        this.placa = record.getPlaca();
        this.classeVeiculo = record.getClasseVeiculo();
    }
}
