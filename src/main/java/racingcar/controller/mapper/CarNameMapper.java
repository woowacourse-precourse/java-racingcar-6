package racingcar.controller.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.vo.CarName;

public class CarNameMapper {
    public List<CarName> toCarName(String carName) {
        List<String> carNameStringGroup = Arrays.stream(carName.split(",")).toList();

        List<CarName> carNameGroup = new ArrayList<>();
        carNameStringGroup.forEach((carNameString) -> carNameGroup.add(new CarName(carNameString)));
        return carNameGroup;
    }
}
