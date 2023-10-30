package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Winner;
import racingcar.exception.CountException;
import racingcar.exception.NameException;
import racingcar.service.GameService;
import racingcar.view.PlayerInput;
import racingcar.view.ResultOutput;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final List<Car> carList = new ArrayList<>();
    private final PlayerInput input = new PlayerInput();
    private final ResultOutput output = new ResultOutput();
    private final GameService service = new GameService();
    private Integer tryCount;

    public void start() {
        String nameInput = input.inputCarNames();
        String[] names = nameInput.split(",");

        NameException.validation(names);

        String number = input.inputTryCount();

        CountException.validation(number);
        gameInit(names, number);
    }

    private void gameInit(String[] names, String number) {
        for (String name : names) {
            carList.add(new Car(name));
        }

        this.tryCount = Integer.parseInt(number);

        gameProcess();
    }

    private void gameProcess() {
        int count = 0;

        output.printAnnounce();

        while (count < tryCount) {
            carMove();
            String[] names = convertCarNames();
            String[] locations = convertCarLocationResults();
            output.printRacing(names, locations);
            count += 1;
        }

        gameResult();
    }

    private void gameResult() {
        Integer[] locations = convertCarLocations();
        Integer winnerLocation = service.getWinnerLocation(locations);

        Winner winner = new Winner(winnerLocation);

        winner.judgeRacingWinner(carList);

        String winnerNames = winner.getWinners();

        output.printResult(winnerNames);
    }

    private void carMove() {
        for (Car car : carList) {
            if (service.checkMovePossible()) {
                car.moveForward();
            }
        }
    }

    private String[] convertCarNames() {
        return carList.stream()
                .map(Car::getName)
                .toArray(String[]::new);
    }

    private String[] convertCarLocationResults() {
        return carList.stream()
                .map(Car::getLocationResult)
                .toArray(String[]::new);
    }

    private Integer[] convertCarLocations() {
        return carList.stream()
                .map(Car::getLocation)
                .toArray(Integer[]::new);
    }
}
