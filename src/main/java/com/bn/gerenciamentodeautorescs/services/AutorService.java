package com.bn.gerenciamentodeautorescs.services;

import com.bn.gerenciamentodeautorescs.models.AutorModel;
import com.bn.gerenciamentodeautorescs.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public AutorModel criar(AutorModel autorModel) {
        return autorRepository.save(autorModel);
    }

    public List<AutorModel> listar() {
        return autorRepository.findAll();
    }

    public AutorModel procurarPorId(Long id) {
        return autorRepository.findById(id).get();
    }

    public void deletar(Long id) {
        autorRepository.deleteById(id);
    }
}
