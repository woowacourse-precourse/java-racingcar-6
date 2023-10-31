package racingcar.domain;

import racingcar.domain.dto.output.CarsDto;
import racingcar.domain.dto.output.WinnerDto;
import racingcar.domain.dto.output.WinnersDto;
import racingcar.exception.ExceptionMessage;
import racingcar.validator.CarNameValidator;

import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNameList) {
        CarNameValidator.validateDuplicatedName(carNameList);
        CarNameValidator.validateNameLength(carNameList);
        this.carList = carNameList.stream()
                .map(Car::new)
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
        List<WinnerDto> winnerList = carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::toWinnerDto)
                .toList();
        return new WinnersDto(winnerList);
    }

    public int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(ExceptionMessage.MAX_NOT_EXIST::getException);
    }
}
