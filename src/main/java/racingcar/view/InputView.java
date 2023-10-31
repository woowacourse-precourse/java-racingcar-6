package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.Constants;
import racingcar.utils.GameMessage;
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
        return splitCarInput(carInput);
    }

    private String receiveCarInput() {
        System.out.println(GameMessage.CAR_NAME_INPUT_REQUEST_MESSAGE);
        return Console.readLine();
    }

    private void validateCarInput(String carInput) {
        carInputValidation.validateCarInput(carInput);
    }

    private List<String> splitCarInput(String carInput) {
        String[] carsList = carInput.split(Constants.CAR_NAME_DELIMITER);
        return Arrays.asList(carsList);
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
