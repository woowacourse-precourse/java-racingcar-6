package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.OutputMessage;

public class MoveOrStopCar {
    private Integer ramdomStartNumber = 0;
    private Integer ramdomEndNumber = 9;
    OutputMessage outputMessage = new OutputMessage();

    public void moveOrStopCarsForGivenTimes(Integer numberOfTimes, List<Car> cars) {
        for (int item = 0; item < numberOfTimes; item++) {
            for (Car car : cars) {
                conditionAdvancing(car);
            }
            outputMessage.printMovingCarNames(cars);
        }
        outputMessage.printWinnerAfterRaceCompletion(cars);
    }

    private void conditionAdvancing(Car car) {
        Integer randomValue = Randoms.pickNumberInRange(ramdomStartNumber, ramdomEndNumber);

        if (randomValue >= 4) {
            car.setMoveNumber(car.getMoveNumber() + 1);
        }
    }

    public void setRamdomStartNumber(Integer ramdomStartNumber) {
        this.ramdomStartNumber = ramdomStartNumber;
    }

    public void setRamdomEndNumber(Integer ramdomEndNumber) {
        this.ramdomEndNumber = ramdomEndNumber;
    }
}
