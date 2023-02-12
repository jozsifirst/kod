package hu.lj.kod.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import hu.lj.kod.model.entity.ChangeRate;

public interface ChangeRateRepository extends CrudRepository<ChangeRate, Long> {

	public List<ChangeRate> findAll();
	
	public Optional<ChangeRate> findBySymbolFromAndSymbolTo(String symbolFrom, String symbolTo);
	
}
