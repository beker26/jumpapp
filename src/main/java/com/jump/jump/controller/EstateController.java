package com.jump.jump.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jump.jump.controller.dto.EstateDto;
import com.jump.jump.controller.dto.form.EstateForm;
import com.jump.jump.domain.Estate;
import com.jump.jump.service.EstateSpringDataJPAServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Api(value = "Api")
@Log4j2
public class EstateController {

	private EstateSpringDataJPAServiceImpl estateService;

	public EstateController(EstateSpringDataJPAServiceImpl estateService) {
		this.estateService = estateService;
	}

	@ApiOperation(value = "Restona uma lista de Imobiliarias")
	@GetMapping("/estate")
	public ResponseEntity<List<Estate>> findAll() {
		log.info("Starting Method FindAll in  EstateController!");
		log.info("Finishing Method Findall in EstateController!");
		return ResponseEntity.ok(this.estateService.findAll());
	}

	@ApiOperation(value = "Restona uma lista de Imobiliarias por CPNJ")
	@GetMapping("/estate/{cnpj}")
	public ResponseEntity<EstateDto> findByCnpj(@PathVariable(value = "cnpj") String cnpj) {
		log.info("Starting Method  findByCnpj in EstateController!");
		log.info("Parameter cnpj = {}", cnpj);
		log.info("Converting ALuno to AlunoDto");
		EstateDto dto = this.estateService.findByCnpj(cnpj);
		log.info("Finishing Method findByCnpj in EstateController!");
		return ResponseEntity.ok(dto);
	}

	@ApiOperation(value = "Restona uma lista de Imobiliarias por CPNJ")
	@PostMapping("/estate/cadastra")
	public Estate create(@RequestBody EstateForm dto) {
		log.info("Starting Method create in EstateController!");
		log.info("Finishing Method create in EstateController!");
		return estateService.save(dto);
	}

	@ApiOperation(value = "Restona uma lista de Imobiliarias por CPNJ")
	@DeleteMapping("/estate/delete/{cnpj}")
	public ResponseEntity<?> delete(@PathVariable(value = "cnpj") String cnpj) {
		log.info("Starting Method Delete in EstateController!");
		estateService.deleteFindbyCnpj(cnpj);
		log.info("Finishing Method Delete in EstateController!");
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Restona uma lista de Imobiliarias por CPNJ")
	@PutMapping("/estate/update/{cnpj}")
	public Estate updateController(@PathVariable(value = "cnpj") String cnpj, @RequestBody EstateForm dto) {
		log.info("Starting Method updateController in EstateController");
		log.info("Finishing Method updateController in EstateController!");
		return estateService.update(cnpj, dto);
	}

}
