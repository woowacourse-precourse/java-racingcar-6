package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.NumberConstant.*;

public class RacingService {
    private final OutputView outputView;
    private final CarRepository carRepository;
    private final List<Car> cars;
    private final int times;

    public RacingService(List<Car> cars, int times, OutputView outputView, CarRepository carRepository) {
        this.cars = cars;
        this.times = times;
        this.outputView = outputView;
        this.carRepository = carRepository;
    }

    public void gameProgress() {
        outputView.gameStart();
        for (int i = 0; i < times; i++) {
            progressOnceTime();
        }
    }

    private void progressOnceTime() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber());
            carRepository.moveForward(car, randomValue);
            outputView.gameProgress(car);
        }
        outputView.skipLine();
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
        outputView.gameResult(winners);
    }
}
