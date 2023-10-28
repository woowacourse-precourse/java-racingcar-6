package racingcar.domain;

import racingcar.core.NamesParser;
import racingcar.core.Output;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private final NamesParser namesParser;

    public CarFactory() {
        this.namesParser = new NamesParser();
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

    public List<String> getNames(List<Car> winners){
        List<String> res = new ArrayList<>();
        for (Car winner : winners) {
            res.add(winner.getName());
        }
        return res;
    }
}
