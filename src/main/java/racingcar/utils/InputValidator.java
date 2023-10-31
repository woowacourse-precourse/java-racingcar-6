package racingcar.utils;

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Validator;

import java.util.Arrays;

public class InputValidator {
    private final String error = "올바르지 않은 입력값입니다.";
    public boolean validateTimes(String timesInput) {
        if(timesInput.matches(".*\\D.*")) throw new IllegalArgumentException(error);
        return true;
    }

    public boolean validateCars(String carsInput){
        String[] carsArr = carsInput.split(",");
        long max_length = Arrays.stream(carsArr)
                .filter(car->car.length()>5 || car.startsWith(" ") || car.endsWith(" "))
                .count();
        if(max_length>0) throw new IllegalArgumentException(error);
        return true;
    }
}
