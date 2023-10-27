package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.MoveStrategy;
import racingcar.domain.Player;
import racingcar.domain.RandomMoveStrategy;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;
    private final InputView inputView;
    private final OutputView outputView;
    private final Player player;

    public Controller(RandomNumberGenerator randomNumberGenerator, InputView inputView, OutputView outputView, Player player) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumberGenerator = randomNumberGenerator;
        this.player = player;
    }

    public void run() {
        initCars();
        inputView.requestRounds();
        int rounds = makeStringToNumber(player.getInput());
        playGame(rounds);
        List<Car> winners = getWinners();
        outputView.announceWinner(winners);
    }

    private void initCars() {
        inputView.requestCarNames();
        String names = player.getInput();
        validateNames(names);
        cars = Arrays.stream(names.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void playGame(int rounds) {
        for (int i = 0; i < rounds; i++) {
            playRound();
            List<CarDto> carStatus = CarDto.from(cars);
            outputView.printCarStatus(carStatus);
        }
    }

    private void playRound() {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.getNumber();
            MoveStrategy strategy = new RandomMoveStrategy(randomNumber);
            car.move(strategy);
        }
    }

    private List<Car> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
    }

    private int makeStringToNumber(String input) {
        return Integer.parseInt(input);
    }

    private void validateNames(String names) {
        String[] nameArray = names.split(",");

        for (String name : nameArray) {
            if (name.length() < 1 || name.length() > 5 || !name.matches("^[a-zA-Z]+$")) {
                throw new IllegalArgumentException();
            }
        }
    }

}