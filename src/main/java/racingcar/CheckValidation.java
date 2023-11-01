package racingcar;

public class CheckValidation {
    public static void validateName(String[] carNames){
        for(String carName:carNames){
            if(carName.length() > 5){
                throw new IllegalArgumentException("5자리 이하로 입력해주세요.");
            }
        }
    }
    public static void validateNum(String roundNum){
        try {
            Integer.parseInt(roundNum);
        }catch (Exception e){
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }

    public static void validateZero(String roundNum){
        if(Integer.parseInt(roundNum) == 0){
            throw new IllegalArgumentException("1 이상의 숫자를 입력하세요.");
        }
    }
}
