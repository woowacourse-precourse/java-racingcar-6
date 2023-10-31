package racingcar;

import java.util.*;
public class Validator {
    private Set<String> nameSet;
    private final StringBuilder carNames = new StringBuilder();

    public String checkCarValidate(String names){
        nameSet = new HashSet<>();
        String[] cars = validateNameCount(names);
        for (String car: cars){
            validateName(car);
            validateFiveWords(car);
            validateSameName(car);

            carNames.append(car).append(",");
        }
        return carNames.toString();
    }

    public int checkRaceValidate(String race){
        if (race.isEmpty() || isNotInteger(race)){
            throw new IllegalArgumentException("1 이상의 숫자를 입력해 주세요.");
        }
        return Integer.parseInt(race);
    }

    public static boolean isNotInteger(String race){
        try{
            Integer.parseInt(race);
            return false;
        }catch (NumberFormatException numberFormatException){
            return true;
        }
    }

    public String[] validateNameCount(String names){
        if (Arrays.stream(names.split(",")).count()<=1){
            throw new IllegalArgumentException("자동차가 한 대 밖에 없습니다.");
        }
        return names.split(",");
    }
    public void validateName(String name){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 비어 있습니다.");
        }
    }

    public void validateFiveWords(String name){
        if (name.length() > 5){
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public void validateSameName(String name){
        if (!nameSet.add(name)){
            throw new IllegalArgumentException("동일한 이름이 존재합니다.");
        }
    }
}
