package racingcar.model;

import racingcar.util.Parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Names {
    private Set<String> names;

    public Set<String> getNames() {
        return names;
    }
    public Names() {
        this.names = new HashSet<>();
    }
    public void initNames(String carNames) {
        names.addAll(Arrays.asList(Parser.splitCarNames(carNames)));
    }
}
