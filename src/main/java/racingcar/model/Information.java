package racingcar.model;

import racingcar.util.InputConverter;
import racingcar.util.InputParser;

import java.util.List;

public class Information {
    private final List<String> names;
    private final int times;

    public List<String> getNames() {
        return names;
    }

    public int getTimes() {
        return times;
    }

    private Information(List<String> names, int times) {
        this.names = names;
        this.times = times;
    }

    public static Information of(String names, String times) {
        return new Information(
                InputParser.parseNames(names),
                InputConverter.covertTimes(times)
        );
    }

}
