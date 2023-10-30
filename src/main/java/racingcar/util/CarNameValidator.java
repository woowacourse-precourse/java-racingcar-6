package racingcar.util;

public class CarNameValidator {
    private final String REGEX = "^[a-zA-Z]+$";
    private final String SEPARATOR = ",";
    private final int LIMIT_LENGTH = 5;
    private String[] allCarNames;
    public boolean check(String carNames) {
        if(isNull(carNames) && isSize(carNames) && isString()){
            return true;
        }
        throw new IllegalArgumentException("올바르지 차 이름 입력입니다.");
    }

    private boolean isString() {
        for(int index = 0; index < allCarNames.length; index++){
            if(!allCarNames[index].matches(REGEX)){
                return false;
            }
        }
        return true;
    }

    private boolean isSize(String carNames) {
        allCarNames = carNames.split(SEPARATOR);

        for (String allCarName : allCarNames) {
            if (allCarName.isEmpty() || allCarName.length() > LIMIT_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private boolean isNull(String carNames) {
        return carNames != null && !carNames.trim().isEmpty();
    }
}
