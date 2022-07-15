package com.Proyecto.EloeApp.Repositorios;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Proyecto.EloeApp.Models.Click;

@Repository
public interface ClickRepository extends JpaRepository<Click, Integer>{

	List<Click> findByFechaHoraBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

	//@Query(value = "from click c where fechahora BETWEEN :fechaInicio AND :fechaFin")
	//List<Click> findEntreFechas(@Param("fechaInicio")LocalDateTime fechaInicio,@Param("fechaFin")LocalDateTime fechaFin);
	

}
