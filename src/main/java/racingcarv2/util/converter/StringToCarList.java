package racingcarv2.util.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcarv2.model.Car;
import racingcarv2.model.Name;
import racingcarv2.model.Position;

public class StringToCarList {
    public static final int INIT_POSITION_VALUE = 0;

    public static List<Car> convert(String src) {
        return Arrays.stream(src.split(Name.SEPARATOR_COMMA))
                .map(carName -> new Car(new Name(carName), new Position(INIT_POSITION_VALUE)))
                .collect(Collectors.toList());
    }
}
