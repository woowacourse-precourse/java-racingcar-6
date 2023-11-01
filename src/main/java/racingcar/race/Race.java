package racingcar.race;

import java.util.List;
import racingcar.car.CarImpl;

public interface Race {
    public void start(int rounds);

    public List<CarImpl> getCars();

    public void round();
}
