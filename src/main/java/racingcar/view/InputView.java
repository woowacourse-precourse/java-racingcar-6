package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.GameMessage;
import racingcar.utils.Util;
import racingcar.validation.CarInputValidation;
import racingcar.validation.MoveCountsValidation;


public class InputView {
    private final CarInputValidation carInputValidation;
    private final MoveCountsValidation moveCountsValidation;

    public InputView(CarInputValidation carInputValidation, MoveCountsValidation moveCountsValidation) {
        this.carInputValidation = carInputValidation;
        this.moveCountsValidation = moveCountsValidation;
    }

    public List<String> getCarNamesInput() {
        String carInput = receiveCarInput();
        validateCarInput(carInput);
        String[] carNamesArray = splitCarInputToArray(carInput);
        return convertArrayToList(carNamesArray);
    }

    private String receiveCarInput() {
        System.out.println(GameMessage.CAR_NAME_INPUT_REQUEST_MESSAGE);
        return Console.readLine();
    }

    private void validateCarInput(String carInput) {
        carInputValidation.validateCarInput(carInput);
    }

    private String[] splitCarInputToArray(String carInput) {
        return carInput.split(Util.CAR_NAME_DELIMITER);
    }

    private List<String> convertArrayToList(String[] array) {
        return Arrays.asList(array);
    }

    public int getMoveCountsInput() {
        String moveCountsInput = receiveMoveCountsInput();
        validateMoveCountsInput(moveCountsInput);
        return convertToInteger(moveCountsInput);
    }

    private String receiveMoveCountsInput() {
        System.out.println(GameMessage.MOVE_COUNTS_INPUT_REQUEST_MESSAGE);
        return Console.readLine();
    }

    private void validateMoveCountsInput(String moveCountsInput) {
        moveCountsValidation.validateMoveCountsInput(moveCountsInput);
    }

    private int convertToInteger(String moveCountsInput) {
        return Integer.parseInt(moveCountsInput);
    }
}
