package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.util.StatusEnum;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class RacingService {

    private final Cars cars;

    private OutputView outputView;

    private static final int MOVE_CONDITION = 4;

    public RacingService(String carsName) {
        this.cars = new Cars(carsName);
    }

    public StatusEnum getMoveOrStop(int randomNum) {

        if (randomNum >= MOVE_CONDITION) {
            return StatusEnum.MOVE;
        }

        return StatusEnum.STOP;
    }

    public void racingStart() {
        cars.getCarList()
                .forEach(car -> {
                    StatusEnum statusEnum = getMoveOrStop(getRandomNum());
                    car.moveOrStop(statusEnum);
                    outputView.outputRacingResult(car.getCarName(), car.getLocation());
                });
        outputView.outputCustomMessage("");
    }

    public String getListToStringWinners() {
        List<Car> carList = getTopCars();

        return carList.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

    private List<Car> getTopCars() {
        return cars.getCarList()
                .stream()
                .filter(car -> car.getLocation() == getTopLocation())
                .toList();
    }

    private int getTopLocation() {
        return cars.getCarList()
                .stream()
                .mapToInt(Car::getLocation)
                .filter(location -> location >= 0)
                .max()
                .orElse(0);
    }

    private int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void setOutputView(OutputView outputView) {
        this.outputView = outputView;
    }
}
