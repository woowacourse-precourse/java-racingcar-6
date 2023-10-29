package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.NumberConstant.*;

public class RacingService {
    private final CarRepository carRepository;
    private final List<Car> cars;
    private final int times;

    public RacingService(List<Car> cars, int times, CarRepository carRepository) {
        this.cars = cars;
        this.times = times;
        this.carRepository = carRepository;
    }

    public void gameProgress() {
        OutputView.gameStart();
        for (int i = 0; i < times; i++) {
            progressOnceTime();
        }
    }

    private void progressOnceTime() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber());
            carRepository.moveForward(car, randomValue);
            OutputView.gameProgress(car);
        }
        OutputView.skipLine();
    }

    public void gameResult() {
        int max = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCount() > max) {
                max = car.getCount();
                winners.clear();
            }
            if (max == car.getCount())
                winners.add(car.getName());
        }
        OutputView.gameResult(winners);
        Console.close();
    }
}
