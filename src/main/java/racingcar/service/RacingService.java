package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.ResultRepository;
import racingcar.utils.Parser;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;
import racingcar.vo.TryTime;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingService {

    public static final int MAX_BIGGER_NUMBER = 4;
    public static final int PICK_MIN_NUMBER = 0;
    public static final int PICK_MAX_NUMBER = 9;
    private CarRepository carRepository = new CarRepository();
    private ResultRepository resultRepository = new ResultRepository();

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

    public void chooseWinner() {
        List<Integer> distanceList = carRepository.getCarList().stream().map(Car::getDistance).collect(Collectors.toList());
        int maxDistance = Collections.max(distanceList);

        for (Car car : carRepository.getCarList()) {
            selectWinner(maxDistance, car);
        }
        OutputMessage.printResultOutputMessage(resultRepository.getResultList());
    }

    private void selectWinner(int maxDistance, Car car) {
        if (car.getDistance() == maxDistance) {
            resultRepository.add(car);
        }
    }

    private void progressRacing() {
        for (Car car : carRepository.getCarList()) {
            if (isBiggerThanFour(getRandomValue())) {
                car.increaseDistance();
            }
        }
        OutputMessage.printRacingProgressOutputMessage(carRepository.getCarList());
    }

    private int getRandomValue() {
        return Randoms.pickNumberInRange(PICK_MIN_NUMBER, PICK_MAX_NUMBER);
    }
    
    private boolean isBiggerThanFour(int number) {
        return number >= MAX_BIGGER_NUMBER;
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
