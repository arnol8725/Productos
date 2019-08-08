package com.formaciondbi.spring.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formaciondbi.spring.app.productos.models.dao.ProductoDao;
import com.formaciondbi.spring.app.productos.models.entity.Producto;


@Service("productoServices")
public class ProductoServiceImpl implements IProductoServices {
	
	@Autowired
	private ProductoDao productDao;

	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) productDao.findAll();
	}

	@Override
	public Producto finbyId(Long id) {
		// TODO Auto-generated method stub
		return (Producto) productDao.findById(id).orElse(null);
	}

}
