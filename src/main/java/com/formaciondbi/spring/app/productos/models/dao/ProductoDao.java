package com.formaciondbi.spring.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formaciondbi.spring.app.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto,Long> {
	
}
