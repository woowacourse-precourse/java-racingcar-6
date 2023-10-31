package racingcar.domain;

import java.util.List;
import racingcar.dto.CarRegistrationDTO;

public interface CarRegistration {
    List<Car> register(List<CarRegistrationDTO> carRegistrations);
}
