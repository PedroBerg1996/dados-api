package com.dados.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dados.dto.DadosDTO;
import com.dados.dto.PatchDTO;
import com.dados.dto.ResponseDTO;
import com.dados.entities.Dados;
import com.dados.service.DadosService;

@Validated
@RestController
@RequestMapping("/dados")
public class DadosController {

	@Autowired
	private DadosService dadosService;

	@PostMapping
	public ResponseDTO postDados(@Valid @RequestBody DadosDTO dadosDTO) throws IOException {
		Dados dados = dadosService.dtoToEntity(dadosDTO);
		dadosService.postDados(dados);
		DadosDTO postedDados = dadosService.entityToDTO(dados);
		ResponseDTO responseDTO = dadosService.entityToReponse(dados);
		dadosService.writefile(postedDados);
		return responseDTO;
	}

	@GetMapping
	public List<ResponseDTO> getAll() {
		List<Dados> dadosList = dadosService.getAll();
		List<ResponseDTO> responseList = dadosService.dadosToReponseList(dadosList);
		return responseList;
	}

	@PatchMapping("/{id}")
	public PatchDTO patchTaxas(@Valid @PathVariable Long id, @RequestBody PatchDTO patchDTO) throws IOException {
		dadosService.patchTaxas(id, patchDTO);
		List<Dados> dadosList = dadosService.getAll();
		List<DadosDTO> dtoList = dadosService.dadosToDTOList(dadosList);
		dadosService.editFile(dtoList);
		return patchDTO;
	}

}
