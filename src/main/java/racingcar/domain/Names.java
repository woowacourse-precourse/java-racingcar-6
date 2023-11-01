package racingcar.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Names {

    private final List<String> names;

    public Names(List<String> names) {
        validate(names);
        this.names = names;
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }

    public List<Car> toCarList() {
        return this.names.stream()
            .map(Car::fromName)
            .collect(Collectors.toList());
    }
    public void validate(List<String> names) {
        validateNotNull(names);
        validateDuplicatedNames(names);
    }

    private void validateNotNull(List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("입력 값이 null 입니다.");
        }
    }

    private void validateDuplicatedNames(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException("중복되는 이름이 있으면 안됩니다.");
        }
    }

}
