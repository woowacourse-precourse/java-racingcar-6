package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.domain.driver.Driver;
import racingcar.domain.driver.RandomDriver;
import racingcar.dto.CarDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.CarName;
import racingcar.vo.RoundCount;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Driver randomDriver = new RandomDriver();

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Racing racing = creatRacingByUserInput();
        outputView.printStartResultMessage();
        while (!racing.isEnd()) {
            List<CarDTO> roundResult = racing.round();
            outputView.printRoundResult(roundResult);
        }
        outputView.printRaceResult(racing.getWinner());
    }

    private Racing creatRacingByUserInput() {
        List<Car> carNameList = getCarListByUser();
        RoundCount roundCount = getRoundCountByUser();
        return new Racing(carNameList, roundCount);
    }

    private RoundCount getRoundCountByUser() {
        return new RoundCount(inputView.inputRoundCount());
    }

    private List<Car> getCarListByUser() {
        List<String> nameStringList = inputView.inputCarNameStrings();
        return nameStringList.stream()
                .map(CarName::new)
                .map(name -> new Car(name, randomDriver))
                .toList();
    }
}
