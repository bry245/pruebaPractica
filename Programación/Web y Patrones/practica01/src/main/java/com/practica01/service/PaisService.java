package com.practica01.service;

import com.practica01.domain.Pais;
import java.util.List;

public interface PaisService {
    public List<Pais> getPaises();
    
    public void save(Pais pais);
    
    public void delete(Pais pais);
    
    public Pais getPais(Pais pais);
}
