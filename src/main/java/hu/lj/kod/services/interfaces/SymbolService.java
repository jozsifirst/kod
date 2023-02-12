package hu.lj.kod.services.interfaces;

import java.util.List;
import hu.lj.kodmodel.dto.SymbolDto;

public interface SymbolService {
	
	SymbolDto findByIdDto(Long id);
	
	List<SymbolDto> findAllDto();
	
	SymbolDto create(SymbolDto symbol);
	
	SymbolDto update(SymbolDto symbol);
	
	void delete(Long id);

}
