package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Validator;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.constant.Constant.*;
import static racingcar.constant.ErrorMessage.DUPLICATED_CAR_NAME;
import static racingcar.constant.ErrorMessage.INVALID_ROUNDS_VALUE;

public class GameView {

    private final Validator validator;

    public GameView() {
        this.validator = new Validator();
    }

    public List<String> inputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        List<String> nameList = Arrays.asList(readLine().split(","));

        if (validator.isUniqueName(nameList)) return nameList;
        else throw new IllegalArgumentException(DUPLICATED_CAR_NAME);
    }

    public int inputRounds() {
        System.out.println(INPUT_ROUNDS__MESSAGE);
        String inputValue = readLine();

        if (validator.isNumberic(inputValue)) return Integer.parseInt(inputValue);
        else throw new IllegalArgumentException(INVALID_ROUNDS_VALUE);
    }

    public void getRaceResult() {
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public void getMovingResult(Car car) {
        System.out.println(car.getName() + " : " + car.getMovement());
    }

    public void getRaceWinner(List<String> winnerName) {
        System.out.println(RACE_WINNER_MESSAGE + String.join(", ", winnerName));
    }
}