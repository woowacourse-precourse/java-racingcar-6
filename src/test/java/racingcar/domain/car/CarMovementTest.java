package racingcar.domain.car;


import java.util.List;
import java.util.function.Supplier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.carcomponent.carmove.CarMoveReader;

class CarMovementTest {
    private CarMovement carMovement;
    private int ONE = 1;

    @BeforeEach
    void init() {
        Cars cars = new Cars(List.of(new Car("ONE"), new Car("TWO")));
        carMovement = new CarMovement(cars, new CarMoveReader(1));
    }

    @Test
    @DisplayName("설정한 totalNumberMove 보다 적게 움직이면 isMovable 는 ture 를 반환한다.")
    void carMovementTest_CanMove() {
        Assertions.assertThat(carMovement.isMovable()).isTrue();
    }

    @Test
    @DisplayName("설정한 totalNumberMove 와 동일한 만큼 움직이면 isMovable 는 false 를 반환한다.")
    void carMovementTest_CannotMove() {
        carMovement.moveCarsAndGetResult(() -> true);
        Assertions.assertThat(carMovement.isMovable()).isFalse();
    }

    @Test
    @DisplayName("moveCarAndGetResult 메서드에 false, true 를 차례대로 한번만 넣으면 ONE 은 움직이지 않고 TWO 는 한번 움직이며, 우승자는 TWO 가 된다.")
    void carMoveTest() {
        String moveResult = carMovement.moveCarsAndGetResult(booleanSupplier());
        Assertions.assertThat(moveResult).isEqualTo("ONE : \nTWO : -\n");
        Assertions.assertThat(carMovement.getWinner()).contains("TWO");
    }

    private Supplier<Boolean> booleanSupplier() {
        return () -> ((ONE++) % 2) == 0;
    }

}