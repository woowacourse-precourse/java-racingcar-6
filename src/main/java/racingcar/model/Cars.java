package racingcar.model;

import java.util.*;
import java.util.stream.Stream;

public class Cars {
    List<String> carsName;
    Map<String, Integer> carsScore;

    private static final int CAR_NAME_MAX_LENGTH = 5;

    public Cars() {
        carsScore = new HashMap<String, Integer>();
    }

    public void addCar(String carsName){
        this.carsName = Arrays.asList(carsName.split(","));
        validate(this.carsName);
        this.carsName.forEach(carName -> carsScore.put(carName, 0));
    }


    private void validate(List<String> carsName) {
        validateCarsNameLength(carsName);
        validateCarsNameNotNull(carsName);
        validateCarsNameNotDuplication(carsName);
    }

    private void validateCarsNameLength(List<String> carsName) {
        if(carsName.stream().anyMatch(carName -> carName.length() > CAR_NAME_MAX_LENGTH))
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 넘어갔습니다.");
    }

    private void validateCarsNameNotNull(List<String> carsName) {
        if(carsName.stream().anyMatch(carName -> carName == null))
            throw new IllegalArgumentException("자동차의 이름이 null 입니다.");
    }

    private void validateCarsNameNotDuplication(List<String> carsName) {
        HashSet<String> Set = new HashSet<>(carsName);

        if (Set.size() < carsName.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 중복됐습니다.");
        }
    }
}
