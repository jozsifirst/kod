package hu.lj.kod.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lj.kod.model.entity.Symbol;
import hu.lj.kod.repository.SymbolRepository;
import hu.lj.kod.services.interfaces.SymbolService;
import hu.lj.kodmodel.dto.SymbolDto;
import jakarta.transaction.Transactional;

@Service
public class SymbolServiceImpl implements SymbolService {

	@Autowired
	private SymbolRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	private Optional<Symbol> findById(Long id) {
		return repository.findById(id);
	}

	private List<Symbol> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public SymbolDto create(SymbolDto symbol) {
		return mapper.map(repository.save(mapper.map(symbol, Symbol.class)), SymbolDto.class);	 
	}

	@Override
	public SymbolDto update(SymbolDto symbol) {
		return mapper.map(repository.save(mapper.map(symbol, Symbol.class)), SymbolDto.class);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	private SymbolDto mapToDto(Symbol symbol) {
		return mapper.map(mapper, SymbolDto.class);
	}

	@Override
	public SymbolDto findByIdDto(Long id) {
		Optional<Symbol> symbol = findById(id);
		if(symbol.isPresent()) {
			return mapToDto(symbol.get());
		}
		return null;
	}
	
	private List<SymbolDto> mapToDtoList(List<Symbol> symbol) {		
		return mapper.map(symbol, new TypeToken<List<SymbolDto>>() {}.getType());
	}

	@Override
	public List<SymbolDto> findAllDto() {
		List<Symbol> symbols = findAll();
		if(!symbols.isEmpty()) {
			return mapToDtoList(symbols);
		}
		return null;
	}


}
