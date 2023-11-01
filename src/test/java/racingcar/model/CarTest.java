package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.rule.CarMovementStatus;
import racingcar.model.rule.GameRuleValidator;
import racingcar.model.vehicle.Car;
import racingcar.model.vehicle.Name;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        String givenName = "cho";
        Name name = new Name(givenName);
        car = Car.applyName(name);
    }

    @Test
    @DisplayName("자동차에 이름을 부여할 수 있다.")
    public void carNameApplyTest() {
        String givenName = "sung";
        Name name = new Name(givenName);
        Car car = Car.applyName(name);
        assertThat(car.toString()).isEqualTo(givenName);
    }

    @Test
    @DisplayName("숫자가 3일때 정지하는 상태를 반환한다.")
    public void carReturnStopWhenNumberIsThreeTest() {
        Integer targetNumber = 3;
        CarMovementStatus carMovementStatus = CarMovementStatus.getMovementStatusByCheckNumber(targetNumber);
        assertThat(CarMovementStatus.STOP).isEqualTo(carMovementStatus);
    }

    @Test
    @DisplayName("숫자가 4일때 전진하는 상태를 반환한다.")
    public void carReturnMoveWhenNumberIsFourTest() {
        Integer targetNumber = 4;
        CarMovementStatus carMovementStatus = CarMovementStatus.getMovementStatusByCheckNumber(targetNumber);
        assertThat(CarMovementStatus.MOVING_FORWARD).isEqualTo(carMovementStatus);
    }

    @Test
    @DisplayName("전진하는 상태를 반으면 위치가 1 증가한다.")
    public void carStopWhenNumberIsThreeTest() {
        Integer position = car.changePosition(CarMovementStatus.MOVING_FORWARD);
        Integer targetPosition = 1;
        assertThat(position).isEqualTo(targetPosition);
    }

    @Test
    @DisplayName("정지 상태를 반으면 위치가 변하지 않는다.")
    public void carMoveWhenNumberIsFourTest() {
        Integer position = car.changePosition(CarMovementStatus.STOP);
        Integer firstCarPosition = 0;
        assertThat(position).isEqualTo(firstCarPosition);
    }

    @Test
    @DisplayName("차량의 이동 결과를 출력한다 : 전진 1화")
    public void showCarMoveResultMoveTest() {
        car.changePosition(CarMovementStatus.MOVING_FORWARD);
        String targetMessage = "cho : -";
        assertThat(car.getRoundResult().toString()).isEqualTo(targetMessage);
    }

    @Test
    @DisplayName("차량의 이동 결과를 출력한다 : 전진 2회")
    public void showCarMoveResultMoveTwiceTest() {

        car.changePosition(CarMovementStatus.MOVING_FORWARD);
        car.changePosition(CarMovementStatus.MOVING_FORWARD);

        String targetMessage = "cho : --";

        assertThat(car.getRoundResult().toString()).isEqualTo(targetMessage);
    }

    @Test
    @DisplayName("자동차가 우승자인지 확인한다. ")
    public void checkIsWinnerTest() {
        car.changePosition(CarMovementStatus.MOVING_FORWARD);
        Integer maxPositionGiven = 1;
        assertThat(car.isWinner(maxPositionGiven)).isTrue();
    }

    @Test
    @DisplayName("자동차가 우승자인지 확인한다. ")
    public void checkIsWinnerFalseTest() {
        car.changePosition(CarMovementStatus.MOVING_FORWARD);
        Integer maxPositionGiven = 2;
        assertThat(car.isWinner(maxPositionGiven)).isFalse();
    }

    @Test
    @DisplayName("자동차 이름을 확인한다. 6 자리 에러")
    public void checkWrongName() {
        String givenName = "appleO";
        assertThatThrownBy(() -> GameRuleValidator.validateName(givenName)).isInstanceOf(
                IllegalArgumentException.class);
    }
}
