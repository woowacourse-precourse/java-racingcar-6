package service;

import camp.nextstep.edu.missionutils.Randoms;
import exception.RaceException;

import java.util.*;

public class RaceService {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
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
        int name_length = name.length();
        if (name_length > MAX_NAME_LENGTH ) {
            throw new RaceException(RaceException.LENGTH_OVER_MAXIMUM);
        }
        if (name_length < MIN_NAME_LENGTH){
            throw new RaceException(RaceException.LENGTH_UNDER_MINIMUM);
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

    public int validateAttemptCount(String inputValue) {
        try {
            int attempt = Integer.parseInt(inputValue);
            if (attempt <= 0) {
                throw new RaceException(RaceException.INVALID_ATTEMPT_COUNT);
            }
            return attempt;
        } catch (NumberFormatException e) {
            throw new RaceException(RaceException.NOT_NUMBER);
        }

    }

    public Map<String, Integer> raceStart(Map<String, Integer> racer) {
        for (Map.Entry<String, Integer> entry : racer.entrySet()) {
            String carName = entry.getKey();
            Integer carScore = entry.getValue();

            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                racer.put(carName, carScore + 1);
            }
        }
        return racer;
    }


    public List<String> raceWinner(Map<String, Integer> raceResult) {
        // 1. 가장 높은 점수를 찾습니다.
        int maxScore = 0;
        for (Integer score : raceResult.values()) {
            if (score > maxScore) {
                maxScore = score;
            }
        }

        // 2. 가장 높은 점수를 가진 자동차의 이름들을 찾습니다.
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : raceResult.entrySet()) {
            if (entry.getValue() == maxScore) {
                winners.add(entry.getKey());
            }
        }
        return winners;
    }
}
