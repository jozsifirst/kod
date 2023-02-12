package hu.lj.kod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lj.kod.services.interfaces.SymbolService;
import hu.lj.kodmodel.dto.SymbolDto;

@RestController
@RequestMapping("kod/symbol")
public class SymbolController {
	
	@Autowired
	private SymbolService service;
	
	@GetMapping(value = "/find-by-id")
	public SymbolDto findById(@RequestParam Long id) {
		return service.findByIdDto(id);
	}
	
	@GetMapping()
	public List<SymbolDto> findAll() {
		return service.findAllDto();
	}
	

}
