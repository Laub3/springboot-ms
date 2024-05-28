package br.com.fiap.agendamento.service;

import br.com.fiap.agendamento.dto.CollectionScheduleDto;
import br.com.fiap.agendamento.dto.CollectionScheduleResponseDto;
import br.com.fiap.agendamento.exception.ScheduleNotFoundException;
import br.com.fiap.agendamento.http.CollectionClient;
import br.com.fiap.agendamento.model.CollectionSchedule;
import br.com.fiap.agendamento.repository.CollectionScheduleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionScheduleService {

    @Autowired
    private CollectionScheduleRepository repository;

    @Autowired
    private CollectionClient collectionClient;

    public CollectionScheduleResponseDto create(CollectionScheduleDto scheduleDto) {
        CollectionSchedule schedule = new CollectionSchedule();
        BeanUtils.copyProperties(scheduleDto, schedule);
        CollectionSchedule createdSchedule = repository.save(schedule);
        collectionClient.updateSchedule(createdSchedule.getOrderId());
        return new CollectionScheduleResponseDto(createdSchedule);
    }

    public CollectionScheduleResponseDto findById(Long scheduleId) {
        Optional<CollectionSchedule> scheduleOptional = repository.findById(scheduleId);
        if (scheduleOptional.isPresent()) {
            return new CollectionScheduleResponseDto(scheduleOptional.get());
        } else {
            throw new ScheduleNotFoundException("Schedule not found!");
        }
    }

    public List<CollectionScheduleResponseDto> findAll() {
        return repository.findAll().stream().map(CollectionScheduleResponseDto::new).toList();
    }

    public void delete(Long scheduleId) {
        Optional<CollectionSchedule> scheduleOptional = repository.findById(scheduleId);
        if (scheduleOptional.isPresent()) {
            repository.delete(scheduleOptional.get());
        } else {
            throw new ScheduleNotFoundException("Schedule not found!");
        }
    }

    public CollectionScheduleResponseDto update(CollectionScheduleDto scheduleDto) {
        CollectionSchedule schedule = new CollectionSchedule();
        BeanUtils.copyProperties(scheduleDto, schedule);
        CollectionSchedule updatedSchedule = repository.save(schedule);
        collectionClient.updateSchedule(updatedSchedule.getOrderId());
        return new CollectionScheduleResponseDto(updatedSchedule);
    }
}













