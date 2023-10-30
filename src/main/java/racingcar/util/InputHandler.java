package racingcar.util;

import java.util.List;
import racingcar.dto.CarRegistrationDTO;

public interface InputHandler {
    List<CarRegistrationDTO> getCarRegistrations();
    int getRaceRoundCount();
}
