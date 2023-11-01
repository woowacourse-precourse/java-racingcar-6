package racingcar.domain;

import racingcar.exception.InvalidRacingCarNameLengthException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class racingCars {
    private static int racingCarNumber;
    private static List<racingCar> racingCarList;

    public racingCars(String racingCarNameString) {
        String[] racingCarNameArray = validateRacingCarNameFormat(racingCarNameString);
        racingCarNumber = racingCarNameArray.length;
        racingCarList = convertRacingCarFormat(racingCarNameArray);
    }

    private String[] validateRacingCarNameFormat(String racingCarNameString) {
        String[] racingCarNameArray = Arrays.stream(racingCarNameString.split(","))
                .map(String::strip)
                .toArray(String[]::new);

        // 5자 이상의 이름이 있는지 확인
        boolean hasFiveOrMoreCharacters = Arrays.stream(racingCarNameArray)
                .anyMatch(name -> name.length() > 5);

        if (hasFiveOrMoreCharacters) {
            throw new InvalidRacingCarNameLengthException();
        }
        return racingCarNameArray;
    }

    private List<racingCar> convertRacingCarFormat(String[] racingCarNameArray) {
        List<racingCar> playerRacingCarList = new ArrayList<>();
        for (String racingCarName : racingCarNameArray) {
            playerRacingCarList.add(new racingCar(racingCarName));
        }
        return playerRacingCarList;
    }

    public void race() {
        for (int i = 0; i < racingCarNumber; i++) {
            racingCarList.get(i).randomRace();
        }
    }

    public Map<String, Integer> getRacingCarRelayResult() {
        // <자동차 이름, 전진 정도> 변환
        return racingCarList.stream()
                .collect(Collectors.toMap(racingCar::getRacingCarName, racingCar::getForwardCount));
    }

    public String[] calculateWinners() {
        Map<String, Integer> racingCarRelayResult = getRacingCarRelayResult();

        // 최대 전진 정도 값 찾기
        int maxForward = racingCarRelayResult.values().stream()
                .max(Integer::compareTo)
                .orElse(0);

        // 전진 정도가 최대값을 가진 자동차 이름들만 가져와 String 배열로 반환
        return racingCarRelayResult.entrySet().stream()
                .filter(entry -> entry.getValue() == maxForward)
                .map(Entry::getKey)
                .toArray(String[]::new);
    }
}
