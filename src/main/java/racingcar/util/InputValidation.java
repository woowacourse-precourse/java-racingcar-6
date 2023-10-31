package racingcar.util;


public class InputValidation {
    private static final int MAX_NAME_LENGTH = 5;
    // 자동차 이름 검증 ㄱ. 5자 이하 ㄴ. notNull
    public void isVaildCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
        if(isOverMaxlength(carName)) {
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
    private boolean isOverMaxlength(String name) {
        return name.length() > 5;
    }
}
