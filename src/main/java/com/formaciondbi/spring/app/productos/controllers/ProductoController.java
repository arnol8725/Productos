package com.formaciondbi.spring.app.productos.controllers;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formaciondbi.spring.app.productos.models.entity.Producto;
import com.formaciondbi.spring.app.productos.models.service.IProductoServices;


@RestController
public class ProductoController {
	
	
	@Autowired
	private Environment environment;
	
	@Value("${server.port}")
	private Integer port;
	@Autowired
	@Qualifier(value="productoServices")
	private IProductoServices productServices;
	
	@GetMapping("/listar")
	private List<Producto> listar(){
		return productServices.findAll().stream().map(p -> {
			//p.setPort(Integer.parseInt( environment.getProperty("local.server.port")));
			p.setPort(port);
			return p;
		}).collect(Collectors.toList());
	}
 
	@GetMapping("/ver/{id}")
	private Producto detalli(@PathVariable Long id){
		
		Producto p = productServices.finbyId(id);
		//p.setPort(Integer.parseInt( environment.getProperty("local.server.port")));
		p.setPort(port);
		return p;
	}
}
