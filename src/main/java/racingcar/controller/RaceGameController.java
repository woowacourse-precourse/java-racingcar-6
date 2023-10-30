package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceGameController {

    private static final String CAR_NAMES_ASK_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_COUNT_ASK_MESSAGE = "시도할 회수는 몇회인가요?";
    private final InputView inputView;
    private final OutputView outputView;

    public RaceGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Race race = new Race(getCars(), getGameCount());
        List<Car> winners = playRaceGame(race);
        outputView.writeWinners(winners);
    }

    private List<Car> playRaceGame(Race race) {
        while(race.hasNextRound()) {
            race.playOneRound();
            outputView.writeOneRoundResult(race.getCars());
        }

        return race.getWinners();
    }

    private Cars getCars() {
        outputView.writeNewlineMessage(CAR_NAMES_ASK_MESSAGE);
        return convertCars(inputView.readCarNamesInput());
    }

    private int getGameCount() {
        outputView.writeNewlineMessage(GAME_COUNT_ASK_MESSAGE);
        return inputView.readUserGameCountInput();
    }

    private Cars convertCars(List<String> carNames) {
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();

        return new Cars(carList);
    }
}
