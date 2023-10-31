package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.AppConfig;
import racingcar.validator.Validator;

public class InputView {
    AppConfig appConfig = new AppConfig();
    OutputView outputView = appConfig.outputView();

    public String inputCarsName() {
        outputView.printCarsNameInputMessage();
        return Console.readLine();
    }

    public int inputTotalRound() {
        outputView.printTotalRoundInputMessage();
        String totalRound = Console.readLine();
        Validator totalRoundValidator = appConfig.totalRoundValidator();
        totalRoundValidator.validate(totalRound);
        return Integer.parseInt(totalRound);
    }
}
