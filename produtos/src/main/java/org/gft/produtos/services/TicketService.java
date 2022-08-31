package org.gft.produtos.services;

import org.gft.produtos.domain.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ticket-service")
public interface TicketService {
	
	@GetMapping(value = "/ticket/produto/{produtoId}")
	Ticket findByProdutoid (@PathVariable("produtoId") Integer produtoId);
		

}
