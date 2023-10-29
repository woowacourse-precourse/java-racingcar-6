package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.vo.CarName;
import racingcar.vo.RoundCount;

public class Controller {
    private final InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Racing racing = creatRacingByUserInput();
    }

    private Racing creatRacingByUserInput() {
        List<Car> carNameList = getCarList();
        RoundCount roundCount = getRoundCount();
        return new Racing(carNameList, roundCount);
    }

    private RoundCount getRoundCount() {
        return new RoundCount(inputView.inputRoundCount());
    }

    private List<Car> getCarList() {
        List<String> nameStringList = inputView.inputCarNameStrings();
        return nameStringList.stream()
                .map(CarName::new)
                .map(Car::new)
                .toList();
    }
}
