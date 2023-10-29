package racingcar;

public class CarNum {
    int num;

    CarNum(String[] carNameParsing) {
        this.num = carNameParsing.length;
    }

    boolean isInRange(int currentNum) {
        return (num > currentNum);
    }
}
