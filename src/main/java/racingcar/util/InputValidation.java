package racingcar.util;


public class InputValidation {
    private static final int MAX_NAME_LENGTH = 5;
    public void isVaildCarName(String inputCarNames, String[] arrCarNames) {
        if (inputCarNames.isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
        if(isOverMaxlength(arrCarNames)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이내로 입력해야 합니다");
        }
    }
    public void isVaildGameRound(String gameRound) {
        if (gameRound.isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
        if (isNotIntType(gameRound)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
    private boolean isNotIntType(String gameRound) {
        try{
            Integer.parseInt(gameRound);
            return false;
        }catch(Exception e){
            return true;
        }
    }
    private boolean isOverMaxlength(String[] arrCarNames) {
        boolean result = false;
        for (String carNames : arrCarNames) {
            result = carNames.length() > 5;
            return result;
        }
        return result;
    }
}
