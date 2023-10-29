package racingcar.dto;

import java.util.List;

public class CarsDto {

    private List<CarDto> carDtos;

    public CarsDto(List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }

    public List<CarDto> getCarDtos() {
        return carDtos;
    }
}
