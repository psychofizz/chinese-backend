package hn.unah.lenguajes.chinese.services.impl;

import java.util.List;

import hn.unah.lenguajes.chinese.models.Menus;
import hn.unah.lenguajes.chinese.models.Ordenes;
import hn.unah.lenguajes.chinese.services.OrdenService;

public class OrdenImpl implements OrdenService {

    @Override
    public List<Ordenes> getOrdenesDeClientePorEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrdenesDeClientePorEmail'");
    }

    @Override
    public List<Ordenes> getTodasOrdenesCreadas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTodasOrdenesCreadas'");
    }

    @Override
    public String cancelacionOrden(int id_orden) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelacionOrden'");
    }

    @Override
    public String postOrden(Ordenes ordenes, List<Menus> arregloMenu) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postOrden'");
    }

    @Override
    public String avanzarOrdenChef(int id_orden) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'avanzarOrdenChef'");
    }

    @Override
    public String avanzarOrdenMesero(int id_orden) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'avanzarOrdenMesero'");
    }

    @Override
    public String avanzarOrdenPago(int id_orden) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'avanzarOrdenPago'");
    }

}
