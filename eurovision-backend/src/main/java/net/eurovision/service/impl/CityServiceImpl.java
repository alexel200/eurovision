package net.eurovision.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.eurovision.entities.City;
import net.eurovision.jsons.CityRest;
import net.eurovision.repositories.CityRepository;
import net.eurovision.repositories.WordRepository;
import net.eurovision.service.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;
    @Autowired
    WordRepository wordRepository;
    
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Page<CityRest> queryByPage(Pageable pageable) {
        Page<City> cityEntities = cityRepository.findAll(pageable);

        return cityEntities.map(city -> modelMapper.map(city, CityRest.class));
    }

    @Override
    public String findCityWithMostPermutations(int citiesWordLength) {
        String result = "";
        log.info("1. Find cities with seven length");
        List<String> cities = getCitiesByLength(citiesWordLength);
        
        log.info("2. Start finding the most permutable");
        HashMap<Integer, String> theMostPermutableCity = findMostPermutableCity(cities);
        for(Integer key: theMostPermutableCity.keySet()){
            result = "The city which has the most permutable word is " 
                                + theMostPermutableCity.get(key) + ", with " + key + " matches";
        }
        log.info("3. Get the valid words for displaying");
        if(theMostPermutableCity.containsKey(-1)){
            String validWords = "";
            validWords = theMostPermutableCity.get(-1);
            result += ", with the following words: " + validWords;
        }
        
        return result;
    }

    private HashMap<Integer, String> findMostPermutableCity(List<String> cities) {
        HashMap<Integer,String> result = new HashMap<>();
        String theMostPermutableCity = "";
        int validWordsCounter = 0;
        List<String> permutations;
        List<String> listOfValidWords;
        List<String> finalPermutationsList = new ArrayList<>();
        //Loop for finding the city with more matches
        for(String city: cities){
            log.info("2.1. Getting permutable word list");
            permutations = generatePermutations(city.toLowerCase());
            //Count validWords
            int validWords = countValidWords(permutations);
            log.info("2.2. City " + city + " valid words: " + validWords);
            if (validWords > validWordsCounter) {
                theMostPermutableCity = city;
                validWordsCounter = validWords;
                finalPermutationsList = permutations;
            }
            log.info("2.3. Selecting city with more matches " + theMostPermutableCity );
        }
        
        if(!finalPermutationsList.isEmpty()){
            listOfValidWords = recoveryValidWords(finalPermutationsList);
            result.put(-1, listOfValidWords.toString());
            result.put(validWordsCounter, theMostPermutableCity);
        }
        
        return result;
    }
    
    private List<String> recoveryValidWords(List<String> permutations){
        //After selecting the city, get validWords for displaying to the user.
        log.info("2.4. Recovering valid words for display to the user");
        List<String> listOfValidWords = new ArrayList<>();
        int permutationsSize = permutations.size();
        int fetchWords = 1000;
        int endLimit = 1000;

        if(permutationsSize > fetchWords){
            boolean loop = true;
            int index = 0;
            while(loop){
                listOfValidWords.addAll(getValidWords(permutations.subList(index, endLimit)));

                if(permutationsSize-endLimit == 0){
                    loop = false;
                }else if(permutationsSize-endLimit < 1000){
                    endLimit += permutationsSize-endLimit;
                    index += fetchWords;
                }else{
                    endLimit += fetchWords;
                    index += fetchWords;
                }
            }
        }else{
            listOfValidWords = getValidWords(permutations);
        }
        
        return listOfValidWords;
    }
    
    private List<String> getValidWords(List<String> permutations){
        return wordRepository.getValidWords(permutations);
    }

    private List<String> generatePermutations(String city) {
        log.info("2.1.2 The city " + city + ", permutable work has started");
        List<String> permutations = new ArrayList<>(permute(city));

        
        return permutations.stream().filter(word -> word.length() >= 5).distinct().collect(Collectors.toList());
    }

    public List<String> permute(String word) {
        List<String> permutations = new ArrayList<>();
        List<String> words = new ArrayList<>();
        
        //Handling error scenarios
        if (word == null) {
            return null;
        } else if (word.isEmpty()) {
            permutations.add("");
            return permutations;
        }
        char initial = word.charAt(0); // first character
        try{
            String remaining5 = word.substring(1, word.length() - 2); // 5 characters
            String remaining6 = word.substring(1, word.length() - 1); // 6 characters
            
            words.addAll(permute(remaining5));
            words.addAll(permute(remaining6));
        }catch(Exception e){
            log.info("Error trying to permute 5 and 6");
        }
        String remaining = word.substring(1); // Full string without first character
        words.addAll(permute(remaining));
        
        for (String newWord : words) {
            for (int i = 0;i<=newWord.length();i++){
                String permute = permuteWord(newWord, initial, i);
                permutations.add(permute);
                
                permute = permuteWordBegin(newWord, i);
                permutations.add(permute);

                permute = permuteWordEnd(newWord, i);
                permutations.add(permute);

                permute = permuteBeginChar(newWord, initial, i);
                permutations.add(permute);

                permute = permuteBeginEnd(newWord, i);
                permutations.add(permute);
                
            }
        }
        return permutations;
    }

    public String permuteWordBegin(String str, int j) {
        return str.substring(0, j);
    }

    public String permuteWordEnd(String str, int j) {
        return str.substring(j);
    }

    public String permuteBeginChar(String str, char c, int j) {
        String begin = str.substring(0, j);
        return begin + c;
    }

    public String permuteBeginEnd(String str, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + end;
    }
    
    public String permuteWord(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    private int countValidWords(List<String> permutations){
        return wordRepository.countValidWords(permutations);
    }

    private List<String> getCitiesByLength(int wordLength){
        return cityRepository.getNameSevenLength(wordLength);
    }


}