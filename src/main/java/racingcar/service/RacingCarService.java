package racingcar.service;

import static racingcar.common.Constants.CAR_LIST_DIVIDER;
import static racingcar.common.Constants.CAR_NAME_REQUEST_MESSAGE;

import java.util.List;
import racingcar.util.StringUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarService {
    public List<String> inputCarList() {
        OutputView.printInfo(CAR_NAME_REQUEST_MESSAGE);
        List<String> carList = StringUtil.splitByDelimiter(InputView.input(), CAR_LIST_DIVIDER);
        return carList;
    }
}
