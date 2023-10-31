package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Winner;
import racingcar.exception.CountException;
import racingcar.exception.NameException;
import racingcar.service.GameService;
import racingcar.util.RandomNumber;
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
        String[] names = inputName();
        String number = inputTryCount();

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
            playRacing();
            count += 1;
        }

        gameResult();
    }

    private void playRacing() {
        carMove();
        String[] names = convertCarNames();
        String[] positions = convertCarPositionString();

        output.printRacing(names, positions);
    }

    private void gameResult() {
        Integer[] positions = convertCarPositions();
        Integer winnerPosition = service.getWinnerPosition(positions);
        String winners = resultRacingWinner(winnerPosition);

        output.printResult(winners);
    }

    private String[] inputName() {
        String nameInput = input.inputCarNames();
        String[] names = nameInput.split(",");

        NameException.validation(names);
        return names;
    }

    private String inputTryCount() {
        String number = input.inputTryCount();

        CountException.validation(number);
        return number;
    }

    private void carMove() {
        Integer number = RandomNumber.createRandomNumber();

        for (Car car : carList) {
            if (service.checkMovePossible(number)) {
                car.moveForward();
            }
        }
    }

    private String[] convertCarNames() {
        return carList.stream()
                .map(Car::getName)
                .toArray(String[]::new);
    }

    private String[] convertCarPositionString() {
        return carList.stream()
                .map(Car::getPositionString)
                .toArray(String[]::new);
    }

    private Integer[] convertCarPositions() {
        return carList.stream()
                .map(Car::getPosition)
                .toArray(Integer[]::new);
    }

    private String resultRacingWinner(Integer winnerPosition) {
        Winner winner = new Winner(winnerPosition);

        winner.judgeRacingWinner(carList);

        return winner.getWinners();
    }
}
