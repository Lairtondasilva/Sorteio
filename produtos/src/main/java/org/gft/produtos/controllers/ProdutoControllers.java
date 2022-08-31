package org.gft.produtos.controllers;

import org.gft.produtos.domain.Produto;
import org.gft.produtos.repositories.ProdutoRepository;
import org.gft.produtos.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoControllers {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	TicketService ticketService;  
	
	
	@GetMapping(value = "/produto")
	public Iterable<Produto> all (){
		return produtoRepository.findAll();
	}
	
	@GetMapping(value = "/produto/{produtoId}")
	public Produto findByAccountId (@PathVariable Integer produtoId){
		
		Produto produto = produtoRepository.findByProdutoId(produtoId);
		
		produto.setTicket(ticketService.findByProdutoid(produtoId));
		
		return produto;
	}
	
}
