package hu.lj.kod.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.lj.kod.model.entity.Symbol;

@Repository
public interface SymbolRepository extends CrudRepository<Symbol, Long> {
	
	public List<Symbol> findAll();

}
