package racingcar.domain;

import java.util.List;

public class GameController {
    public final String INIT_GAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final String INPUT_NUMBER_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";
    public final String GAME_RESULT_MESSAGE = "실행 결과";
    public void playGame() {
        InputCarName inputCarName = new InputCarName();
        InputNumberOfAttempts inputNumberOfAttempts = new InputNumberOfAttempts();
        RaceResultsPresenter raceResultsPresenter = new RaceResultsPresenter();

        System.out.println(INIT_GAME_MESSAGE);
        List<String> carNames = inputCarName.getCarNames();
        List<Car> cars = inputCarName.createCarsFromCarNames(carNames);

        System.out.println(INPUT_NUMBER_ATTEMPTS_MESSAGE);
        int numberOfAttempts = inputNumberOfAttempts.getNumberOfAttempts();

        System.out.println(GAME_RESULT_MESSAGE);
        do {
            for (Car car : cars){
                car.move();
            }
            raceResultsPresenter.printRaceProcess(cars);
        }
        while (numberOfAttempts-- != 0);

        raceResultsPresenter.printWinner(cars);
    }
}
