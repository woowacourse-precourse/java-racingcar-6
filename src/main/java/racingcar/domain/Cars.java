package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarInputDto;

public class Cars {
    private List<Car> carList;

    public static Cars of(CarInputDto carInputDto) {
        return new Cars(carInputDto);
    }

    private Cars(CarInputDto carInputDto) {
        this.carList = new ArrayList<>();
        carListGenerate(carInputDto);
    }

    private void carListGenerate(CarInputDto carInputDto) {
        for (String carName : carInputDto.cars()) {
            carList.add(Car.of(carName));
        }
    }
}
