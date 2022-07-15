package com.Proyecto.EloeApp.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyecto.EloeApp.Models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{

	Optional<Empresa> findByEmpresaNombre(String nombre);

	void deleteByEmpresaNombre(String empresaNombre);
	
}
