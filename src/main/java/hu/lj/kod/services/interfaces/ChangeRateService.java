package hu.lj.kod.services.interfaces;

import java.util.List;
import java.util.Optional;

import hu.lj.kod.model.entity.ChangeRate;
import hu.lj.kodmodel.dto.ChangeRateDto;

public interface ChangeRateService {
	
	Optional<ChangeRate> findById(Long id);
	
	List<ChangeRate> findAll();
	
	ChangeRateDto create(ChangeRateDto symbol);
	
	ChangeRateDto update(ChangeRateDto symbol);
	
	Long convert(String from, String to, Long amount);
	
	void delete(Long id);


}
