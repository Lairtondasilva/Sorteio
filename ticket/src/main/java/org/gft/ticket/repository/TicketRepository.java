package org.gft.ticket.repository;

import org.gft.ticket.org.gft.ticket.domain.Ticket;
import org.springframework.data.repository.CrudRepository;


public interface TicketRepository extends CrudRepository<Ticket, Integer> {
	
	Ticket findTicketByNumeroPremiado(Integer numeroPremiado);
	
	Ticket findAllByProdutoid(Integer produtoId);

}
