package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validation.CarInputValidation;
import racingcar.validation.MoveCountsValidation;


public class InputView {
    CarInputValidation carInputValidation = new CarInputValidation();
    MoveCountsValidation moveCountsValidation = new MoveCountsValidation();

    public List<String> getCarNamesInput() {
        String carInput = receiveCarInput();
        validateCarInput(carInput);
        return splitCarInput(carInput);
    }

    private String receiveCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private void validateCarInput(String carInput) {
        carInputValidation.validateCarInput(carInput);
    }

    private List<String> splitCarInput(String carInput) {
        String[] carsList = carInput.split(",");
        return Arrays.asList(carsList);
    }

    public int getMoveCountsInput() {
        String moveCountsInput = receiveMoveCountsInput();
        validateMoveCountsInput(moveCountsInput);
        return convertToInteger(moveCountsInput);
    }

    private String receiveMoveCountsInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    private void validateMoveCountsInput(String moveCountsInput) {
        moveCountsValidation.validateMoveCountsInput(moveCountsInput);
    }

    private int convertToInteger(String moveCountsInput) {
        return Integer.parseInt(moveCountsInput);
    }

}
