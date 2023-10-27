package racingcar.domain.collection;

import java.util.Collections;
import java.util.List;

public class CarNames {

    private final List<String> names;

    public CarNames(List<String> names) {
        this.names = names;
    }

    public String get(int index) {
        return new String(names.get(index));
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }

}
