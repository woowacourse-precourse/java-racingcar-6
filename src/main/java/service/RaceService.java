package service;

import exception.RaceException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RaceService {

    private static final int MAX_NAME_LENGTH = 5;

    public Map<String, Integer> validateNames(String[] names) {
        Map<String, Integer> carRace = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
            validateNameLength(names[i]);
            names[i] = ensureUniqueName(names[i], carRace.keySet());
            carRace.put(names[i], 0);
        }
        return carRace;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new RaceException(RaceException.LENGTH_EXCEEDED);
        }
    }

    private String ensureUniqueName(String name, Set<String> nameSet) {
        String originalName = name;
        int count = 1;
        while (nameSet.contains(name)) {
            name = originalName + "_" + count;
            count++;
        }
        return name;
    }
}
