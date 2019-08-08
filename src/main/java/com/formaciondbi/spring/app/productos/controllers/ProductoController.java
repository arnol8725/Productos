package com.formaciondbi.spring.app.productos.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formaciondbi.spring.app.productos.models.entity.Producto;
import com.formaciondbi.spring.app.productos.models.service.IProductoServices;


@RestController
public class ProductoController {
	@Autowired
	@Qualifier(value="productoServices")
	private IProductoServices productServices;
	
	@GetMapping("/listar")
	private List<Producto> listar(){
		return productServices.findAll();
	}
 
	@GetMapping("/ver/{id}")
	private Producto detalli(@PathVariable Long id){
		return productServices.finbyId(id);
	}
}
