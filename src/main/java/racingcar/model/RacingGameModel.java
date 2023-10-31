package racingcar.model;

public class RacingGameModel {

    public static final double FOUR = 4;

    // 8. 값이 4이상인지 확인하는 기능
    public boolean isSameOrBiggerThanFour(int number){
        if(number >= FOUR){
            return true;
        } else {
            return false;
        }
    }
}
