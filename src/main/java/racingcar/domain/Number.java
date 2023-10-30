package racingcar.domain;

import static racingcar.util.GameConfig.LAST_ROUND;
import static racingcar.util.GameConfig.MAX_NUMBER;
import static racingcar.util.GameConfig.MIN_NUMBER;
import static racingcar.util.GameConfig.MOVE_FORWARD_THRESHOLD;
import static racingcar.util.Validator.*;
import static racingcar.view.InputView.askHowManyRounds;
import static racingcar.util.Utils.convertStringToInt;


import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    private int number;

    private Number(int randomNumber) {
        this.number = randomNumber;
    }

    public static Number generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue());
        return new Number(randomNumber);
    }

    private Number(String userInput) {
        validateEmpty(userInput);
        validateInteger(userInput);
        validatePositive(userInput);

        this.number = convertStringToInt(userInput);
    }

    public static Number inputUserRounds() {
        String userInput = askHowManyRounds();
        return new Number(userInput);
    }

    public boolean isEqualOrGreaterThanFour() {
        return this.number >= MOVE_FORWARD_THRESHOLD.getValue();
    }

    public boolean hasRemainRound() {
        number--;
        return number >= LAST_ROUND.getValue();
    }

}
