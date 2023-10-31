package racingcar.validation;

import java.util.List;

public class ParticipatingCarsValidation {

    public void validateParticipatingCars(List<String> ParticipatingCars) {
        validateNotEmpty(ParticipatingCars);
    }

    private void validateNotEmpty(List<String> ParticipatingCars) {
        if (ParticipatingCars.isEmpty()) {
            throw new IllegalArgumentException("경주에 참가하는 차량이 없습니다.");
        }
    }
}
