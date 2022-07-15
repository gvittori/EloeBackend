package com.Proyecto.EloeApp.Services;

import java.util.List;
import java.util.Optional;

import com.Proyecto.EloeApp.Models.Empresa;
import com.Proyecto.EloeApp.Models.EmpresaCreateDto;
import com.Proyecto.EloeApp.Models.EmpresaUpdateDto;
import com.Proyecto.EloeApp.Util.CustomException;


public interface EmpresaService {
	Optional<Empresa> findById(int empresaId);
	Optional<Empresa> findByEmpresaNombre(String empresaNombre);
	List<Empresa> findAll();
	public String createEmpresa(EmpresaCreateDto empresaCreateDto) throws CustomException;
	public String updateEmpresa(EmpresaUpdateDto empresaCreateDto) throws CustomException;
	public boolean deleteEmpresa(String empresaNombre) throws CustomException;
}
