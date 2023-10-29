package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.repository.CarRepository;

import java.util.List;

public class GameController {
    private CarRepository carRepository;
    private int gameCount = 0;

    public GameController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public int getGameCount() {
        return this.gameCount;
    }

    public void executeGameStep() {
        List<Car> cars = carRepository.findAll();
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.moveForward();
            }
        }
    }

    public String getCarWithMaxPosition() {
        List<Car> cars = carRepository.findAll();
        int maxPosition = -1; // 최대 위치 변수를 초기화
        String carWithMaxPosition = ""; // 최대 위치를 가진 자동차 이름 초기화

        for (Car car : cars) {
            int currentPosition = car.getPosition();
            if (currentPosition > maxPosition) {
                maxPosition = currentPosition;
                carWithMaxPosition = car.getName();
            } else if (currentPosition == maxPosition) {
                // 공동 우승일 경우 처리
                carWithMaxPosition += ", " + car.getName();
            }
        }

        return carWithMaxPosition;
    }
}
