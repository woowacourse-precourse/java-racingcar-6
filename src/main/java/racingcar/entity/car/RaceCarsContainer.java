package racingcar.entity.car;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static racingcar.constants.ErrorConstants.DUPLICATE_NAME_ERROR_MESSAGE;

public class RaceCarsContainer {

    private List<Car> cars;

    public RaceCarsContainer(List<Car> cars) {
        this.cars = cars;
    }

    private void validateDuplicate(int oldNameSize, int nameSize){
        if (oldNameSize != nameSize){
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }
}
