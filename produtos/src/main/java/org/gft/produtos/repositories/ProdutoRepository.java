package org.gft.produtos.repositories;

import org.gft.produtos.domain.Produto;
import org.springframework.data.repository.CrudRepository;


public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
	
	Produto findByProdutoId(Integer produtoId);
	
}
