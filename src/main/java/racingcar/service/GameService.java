package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.InputDto;
import racingcar.view.GameOutputView;

public class GameService {

    public GameService() {
    }

    public void processStart(InputDto inputDto) {
        List<Car> cars = new ArrayList<>();
        setCars(inputDto.carNames(), cars);
        for (int i = 0; i < inputDto.tryNum(); i++) {
            moveEachCar(cars);
            GameOutputView.printRacingProcess(cars);
            System.out.println();
        }

        GameOutputView.printCarsName(getWinners(cars));
    }

    public void moveEachCar(List<Car> cars) {
        cars.forEach(Car::move);
    }

    public void setCars(List<String> carNames, List<Car> cars) {
        carNames.forEach(carName ->
                cars.add(new Car(carName))
        );
    }

    public List<Car> getWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int maxNum = getMaxNum(cars);

        cars.stream()
                .filter(car -> car.getNowNum() == maxNum)
                .forEach(winners::add);

        return winners;
    }

    private int getMaxNum(List<Car> cars) {
        int maxNum = 0;
        for (Car car : cars) {
            maxNum = Math.max(car.getNowNum(), maxNum);
        }

        return maxNum;
    }

}
