package racingcar.domain.dto;

import java.util.List;

public class CarDtos {
    private final List<CarDto> carDtos;

    public CarDtos(final List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }

    public List<CarDto> getCarDtos() {
        return this.carDtos;
    }
}