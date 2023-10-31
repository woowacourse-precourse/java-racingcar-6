package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.input.CarInputDto;

public class Cars {
    private List<Car> carList;

    public static Cars of(final CarInputDto carInputDto) {
        return new Cars(carInputDto);
    }

    private Cars(final CarInputDto carInputDto) {
        this.carList = new ArrayList<>();
        carListGenerate(carInputDto);
    }

    private void carListGenerate(final CarInputDto carInputDto) {
        for (String carName : carInputDto.cars()) {
            carList.add(Car.of(carName));
        }
    }
    public List<Car> getCarList(){
        return this.carList;
    }
}
