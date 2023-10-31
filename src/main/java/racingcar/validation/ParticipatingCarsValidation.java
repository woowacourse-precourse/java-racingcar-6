package racingcar.validation;

import java.util.List;

public class ParticipatingCarsValidation {

    public void validateParticipatingCars(List<String> ParticipatingCars) {
        validateNotEmpty(ParticipatingCars);
        validateAllElementsStrings(ParticipatingCars);
    }

    private void validateNotEmpty(List<String> ParticipatingCars) {
        if (ParticipatingCars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateAllElementsStrings(List<String> ParticipatingCars) {
        for (String item : ParticipatingCars) {
            if (!item.getClass().equals(String.class)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
