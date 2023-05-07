package br.com.rafael.desafiobdr.backend.models;

import br.com.rafael.desafiobdr.backend.dto.RecordDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity @Data @NoArgsConstructor
@AllArgsConstructor @Table(name = "records")
public class Record implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "data_hora")
    private LocalDateTime moment;

    @Positive
    private Integer velocidade;

    @Pattern(regexp = "[A-Z]{3}[0-9][A-Z][0-9]{2}")
    @Column(name = "placa")
//    @Convert(converter = StringEncryptorConverter.class)
    private String placa;

    @NotBlank
    private String classeVeiculo;

    public Record(LocalDateTime moment, Integer velocidade, String placa, String classeVeiculo) {
        this.moment = moment;
        this.velocidade = velocidade;
        this.placa = placa;
        this.classeVeiculo = classeVeiculo;
    }

}
