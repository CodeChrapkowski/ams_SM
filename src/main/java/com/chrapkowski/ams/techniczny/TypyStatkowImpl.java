package com.chrapkowski.ams.techniczny;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypyStatkowImpl implements TypyStatkowService {

    @Autowired
    private TypyStatkowRepository typyStatkowRepository;

    // Lista wszytskich Typów Statków
    @Override
    public List<TypyStatkow> PokazWszystkieTypyStatkow(){
        return typyStatkowRepository.findAll();
    }
}
