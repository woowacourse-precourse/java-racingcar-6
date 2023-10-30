package racingcar.domain.system.viewer;


import java.util.List;
import racingcar.domain.core.car.CarName;

public interface Viewer {

    void print(String message);

    void print(GuideMessage message);

    void print(CarName carName, String position);

    void print(List<CarName> winners);
}
