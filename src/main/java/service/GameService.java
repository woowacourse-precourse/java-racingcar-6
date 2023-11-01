package service;

import domain.Car;
import utils.MessageUtil;
import utils.RandomUtil;
import utils.TransformUtil;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    MessageUtil messageUtil = new MessageUtil();
    UserInputService userInputService = new UserInputService();

    public void run() {
        setGame();
    }

    private void setGame() {
        List<String> carNames = inputCarNames();
        Integer roundCnt = inputRoundCnt();
        List<Car> cars = setCarDomainGame(carNames);

        playGame(cars, roundCnt);
    }

    private void playGame(List<Car> cars, Integer roundCnt) {
        int cnt = 1;
        while (cnt <= roundCnt) {
            messageUtil.runGame();
            getRandomNumberMovementCar(cars);
            messageUtil.outPutEnter();
            cnt += 1;
        }

        getWinnerCar(cars);
    }

    private List<String> inputCarNames() {
        messageUtil.gameStart();
        return userInputService.carName();
    }

    private Integer inputRoundCnt() {
        messageUtil.tryGame();
        return userInputService.roundCnt();
    }

    private List<Car> setCarDomainGame(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        carNames.forEach(carName -> {
            Car car = new Car();
            car.initGame(carName);
            cars.add(car);
        });

        return cars;
    }

    private void getRandomNumberMovementCar(List<Car> cars) {
        cars.forEach(car -> {
            car.gameMovement(RandomUtil.getRandomNumber());
            messageUtil.outPutResultCarName(car.getName());
            messageUtil.outPut(TransformUtil.dashes(car.getPosition()));
        });
    }

    private void getWinnerCar(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        String winnerCarName = getWinnerCarName(cars, maxPosition);

        messageUtil.endGame();
        messageUtil.outPut(winnerCarName);
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private String getWinnerCarName(List<Car> cars, int maxPosition) {
        List<String> winnerCarNames = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        return TransformUtil.commasToString(winnerCarNames);
    }
}
