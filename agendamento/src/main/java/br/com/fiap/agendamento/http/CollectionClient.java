package br.com.fiap.agendamento.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("delivery-ms")
public interface CollectionClient {
    @RequestMapping(method = RequestMethod.POST, value = "/delivery/{id}/schedule")
    void updateSchedule(@PathVariable Long id);
}
