package com.formaciondbi.spring.app.productos.models.service;

import java.util.List;

import com.formaciondbi.spring.app.productos.models.entity.Producto;

public interface IProductoServices {
	public List<Producto> findAll();
	public Producto finbyId(Long id);
}
