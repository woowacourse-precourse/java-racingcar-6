package racingcar.domain;

import racingcar.core.NamesParser;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private final NamesParser namesParser;
    public CarFactory(final NamesParser namesParser) {
        this.namesParser = namesParser;
    }

    public List<Car> factory(String stringNames){
        List<Car> res = new ArrayList<>();
        List<String> parsedStringNames = namesParser.parsing(stringNames);

        for (String name : parsedStringNames) {
            Car car = new Car(name);
            res.add(car);
        }
        return res;
    }
}
