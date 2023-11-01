package racingcar.view;

import racingcar.utils.validator.CarNamesInputValidator;
import racingcar.utils.validator.TotalRoundInputValidator;

public class InputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TOTAL_ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final Input input;

    public InputView(Input input) {
        this.input = input;
    }

    public String readCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String carNamesInput = input.readCarNameLine();
        CarNamesInputValidator.validate(carNamesInput);
        return carNamesInput;
    }

    public int readTotalRound() {
        System.out.println(TOTAL_ROUND_INPUT_MESSAGE);
        String totalRound = input.readTotalRoundLine();
        TotalRoundInputValidator.validate(totalRound);
        return Integer.parseInt(totalRound);
    }
}
