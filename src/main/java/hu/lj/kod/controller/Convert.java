package hu.lj.kod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lj.kod.services.interfaces.ChangeRateService;

@RestController
@RequestMapping("kod/convert")
public class Convert {
	
	@Autowired
	private ChangeRateService changeRateService;
	
	@GetMapping()
	public Long convert(@RequestParam String from, @RequestParam String to, @RequestParam Long amount) {
		return changeRateService.convert(from, to, amount);
	}

}
