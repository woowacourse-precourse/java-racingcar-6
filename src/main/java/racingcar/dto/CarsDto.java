package racingcar.dto;

import java.util.ArrayList;

public class CarsDto {
    private final ArrayList<CarDto> carArrayList;

    public CarsDto(ArrayList<CarDto> carArrayList) {
        this.carArrayList = carArrayList;
    }

    public ArrayList<CarDto> getCarArrayList() {
        return carArrayList;
    }
}
