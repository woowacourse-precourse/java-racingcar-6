package racingcar.firstclasscollection;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionMessage;
import racingcar.model.Car;

class CarListTest {

    @Test
    public void 자동차_이름은_중복될_수_없다() {
        CarList carList = new CarList(ArrayList::new);
        carList.addCar(new Car("name"));
        carList.addCar(new Car("car"));

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> carList.addCar(new Car("name")))
                .withMessage(ExceptionMessage.CAR_NAME_DUPLICATED);
    }
}