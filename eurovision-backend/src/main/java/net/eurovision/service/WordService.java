package net.eurovision.service;

import java.util.List;

public interface WordService {
    int countValidWords(List<String> permutations);
}