package br.com.fiap.agendamento.dto;

import br.com.fiap.agendamento.model.CollectionStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CollectionScheduleDto {

    private Long scheduleId;

    @NotNull
    @Positive
    private Long orderId;

    private String collectorName;

    private CollectionStatus status;

    private LocalDate scheduledDate;
}
