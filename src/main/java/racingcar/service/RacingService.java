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

    private static final int LOCATION_START_NUMBER = 0;

    private static final int RANDOM_START_NUMBER = 0;

    private static final int RANDOM_FINISH_NUMBER = 9;

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
                .forEach(this::carMoveOrStop);
        outputView.outputCustomMessage("");
    }

    private void carMoveOrStop(Car car) {
        StatusEnum statusEnum = getMoveOrStop(getRandomNum());
        car.move(statusEnum);

        outputView.outputRacingResult(car.getCarName(), car.getLocation());
    }

    public String getListToStringWinners() {
        List<Car> carList = getWinners();

        return carList.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

    private List<Car> getWinners() {
        return cars.getCarList()
                .stream()
                .filter(this::isWinner)
                .toList();
    }

    private int getTopLocation() {
        return cars.getCarList()
                .stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(LOCATION_START_NUMBER);
    }

    private int getRandomNum() {
        return Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_FINISH_NUMBER);
    }

    public void setOutputView(OutputView outputView) {
        this.outputView = outputView;
    }

    private boolean isWinner(Car car) {
        return car.isWinner(getTopLocation());
    }
}
