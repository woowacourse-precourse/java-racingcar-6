package racingcar.util;

import java.util.HashSet;

public class CarNameValidator {
    private String[] allCarNames;
    public boolean check(String carNames) {
        return isNull(carNames) && isSize(carNames) && isString() && isDuplicate();
    }

    private boolean isDuplicate() {
        HashSet<String> dedupe = new HashSet<>();

        for(String name : allCarNames){
            if(!dedupe.contains(name)){
                dedupe.add(name);
                continue;
            }
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
        return true;
    }

    private boolean isString() {
        for (String allCarName : allCarNames) {
            String regex = "^[a-zA-Z]+$";
            if (!allCarName.matches(regex)) {
                throw new IllegalArgumentException("순수 문자열이 아닙니다.");
            }
        }
        return true;
    }

    private boolean isSize(String carNames) {
        allCarNames = carNames.split(",");

        for (String carName : allCarNames) {
            int limit = 5;
            if (carName.isEmpty() || carName.length() > limit) {
                throw new IllegalArgumentException("문자열 길이가 5글자를 초과했습니다.");
            }
        }
        return true;
    }

    private boolean isNull(String carNames) {
        if(carNames != null && !carNames.trim().isEmpty()){
            return true;
        }
        throw new IllegalArgumentException("문자열이 비어있습니다.");
    }
}
