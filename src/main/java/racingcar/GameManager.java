package racingcar;

import java.util.List;
import racingcar.domain.Referee;
import racingcar.domain.driver.Car;
import racingcar.domain.driver.Driver;
import racingcar.input.Input;
import racingcar.output.Output;

public class GameManager {

    private final Input input;
    private final Output output;

    public GameManager(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        List<Car> cars = createCars();
        List<Driver> drivers = cars.stream()
                .map(Driver::new)
                .toList();
        race(drivers);

        announceRacingWinner(cars);
    }

    private List<Car> createCars() {
        output.outputMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        List<String> racingCarNames = input.inputRacingCarNames();
        return racingCarNames.stream()
                .map(Car::new)
                .toList();
    }

    private void race(List<Driver> drivers) {
        output.outputMessage("시도할 회수는 몇회인가요?\n");
        int movementForwardCount = input.inputMovementForwardCount();

        output.outputMessage("실행 결과\n");
        for (int count = 0; count < movementForwardCount; count++) {
            for (Driver driver : drivers) {
                String movementResultMessage = driver.commandMovement();
                output.outputMessage(movementResultMessage + "\n");
            }
            output.outputMessage("\n");
        }
    }

    private void announceRacingWinner(List<Car> cars) {
        Referee referee = new Referee();
        String racingWinner = referee.announceRacingWinner(cars);
        output.outputMessage(racingWinner);
    }

}
