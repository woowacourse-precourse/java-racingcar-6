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

    private static Set<Name> convertToName(String[] oldNames){
        Set<Name> names = Arrays.stream(oldNames)
                .map(Name::new)
                .collect(Collectors.toSet());

        if (!hasDuplicateCarName(oldNames.length,names.size())){
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }

        return names;
    }

    private static boolean hasDuplicateCarName(int oldNameSize, int nameSize){
        return oldNameSize == nameSize;
    }
}
