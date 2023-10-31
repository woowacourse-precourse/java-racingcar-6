package racingcar.validation;

public class InputGameInfoValidate {
    public static void gameProcessCountValidate(int tryCount){
        if(tryCount <= 0){
            throw new IllegalArgumentException("게임 횟수는 1 이상이여야 합니다.");
        }
    }
}
