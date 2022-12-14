package org.gft.produtos.services;

import org.gft.produtos.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class TicketServiceImpl implements TicketService{
    @Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "defaulTicket")
	public Ticket findByProdutoid(Integer produtoId) {
		return restTemplate.getForObject("http://TICKET-SERVICE/ticket/produto/{produtoId}", Ticket.class, produtoId);
	}

	private Ticket defaulTicket(Integer produtoId) {
        return new Ticket();
    }
    
}
