package racingcar.controller;

import static racingcar.common.Constants.CAR_LIST_DIVIDER;
import static racingcar.common.Constants.CAR_NAME_REQUEST_MESSAGE;
import static racingcar.common.Constants.MAXIMUM_CAR_NAME_LENGTH;
import static racingcar.common.Constants.MINIMUM_PARTICIPANTS_NUMBER;

import java.util.List;
import racingcar.util.StringUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    public void start() {
        List<String> carList = inputCarList();
        validateCarList(carList);
    }

    private List<String> inputCarList() {
        OutputView.printInfo(CAR_NAME_REQUEST_MESSAGE);
        List<String> carList = StringUtil.splitByDelimiter(InputView.input(), CAR_LIST_DIVIDER);
        return carList;
    }

    private void validateCarList(List<String> carList) {
        checkMinimumParticipantsNumber(carList);
        checkLengthCondition(carList);
    }

    private void checkLengthCondition(List<String> carList) {
        for (String car : carList) {
            StringUtil.checkMaxLengthLimit(car, MAXIMUM_CAR_NAME_LENGTH);
        }
    }

    private void checkMinimumParticipantsNumber(List<String> carList) {
        if (carList.size() < MINIMUM_PARTICIPANTS_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
