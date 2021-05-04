package com.jump.jump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jump.jump.domain.Estate;


@Repository
public interface  EstateRepository extends JpaRepository <Estate,Long> {
	
	 Estate findByCnpj(String cnpj);

	

}
