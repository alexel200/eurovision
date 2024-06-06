package net.eurovision.service.impl;

import net.eurovision.repositories.WordRepository;
import net.eurovision.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    WordRepository wordRepository;
    @Override
    public int countValidWords(List<String> permutations) {
        return wordRepository.countValidWords(permutations);
    }
}