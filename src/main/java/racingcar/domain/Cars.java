package racingcar.domain;

import racingcar.domain.dto.output.CarsDto;
import racingcar.domain.dto.output.WinnerDto;
import racingcar.domain.dto.output.WinnersDto;
import racingcar.exception.ExceptionMessage;

import java.util.List;

public class Cars {
    private final List<Car> carList;

    private Cars(List<String> carNameList) {
        this.carList = carNameList.stream()
                .map(Car::from)
                .toList();
    }

    public static Cars from(List<String> carNameList) {
        return new Cars(carNameList);
    }

    public void moveCarsBy(MoveChecker moveChecker) {
        for (Car car : carList) {
            car.moveBy(moveChecker);
        }
    }

    public CarsDto toCarsDto() {
        return new CarsDto(carList.stream()
                .map(Car::toCarDto)
                .toList());
    }

    public WinnersDto toWinnersDto() {
        int maxPosition = getMaxPosition();
        List<WinnerDto> winnerList = getWinnerListWith(maxPosition);
        return new WinnersDto(winnerList);
    }

    private List<WinnerDto> getWinnerListWith(int maxPosition) {
        return carList.stream()
                .filter(car -> isSameBetween(maxPosition, car))
                .map(Car::toWinnerDto)
                .toList();
    }

    private boolean isSameBetween(int maxPosition, Car car) {
        return car.getPosition() == maxPosition;
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(ExceptionMessage.MAX_NOT_EXIST::getException);
    }
}
