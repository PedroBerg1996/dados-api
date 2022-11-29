package com.dados;

//import java.util.List;
//import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dados")
public class DadosController {
	
	@Autowired
	private DadosRepository dadosRepository;
	

	@PostMapping
	public Dados postDados(@RequestBody Dados dados) {
		return  dadosRepository.save(dados);
	}
	
	
//	GET, só para testes.
//	@GetMapping
//	public List<Dados> getDados(){
//		return dadosRepository.findAll();
//	}
//	
}
