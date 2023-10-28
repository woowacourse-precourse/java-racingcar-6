package racingcar.domain.car.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.car.Car;
import racingcar.domain.car.dao.CarRepository;
import racingcar.domain.car.view.CarOutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarService {

    private final CarRepository carRepository = new CarRepository();

    public void saveCars(List<String> carNames) {
        saveCar(createCars(carNames));
    }

    private void saveCar(List<Car> cars) {
        cars.forEach(carRepository::save);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

//    public void startGame(int tryCount) {
//        CarOutputView.printResult();
//        for (int i = 0; i < tryCount; i++) {
////            int randomNumber = Randoms.pickNumberInRange(0, 9);
//            List<Car> findCars = carRepository.findAll();
//
//            findCars.forEach(car -> car.updatePosition(getRandomNumber()));
//            findCars.forEach(System.out::print);
//            System.out.println();
//
//        }
//    }

    public List<String> getWinner() {
        List<Car> carWithMaxPosition = carRepository.findCarWithMaxPosition();

        ArrayList<String> winners = new ArrayList<>();
        carWithMaxPosition.forEach(car -> winners.add(car.getName()));

        return winners;
    }

    public List<Car> startRacingCar() {
        return carRepository.findAll()
                .stream()
                .map(car -> car.race(getRandomNumber()))
                .toList();
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
