package racingcar.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNames {
    private final List<CarName> carNames;

    public CarNames(final List<String> names) {
        List<CarName> carNameList = names.stream()
                .map(CarName::new)
                .toList();

        validateCarNames(carNameList);

        this.carNames = carNameList;
    }

    public List<CarName> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    private void validateCarNames(final List<CarName> names) {
        if (hasDuplicates(names)) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }
    private boolean hasDuplicates(final List<CarName> names) {
        Set<CarName> uniqueNames = new HashSet<>(names);
        return uniqueNames.size() < names.size();
    }

}
