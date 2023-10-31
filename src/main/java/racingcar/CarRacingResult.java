package racingcar;

import java.util.List;

public class CarRacingResult {
    private final List<Car> championCarList;

    public CarRacingResult(List<Car> championCarList) {
        List<Car> copiedChampionCarList = championCarList.stream()
                .map(Car::deepCopy)
                .toList();

        this.championCarList = copiedChampionCarList;
    }

    @Override
    public String toString() {
        List<String> championCarsName = championCarList.stream()
                .map(Car::getName)
                .toList();

        String championCarsMessage = championCarsName.stream()
                .reduce((carNames, carName) -> carNames + ", " + carName)
                .get();

        return "최종 우승자 : " + championCarsMessage;
    }
}
