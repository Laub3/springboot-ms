package br.com.fiap.agendamento.controller;

import br.com.fiap.agendamento.dto.CollectionScheduleDto;
import br.com.fiap.agendamento.dto.CollectionScheduleResponseDto;
import br.com.fiap.agendamento.service.CollectionScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class CollectionScheduleController {

    @Autowired
    private Environment environment;

    @GetMapping("/port")
    public ResponseEntity<String> showPort() {
        String port = environment.getProperty("local.server.port");
        return ResponseEntity.ok("REQUEST HANDLED ON PORT: " + port);
    }

    @Autowired
    private CollectionScheduleService service;

    @PostMapping
    public CollectionScheduleResponseDto create(@RequestBody @Valid CollectionScheduleDto scheduleDto) {
        return service.create(scheduleDto);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<CollectionScheduleResponseDto> findById(@PathVariable Long scheduleId) {
        return ResponseEntity.ok(service.findById(scheduleId));
    }

    @GetMapping
    public ResponseEntity<List<CollectionScheduleResponseDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{scheduleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long scheduleId) {
        service.delete(scheduleId);
    }

    @PutMapping
    public CollectionScheduleResponseDto update(@RequestBody @Valid CollectionScheduleDto scheduleDto) {
        return service.update(scheduleDto);
    }
}
