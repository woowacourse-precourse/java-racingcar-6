package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.utils.Parser;
import racingcar.view.InputMessage;
import racingcar.vo.TryTime;

import java.util.List;

public class RacingService {

    private CarRepository carRepository = new CarRepository();

    public void initializeGame() {
        inputCarName();
    }

    public TryTime inputTryTimes() {
        InputMessage.printTryTimesInputMessage();
        int time = Parser.parseTryTimesInput(Console.readLine());
        return new TryTime(time);
    }

    private void inputCarName() {
        InputMessage.printCarNameInputMessage();
        List<String> carNames = Parser.parseCarNameInput(Console.readLine());
        generateCar(carNames);
    }

    private void generateCar(List<String> carNames) {
        for (String carName : carNames) {
            carRepository.add(new Car(carName));
        }
    }
}
