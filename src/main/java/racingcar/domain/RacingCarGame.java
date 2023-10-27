package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
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
        output.printResultStartedMessage();
        while (!isFinish()) {
            moveCars();
            printCarsState();
        }

        printWinner();
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
        output.printCarNamesInputRequest();
        List<String> carNameList = input.getCarNames();
        carList = makeCarList(carNameList);

        output.printMoveCountInputRequest();
        remainMoveCount = input.getMoveCount();
    }

    private List<Car> makeCarList(List<String> carNames) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }
}