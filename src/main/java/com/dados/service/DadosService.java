package com.dados.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.dados.dto.DadosDTO;
import com.dados.dto.PatchDTO;
import com.dados.dto.ResponseDTO;
import com.dados.entities.Dados;
import com.dados.repositories.DadosRepository;

@Service
public class DadosService {

	@Autowired
	private DadosRepository dadosRepository;
	ModelMapper modelMapper = new ModelMapper();

	public DadosDTO entityToDTO(Dados dados) {
		DadosDTO dadosDTO = modelMapper.map(dados, DadosDTO.class);
		return dadosDTO;
	}

	public Dados dtoToEntity(DadosDTO dadosDTO) {
		Dados dados = modelMapper.map(dadosDTO, Dados.class);
		return dados;
	}

	public List<ResponseDTO> dadosToReponseList(List<Dados> dadosList) {
		List<ResponseDTO> responseDtoList = modelMapper.map(dadosList, new TypeToken<List<ResponseDTO>>() {
		}.getType());
		return responseDtoList;
	}

	public List<DadosDTO> dadosToDTOList(List<Dados> dadosList) {
		List<DadosDTO> dtoList = modelMapper.map(dadosList, new TypeToken<List<DadosDTO>>() {
		}.getType());
		return dtoList;
	}

	public List<Dados> getAll() {
		List<Dados> dadosList = dadosRepository.findAll();
		return dadosList;

	}

	public Dados postDados(Dados dados) {
		return dadosRepository.save(dados);
	}

	public ResponseDTO entityToReponse(Dados dados) {
		ResponseDTO responseDTO = modelMapper.map(dados, ResponseDTO.class);
		return responseDTO;
	}

	public void writefile(DadosDTO dadosDTO) throws IOException {
		FileWriter fileWriter = new FileWriter("dados.txt", true);
		fileWriter.write(dadosDTO.toString());
		fileWriter.close();
	}

	public void patchTaxas(@PathVariable Long id, PatchDTO patchDTO) {
		Dados dados = dadosRepository.findById(id).get();
		dados.setTaxaDebito(patchDTO.getTaxaDebito());
		dados.setTaxaCredito(patchDTO.getTaxaCredito());
		dados.setTaxaParcelado(patchDTO.getTaxaParcelado());
		dadosRepository.save(dados);

	}

	public void editFile(List<DadosDTO> listDTO) throws IOException {
		FileWriter fileWriter = new FileWriter("dados.txt");
		for (DadosDTO patchedDTO : listDTO) {
			fileWriter.write(patchedDTO.toString());
		}
		fileWriter.close();
	}

}
