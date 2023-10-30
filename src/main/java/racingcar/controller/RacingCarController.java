package racingcar.controller;

import static racingcar.common.Constants.CAR_LIST_DIVIDER;
import static racingcar.common.Constants.CAR_NAME_REQUEST_MESSAGE;
import static racingcar.common.Constants.PLAY_COUNT_REQUEST_MESSAGE;
import static racingcar.common.Constants.PRINT_RESULT_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.util.StringUtil;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final RacingCarService racingCarService = new RacingCarService();

    public void start() {
        List<Car> carList = inputCarList();
        Integer playCount = inputPlayCount();
        play(carList, playCount);
    }

    private List<Car> inputCarList() {
        OutputView.printInfo(CAR_NAME_REQUEST_MESSAGE);

        List<String> carNames = StringUtil.splitByDelimiter(InputView.input(), CAR_LIST_DIVIDER);
        InputValidator.validateCarList(carNames);

        List<Car> carList = createCarList(carNames);
        return carList;
    }

    private List<Car> createCarList(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    private Integer inputPlayCount() {
        OutputView.printInfo(PLAY_COUNT_REQUEST_MESSAGE);

        Integer playCount = StringUtil.convertToNumber(InputView.input());
        InputValidator.validatePlayCount(playCount);

        return playCount;
    }

    private void play(List<Car> carList, Integer playCount) {
        OutputView.printInfo(PRINT_RESULT_MESSAGE);

        for (int i = 0; i < playCount; i++) {
            racingCarService.race(carList);
            OutputView.printResult(carList);
        }

        OutputView.printWinner(carList);
    }
}
