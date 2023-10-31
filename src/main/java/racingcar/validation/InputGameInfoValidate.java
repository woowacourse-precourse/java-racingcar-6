package racingcar.validation;

public class InputGameInfoValidate {

    public static void gameProgressNotValueValidate(String tryCount){
        if (!tryCount.matches("\\d+")) {
            throw new IllegalArgumentException("숫자가 아니거나 공백이 입력되었습니다.");
        }
    }
    public static void gameProgressCountThanZeroValidate(int tryCount){
        if(tryCount <= 0){
            throw new IllegalArgumentException("게임 횟수는 1 이상이여야 합니다.");
        }
    }
}
