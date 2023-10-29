package racingcar.model;

import racingcar.util.InputConverter;
import racingcar.util.InputParser;

import java.util.List;

public class Infomation {
    private final List<String> names;
    private final int times;

    public List<String> getNames() {
        return names;
    }

    public int getTimes() {
        return times;
    }

    private Infomation(List<String> names, int times) {
        this.names = names;
        this.times = times;
    }

    public static Infomation of(String names, String times) {
        return new Infomation(
                InputParser.parseNames(names),
                InputConverter.covertTimes(times)
        );
    }
}
