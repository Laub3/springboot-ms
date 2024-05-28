package br.com.fiap.agendamento.dto;

import br.com.fiap.agendamento.model.CollectionSchedule;
import br.com.fiap.agendamento.model.CollectionStatus;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CollectionScheduleResponseDto {

    private Long scheduleId;
    private Long orderId;
    private String collectorName;
    private CollectionStatus status;
    private LocalDate scheduledDate;

    public CollectionScheduleResponseDto(CollectionSchedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.orderId = schedule.getOrderId();
        this.collectorName = schedule.getCollectorName();
//        this.status = schedule.getStatus();
        this.scheduledDate = schedule.getScheduledDate();
    }
}