package racingcar.controller;

import static racingcar.common.Constants.CAR_LIST_DIVIDER;
import static racingcar.common.Constants.CAR_NAME_REQUEST_MESSAGE;
import static racingcar.common.Constants.PLAY_COUNT_REQUEST_MESSAGE;

import java.util.List;
import racingcar.service.RacingCarService;
import racingcar.util.StringUtil;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final RacingCarService racingCarService = new RacingCarService();

    public void start() {
        List<String> carList = inputCarList();

        OutputView.printInfo(PLAY_COUNT_REQUEST_MESSAGE);
    }

    public List<String> inputCarList() {
        OutputView.printInfo(CAR_NAME_REQUEST_MESSAGE);
        List<String> carList = StringUtil.splitByDelimiter(InputView.input(), CAR_LIST_DIVIDER);
        InputValidator.validateCarList(carList);
        return carList;
    }
}
