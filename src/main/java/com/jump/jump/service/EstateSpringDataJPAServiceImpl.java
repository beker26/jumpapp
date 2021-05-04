package com.jump.jump.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jump.jump.controller.dto.EstateDto;
import com.jump.jump.controller.dto.form.EstateForm;
import com.jump.jump.domain.Estate;
import com.jump.jump.repository.EstateRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class EstateSpringDataJPAServiceImpl {

	private EstateRepository estateRepository;

	public EstateSpringDataJPAServiceImpl(EstateRepository estateRepository) {
		this.estateRepository = estateRepository;
		
	}

	public Estate save(EstateForm form) {
		Estate imobiliaria = form.toEstate();
		return this.estateRepository.save(imobiliaria);
	}

	public List<Estate> findAll() {
		log.info("Starting Method findAll in EstateSpringDataJPAServiceImpl");
		log.info("finishing Method findAll in  EstateSpringDataJPAServiceImpl");
		return this.estateRepository.findAll();
	}

	public EstateDto findByCnpj(String cnpj) {
		log.info("Starting Method findByCnpj in EstateSpringDataJPAServiceImpl");
		log.info("Parameter:{}", cnpj);
		log.info("Finding Estate by id on estateRepository");
		if(cnpj == null || cnpj.isEmpty()) {
			return null;
		}
		Estate imobialiaria = this.estateRepository.findByCnpj(cnpj);
		log.info("Converting Estate to EstateDto");
		EstateDto dto = EstateDto.parse(imobialiaria);
		log.info("finishing Method findByCnpj in  EstateSpringDataJPAServiceImpl");
		return dto;
	}

	public void deleteFindbyCnpj(String cnpj) {
		log.info("Starting Method Delete in EstateSpringDataJPAServiceImpl!");
		Estate imobialiara = this.estateRepository.findByCnpj(cnpj);
		long id = imobialiara.getId();
		log.info("Finishing Method Delete in EstateSpringDataJPAServiceImpl!");
		this.estateRepository.deleteById(id);

	}

	public Estate update(String cnpj, EstateForm imobiliariaDto) {
		log.info("Starting Method Update in EstateSpringDataJPAServiceImpl!");
		log.info("Form: {}", imobiliariaDto);
		Estate imobialiara = this.estateRepository.findByCnpj(cnpj);
		updateImoBiliaria(imobiliariaDto, imobialiara);
		log.info("Finishing Method update in EstateSpringDataJPAServiceImpl!");
        return this.estateRepository.save(imobialiara);
	}

	private void updateImoBiliaria(EstateForm imobiliariaDto, Estate imobialiara) {
		imobialiara.setTelephone(imobiliariaDto.getTelephone());
		imobialiara.setCompanyName(imobiliariaDto.getCompanyName());
		imobialiara.setCnpj(imobiliariaDto.getCnpj());
		imobialiara.setTradingName(imobiliariaDto.getTradingName());
	}
}
