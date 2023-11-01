package racingcar.validation;

import java.util.List;
import racingcar.utils.ErrorMessage;

public class ParticipatingCarsValidation {
    public void validateParticipatingCars(List<String> ParticipatingCars) {
        validateNotEmpty(ParticipatingCars);
    }

    private void validateNotEmpty(List<String> ParticipatingCars) {
        if (ParticipatingCars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NO_PARTICIPATING_CARS_ERROR_MESSAGE);
        }
    }
}
