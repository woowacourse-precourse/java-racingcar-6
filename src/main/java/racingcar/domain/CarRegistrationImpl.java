package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarRegistrationDTO;

public class CarRegistrationImpl implements CarRegistration {

    @Override
    public List<Car> register(List<CarRegistrationDTO> carRegistrations) {
        return carRegistrations.stream()
                .map(this::convertToCar)
                .collect(Collectors.toList());
    }

    private Car convertToCar(CarRegistrationDTO carRegistrationDTO) {
        String carName = carRegistrationDTO.carName();
        return Car.from(carName);
    }
}
