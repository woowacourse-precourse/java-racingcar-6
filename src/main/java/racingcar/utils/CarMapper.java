package racingcar.utils;

import racingcar.domain.Car;
import racingcar.dto.CarDto;

public class CarMapper {

    private CarMapper(){

    }

    public static CarDto mappingDomainToDto(Car car){
            return new CarDto(car.getName(),car.getCurrentPosition());
    }

    public static Car mappingDtoToDomain(CarDto carDto){
        return new Car(carDto.getCarName());
    }
}
