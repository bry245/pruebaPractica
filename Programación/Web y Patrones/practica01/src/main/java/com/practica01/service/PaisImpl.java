package com.practica01.service;

import com.practica01.dao.PaisDao;
import com.practica01.domain.Pais;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaisImpl implements PaisService {
    
    @Autowired
    private PaisDao paisDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pais> getPaises() {
        return (List<Pais>) paisDao.findAll();
    }

    @Override
    @Transactional
    public void save(Pais pais) {
        paisDao.save(pais);
    }

    @Override
    @Transactional
    public void delete(Pais pais) {
        paisDao.delete(pais);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Pais getPais(Pais pais) {
        return paisDao.findById(pais.getIdPais()).orElse(null);
    }
}
