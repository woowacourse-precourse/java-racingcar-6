package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.dto.CarsStatus;
import racingcar.domain.dto.TotalRacingResult;
import racingcar.utill.NumberGenerator;

public class CarRacingService {
    private final NumberGenerator numberGenerator;

    public CarRacingService() {
        this.numberGenerator = new RandomNumberGenerator();
    }

    public TotalRacingResult race(String carsName, int attemptNumber) {
        Cars cars = new Cars(convertStringToCarList(carsName), numberGenerator);
        return getTotalRacingResult(cars, attemptNumber);
    }

    private List<Car> convertStringToCarList(String carsName) {
        List<Car> cars = new ArrayList<>();
        String[] splitName = carsName.split(",", -1);

        for (String name : splitName) {
            cars.add(new Car(name));
        }
        
        return cars;
    }

    private TotalRacingResult getTotalRacingResult(Cars cars, int attemptNumber) {
        List<CarsStatus> carsStatus = new ArrayList<>();
        for (int i = 0; i < attemptNumber; i++) {
            carsStatus.add(cars.decisionCarsMove());
        }

        return TotalRacingResult.of(carsStatus, cars.findWinner());
    }
}
