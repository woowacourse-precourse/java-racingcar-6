package racingcar;

public class MoveNum {
    int num;

    MoveNum(String num) {
        this.num = Character.getNumericValue(num.charAt(0));
    }
}
