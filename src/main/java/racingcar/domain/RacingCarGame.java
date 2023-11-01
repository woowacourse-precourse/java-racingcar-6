package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.NameLocationPair;
import racingcar.dto.PlayResultDTO;
import racingcar.dto.ResultEachTry;
import racingcar.dto.WinnersDTO;

public class RacingCarGame {
    private Cars cars;
    private final int tryNum;

    public RacingCarGame(String carNames, int tryNum) {
        this.cars = initCars(carNames);
        this.tryNum = tryNum;
    }

    public PlayResultDTO play() {
        List<ResultEachTry> resultEachTry = new ArrayList<>();
        for (int tryOrder = 1; tryOrder <= tryNum; tryOrder++) {
            cars.moveCars();

            List<NameLocationPair> nameLocationPairs = toNameLocationPairs(cars.getCars());
            resultEachTry.add(new ResultEachTry(tryOrder, nameLocationPairs));
        }
        return new PlayResultDTO(resultEachTry);
    }

    public WinnersDTO finish() {
        return new WinnersDTO(
                cars.findWinners()
                        .stream()
                        .map((Car::getCarNameValue))
                        .toList()
        );
    }

    private static List<NameLocationPair> toNameLocationPairs(List<Car> carList) {
        return carList.stream()
                .map((car) -> new NameLocationPair(
                        car.getCarNameValue(),
                        car.getLocationValue()))
                .toList();
    }

    protected Cars initCars(String carNames) {
        List<Car> cars = Arrays.stream(carNames.split(","))
                .map((carName) -> new Car(new CarName(carName)))
                .toList();

        return new Cars(cars);
    }

    public Cars getCars() {
        return cars;
    }
}
