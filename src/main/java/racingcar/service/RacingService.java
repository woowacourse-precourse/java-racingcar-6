package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.utils.Parser;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;
import racingcar.vo.TryTime;

import java.util.List;

public class RacingService {

    private CarRepository carRepository = new CarRepository();

    public void initializeGame() {
        inputCarName();
    }

    public void play() {
        TryTime tryTime = inputTryTimes();
        OutputMessage.printPlayOutputMessage();
        for (int i = 0; i < tryTime.getTime(); i++) {
            progressRacing();
        }
    }

    private void progressRacing() {
        for (Car car : carRepository.getCarList()) {
            if (isBiggerThanFour(getRandomValue())) {
                car.increaseDistance();
            }
            OutputMessage.printRacingProgressOutputMessage(car);
        }
    }

    private int getRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }
    
    private boolean isBiggerThanFour(int number) {
        return number >= 4;
    }

    private TryTime inputTryTimes() {
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
