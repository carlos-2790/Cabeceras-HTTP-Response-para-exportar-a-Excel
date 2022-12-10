package org.cy.apiservlet.webbapp.headers.service;

import org.cy.apiservlet.webbapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L,"Notebook","computacion",175300),new Producto(2L,"teclado mecanico","computacion",54798),
                             new Producto(3L,"mesa escritorio","Oficina",2342));
    }
}
