package racingcar.dto;

import java.util.ArrayList;
import racingcar.dto.CarDto;

public class CarsDto {
    private final ArrayList<CarDto> carArrayList;

    public CarsDto(ArrayList<CarDto> carArrayList) {
        this.carArrayList = carArrayList;
    }

    public ArrayList<CarDto> getCarArrayList() {
        return carArrayList;
    }
}
