package racingcar.validation;

public class InputGameInfoValidate {

    public static void gameProgressCountAlphaValidate(String tryCount){
        if (!tryCount.matches("\\d+")) {
            throw new IllegalArgumentException("게임 횟수는 숫자로만 입력되어야 합니다.");
        }
    }
    public static void gameProgressCountThanZeroValidate(int tryCount){
        if(tryCount <= 0){
            throw new IllegalArgumentException("게임 횟수는 1 이상이여야 합니다.");
        }
    }
}
