package hu.lj.kod.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lj.kod.model.entity.ChangeRate;
import hu.lj.kod.repository.ChangeRateRepository;
import hu.lj.kod.services.interfaces.ChangeRateService;
import hu.lj.kodmodel.dto.ChangeRateDto;
import jakarta.transaction.Transactional;

@Service
public class ChangeRateServiceImpl implements ChangeRateService {

	@Autowired
	private ChangeRateRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Optional<ChangeRate> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<ChangeRate> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public ChangeRateDto create(ChangeRateDto changeRate) {
		return mapper.map(repository.save(mapper.map(changeRate, ChangeRate.class)), ChangeRateDto.class);	 
	}

	@Override
	public ChangeRateDto update(ChangeRateDto changeRate) {
		return mapper.map(repository.save(mapper.map(changeRate, ChangeRate.class)), ChangeRateDto.class);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Long convert(String from, String to, Long amount) {
		Optional<ChangeRate> changeRate = repository.findBySymbolFromAndSymbolTo(from, to);
		if(changeRate.isPresent()) {
			ChangeRateDto dto = mapper.map(changeRate.get(), ChangeRateDto.class);
			return dto.getChangeRate() * amount;
		}
		return null;
	}

}
