package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarStateDto;

public class RacingCarGame {
    private Input input;
    private Output output;
    private Referee referee;
    private int remainMoveCount;
    private List<Car> carList;

    public RacingCarGame() {
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
        this.referee = new Referee();
    }

    public void start() {
        getInput();
        makeResult();
        printWinner();
    }

    private void makeResult() {
        output.printResultStartedMessage();
        while (!isFinish()) {
            moveCars();
            printCarsState();
        }
    }

    private void printWinner() {
        List<CarStateDto> carStateDtoList = CarStateDto.makeDto(carList);
        List<String> winnerNameList = referee.getWinner(carStateDtoList);
        output.printWinner(winnerNameList);
    }

    private void printCarsState() {
        List<CarStateDto> carStateDtoList = CarStateDto.makeDto(carList);
        output.printCarsState(carStateDtoList);
    }

    private void moveCars() {
        for (Car car : carList) {
            car.moveOrStop();
        }
        remainMoveCount--;
    }

    private boolean isFinish() {
        return (remainMoveCount == 0);
    }

    private void getInput() {
        getCarNamesInput();
        getMoveCountInput();
    }

    private void getCarNamesInput() {
        output.printCarNamesInputRequest();
        List<String> carNameList = input.getCarNames();

        carList = carNameList.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    private void getMoveCountInput() {
        output.printMoveCountInputRequest();
        remainMoveCount = input.getMoveCount();
    }
}