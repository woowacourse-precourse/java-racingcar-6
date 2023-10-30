package racingcar.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    }

    private void validateCarsNameLength(List<String> carsName) {
        if(carsName.stream().anyMatch(carName->carName.length() > CAR_NAME_MAX_LENGTH))
            throw new IllegalArgumentException("문자열의 길이가 5를 넘어갔습니다.");
    }
}
