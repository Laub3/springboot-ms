package br.com.fiap.agendamento.repository;

import br.com.fiap.agendamento.model.CollectionSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionScheduleRepository extends JpaRepository<CollectionSchedule, Long> {
}