package racingcar.model;

import java.util.*;
import java.util.stream.Stream;

public class Cars {
    private List<String> carNames;
    private Map<String, Integer> carScores;

    private static final int CAR_NAME_MAX_LENGTH = 5;

    public Cars() {
        carScores = new HashMap<String, Integer>();
    }

    public void addCar(String carsName){
        this.carNames = Arrays.asList(carsName.split(","));
        validate(this.carNames);
        this.carNames.forEach(carName -> carScores.put(carName, 0));
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public Map<String, Integer> getCarScores() {
        return carScores;
    }



    public void increaseCarScore(String carName) {
        int score = carScores.get(carName) + 1;
        carScores.put(carName, score);
    }

    private void validate(List<String> carsName) {
        validateCarNamesLength(carsName);
        validateCarNamesNotNull(carsName);
        validateCarNamesNotDuplication(carsName);
    }

    private void validateCarNamesLength(List<String> carsName) {
        if(carsName.stream().anyMatch(carName -> carName.length() > CAR_NAME_MAX_LENGTH))
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 넘어갔습니다.");
    }

    private void validateCarNamesNotNull(List<String> carsName) {
        if(carsName.stream().anyMatch(carName -> carName == null))
            throw new IllegalArgumentException("자동차의 이름이 null 입니다.");
    }

    private void validateCarNamesNotDuplication(List<String> carsName) {
        HashSet<String> Set = new HashSet<>(carsName);

        if (Set.size() < carsName.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 중복됐습니다.");
        }
    }
}
