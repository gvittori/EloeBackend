package com.Proyecto.EloeApp.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.EloeApp.Models.Empresa;
import com.Proyecto.EloeApp.Models.EmpresaCreateDto;
import com.Proyecto.EloeApp.Models.EmpresaUpdateDto;
import com.Proyecto.EloeApp.Repositorios.EmpresaRepository;
import com.Proyecto.EloeApp.Util.CustomException;

@Service
@Transactional
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public Optional<Empresa> findById(int empresaId) {
		return empresaRepository.findById(empresaId);
	}

	@Override
	public Optional<Empresa> findByEmpresaNombre(String nombre) {
		return empresaRepository.findByEmpresaNombre(nombre);
	}

	@Override
	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	@Override
	public String createEmpresa(EmpresaCreateDto empresaCreateDto) throws CustomException {
		String nombre = empresaCreateDto.getEmpresaNombre();
		String mail = empresaCreateDto.getEmpresaMail();
		String cnpj = empresaCreateDto.getEmpresaCnpj();
		double taza = empresaCreateDto.getTazaClicks();

		if (nombre.length() == 0)
			throw new CustomException("Nombre de empresa invalido");
		if (findByEmpresaNombre(nombre).orElse(null) != null)
			throw new CustomException("Empresa ya existe");
		if (mail.length() == 0)
			throw new CustomException("Email invalido");
		if (cnpj.length() < 14)
			throw new CustomException("Cnpj invalido");
		if (taza <= 0)
			throw new CustomException("Taza por clicks invalida");
		Empresa nuevaEmpresa = new Empresa();
		nuevaEmpresa.setEmpresaNombre(nombre);
		nuevaEmpresa.setEmpresaMail(mail);
		nuevaEmpresa.setEmpresaCnpj(cnpj);
		nuevaEmpresa.setTazaClicks(taza);
		// nuevaEmpresa.setClicks(empresaCreateDto.getClicks());

		return empresaRepository.save(nuevaEmpresa).getEmpresaNombre();
	}

	@Override
	public String updateEmpresa(EmpresaUpdateDto empresaUpdateDto) throws CustomException {
		Empresa empresa = findByEmpresaNombre(empresaUpdateDto.getNombre()).orElse(null);
		if (empresa == null) throw new CustomException("Empresa no existe");
		String nombre = empresaUpdateDto.getNombreUpdate();
		String mail = empresaUpdateDto.getEmailUpdate();
		String cnpj = empresaUpdateDto.getCnpjUpdate();
		double taza = empresaUpdateDto.getTazaUpdate();
		if (nombre.length() > 0) {
			empresa.setEmpresaNombre(nombre);
		}
		if (mail.length() > 0) {
			empresa.setEmpresaMail(mail);
		}
		if (cnpj.length() > 0) {
			empresa.setEmpresaCnpj(cnpj);
		}
		if (taza > 0) {
			empresa.setTazaClicks(taza);
		}
		return empresaRepository.save(empresa).getEmpresaNombre();
	}

	@Override
	public boolean deleteEmpresa(String empresaNombre) throws CustomException{
		if(findByEmpresaNombre(empresaNombre).orElse(null) == null) throw new CustomException("Empresa no existe");
		empresaRepository.deleteByEmpresaNombre(empresaNombre);
		return true;
	}

}
