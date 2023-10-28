package racingcar.service.output;

import racingcar.domain.Car;
import racingcar.dto.output.CarsOutputDto;

public class OutputView implements Output{
    @Override
    public void show(CarsOutputDto carsOutputDto) {
        for(Car car:carsOutputDto.cars().getCarList()){

        }
    }
}
