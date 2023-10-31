package racingcar.model;

import racingcar.model.dto.CarStatusDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private final Cars cars;
    private final int winPosition;

    public GameResult(Cars cars, int winPosition) {
        this.cars = cars;
        this.winPosition = winPosition;
    }

    public List<CarStatusDto> printWinCarsStatus() {
        List<CarStatusDto> carStatusDtos = new ArrayList<>();
        List<Car> carList = cars.getCars();
        carList.forEach(car -> {
            if(isSameWinPosition(car)) carStatusDtos.add(new CarStatusDto(car));
        });
        return carStatusDtos;
    }

    private boolean isSameWinPosition(Car car) {
        return car.getPosition() == winPosition;
    }
}
