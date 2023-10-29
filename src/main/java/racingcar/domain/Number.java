package racingcar.domain;

import static racingcar.view.InputView.askHowManyRounds;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    private Integer number;

    private Number(int randomNumber) {
        this.number = randomNumber;
    }
    public static Number generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return new Number(randomNumber);
    }

    private Number(String userInput) {
        this.number = convertStringToInt(userInput);
    }
    public static Number inputUserRounds() {
        String userInput = askHowManyRounds();
        return new Number(userInput);
    }

    public boolean isEqualOrGreaterThanFour() {
        return this.number >= 4;
    }

    private Integer convertStringToInt(String userInput) {
        return Integer.valueOf(userInput);
    }

}
