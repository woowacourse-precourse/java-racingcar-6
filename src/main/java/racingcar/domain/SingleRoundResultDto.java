package racingcar.domain;

import java.util.List;

public class SingleRoundResultDto {

    private final List<Car.CarResultDto> carResultDtoList;

    public SingleRoundResultDto(List<Car.CarResultDto> carResultDtoList) {
        this.carResultDtoList = carResultDtoList;
    }

    public Car.CarResultDto getCarResultDto(int index) {
        return carResultDtoList.get(index);
    }

    public long getCarNumbers() {
        return carResultDtoList.size();
    }
}
