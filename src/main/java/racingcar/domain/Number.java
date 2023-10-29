package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    private int number;

    private Number(int randomNumber) {
        this.number = randomNumber;
    }
    public static Number generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return new Number(randomNumber);
    }
    // For later Usage
    //    private Number(String userInput) {
//        validate userInput
//        this.number = convertedNumber
//    }
//    public static Number inputPlayerNumber() {
//        String userInput = askHowManyRoudns();
//        return new Number(userInput);
//    }

    public boolean isEqualOrGreaterThanFour(Number generatedRandomNumber) {
        return false;
    }
}
