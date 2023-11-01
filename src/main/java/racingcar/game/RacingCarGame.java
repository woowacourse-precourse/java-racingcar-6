package racingcar.game;

import java.util.List;

import racingcar.car.CarCollection;
import racingcar.constant.RacingCarGameText;
import racingcar.input.InputView;
import racingcar.number.TryCount;
import racingcar.output.OutputView;

public class RacingCarGame {

    private CarCollection racingCarCollection;
    private TryCount racingCarTryCount;
    private static final int ALLOW_EMPTY_CARNAME_OPTION = -1;

    public RacingCarGame() {
        this.racingCarCollection = CarCollection.initCarCollect();
        this.racingCarTryCount = TryCount.fromInteger(0);
    }

    public void addRacingCar(String carNames) {
        List<String> carNameStringList = getCarNameStringList(carNames);

        carNameStringList.stream()
                .map(String::strip)
                .forEach(carNameString -> this.racingCarCollection.addFromString(carNameString));
    }

    private List<String> getCarNameStringList(String carNames) {
        return List.of(carNames.split(RacingCarGameText.RACINGCAR_SPLIT_DELIMITER, ALLOW_EMPTY_CARNAME_OPTION));
    }

    public CarCollection getCarCollection() {
        return this.racingCarCollection;
    }

    public void setTryCount(String number) {
        this.racingCarTryCount = TryCount.fromString(number);
    }

    public TryCount getTryCount() {
        return this.racingCarTryCount;
    }

    public String getCarNameFromPrompt() {
        OutputView.printRequestMultipleCarName();
        return InputView.inputCarsName();
    }

    public String getTryCountFromPrompt() {
        OutputView.printRequestTryCount();
        return InputView.inputTryCount();
    }

    public void displayRacingCarGameResult() {
        OutputView.printNewLine();
        OutputView.printExecuteResult();
    }

    public void displayCurrentCarStatus() {
        this.racingCarCollection.batchDisplayCarStatus();
        OutputView.printNewLine();
    }

    public void displayWinners() {
        OutputView.printFormatFinalWinner(this.racingCarCollection.getMaxLocationCarName());
    }

    public void play() {
        addRacingCar(getCarNameFromPrompt());
        setTryCount(getTryCountFromPrompt());
        displayRacingCarGameResult();
        while (!racingCarTryCount.isFinished()) {
            racingCarCollection.batchMoveCarOnRandomCondition();
            displayCurrentCarStatus();
            racingCarTryCount.consumeTry();
        }
        displayWinners();
    }
}
