package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcarFP.Application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class CarMoverTest extends NsTest
{
    CarMover cm = new CarMover();
    @Test
    void whetherMoveOrNot_길이_검사()
    {
        int n = 10;
        List<Boolean> booleanList = cm.decideToMoveCars(n);
        assertThat(n).isEqualTo(booleanList.size());
    }

    @Test
    void moveEveryCar에서_CarList가_BooleanList에_따라_증가하는가()
    {
        List<Car> cars = List.of(new Car("car1"), new Car("car2"), new Car("car3"));
        List<Boolean> booleanList = List.of(true, false, true);
        cm.moveEveryCar(3, cars, booleanList);

        assertThat(cars.get(0).getDistance()).isEqualTo(1);
        assertThat(cars.get(1).getDistance()).isEqualTo(0);
        assertThat(cars.get(2).getDistance()).isEqualTo(1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
