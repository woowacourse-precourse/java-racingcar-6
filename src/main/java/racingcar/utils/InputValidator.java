package racingcar.utils;

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Validator;

import java.util.Arrays;
import java.util.StringTokenizer;

public class InputValidator {
    private final String error = "올바르지 않은 입력값입니다.";
    public boolean validateTimes(String timesInput) {
        if(timesInput.matches(".*\\D.*")) throw new IllegalArgumentException(error);
        return true;
    }

    public boolean validateCars(String carsInput){
        String tmp  = carsInput.replaceAll(",","")
                .trim();
        if(tmp.length()==0) throw new IllegalArgumentException(error);
        String[] inputArr = carsInput.split(",");
        for(String s:inputArr){
            if(s.length()==0 || s.length()>5) throw new IllegalArgumentException(error);
            if(s.startsWith(" ")||s.endsWith(" ")) throw new IllegalArgumentException(error);
        }
        return true;
    }
}
