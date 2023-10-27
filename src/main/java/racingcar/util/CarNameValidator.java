package racingcar.util;

public class CarNameValidator {
    final String regex = "^[a-zA-Z]+$";
    String[] allCarNames;
    public boolean check(String carNames) {
        if(isNull(carNames) && isSize(carNames) && isString()){
            return true;
        }
        throw new IllegalArgumentException("올바르지 않은 입력입니다.");
    }

    private boolean isString() {
        for(int index = 0; index < allCarNames.length; index++){
            if(!allCarNames[index].matches(regex)){
                return false;
            }
        }

        return true;
    }

    private boolean isSize(String carNames) {
        allCarNames = carNames.split(",");

        for(int index = 0; index < allCarNames.length; index++){
            if(allCarNames[index].length() < 1 || allCarNames[index].length() > 5){
                return false;
            }
        }
        return true;
    }

    private boolean isNull(String carNames){
        return !carNames.isEmpty();
    }
}
