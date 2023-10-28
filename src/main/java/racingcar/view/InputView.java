package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.AppConfig;
import racingcar.validator.Validator;

public class InputView {
    AppConfig appConfig = new AppConfig();
    OutputView outputView = appConfig.outputView();

    public String inputCarsName() {
        outputView.printInputCarsNameMessage();
        return Console.readLine();
    }

    public int inputTotalRound() {
        outputView.printInputTotalRoundMessage();
        String totalRound = Console.readLine();
        Validator totalRoundValidatorValidator = appConfig.totalRoundValidator();
        totalRoundValidatorValidator.validate(totalRound);
        return Integer.parseInt(totalRound);
    }
}
