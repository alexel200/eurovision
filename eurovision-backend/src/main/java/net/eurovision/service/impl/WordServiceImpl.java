package net.eurovision.service.impl;

import lombok.RequiredArgsConstructor;
import net.eurovision.repositories.WordRepository;
import net.eurovision.service.WordService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    @Override
    public int countValidWords(List<String> permutations) {
        return wordRepository.countValidWords(permutations);
    }
}