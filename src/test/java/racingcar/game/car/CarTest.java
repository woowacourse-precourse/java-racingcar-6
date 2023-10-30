package racingcar.game.car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class CarTest {
    private static final int MOVE_FORWARD = 4;
    private static final int DUMMY = 1;
    private static final int PROCEEDED = 1;
    private static final int STOP = 3;

    @Test
    @DisplayName("이름이 빈 문자열일 때 자동차 생성을 실패해야한다.")
    void test_CarGenerationFailed_EmptyName() {
        //given
        String name = "";

        //when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 입력되지 않은 자동차가 있습니다.");
    }

    @Test
    @DisplayName("5자를 넘는 이름으로 자동차 생성 시 실패해야한다.")
    void test_CarGenerationFailed_NameLengthExcessiv() {
        //given
        String name = "racingCar";

        //when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5글자를 넘을 수 없습니다.");
    }

    @Test
    @DisplayName("이름에 공백이 포함되면 자동차 생성을 실패해야한다.")
    void test_CarGenerationFailed_WhiteSpaceIncluded() {
        //given
        String name = "na me";

        //when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름에 공백이 포함된 자동차가 있습니다.");
    }

    @Test
    @DisplayName("자동차 생성을 성공한다.")
    void test_CarGenerationSuccessful() {
        //given
        String name = "jay";

        //when
        Car car = new Car(name);

        //then
        assertThat(car.displayName()).isEqualTo(name);
    }

    @Test
    @DisplayName("생성되는 랜덤 값이 3보다 클 때 한 칸 전진한 자동차를 반환해야한다.")
    void test_ConductActionSuccessful_ReturnProceededCar() {
        //given
        Car car = new Car("jay");

        //when
        Executable proceedTest = () -> {
            Car proceededCar = car.conductAction();
            assertThat(proceededCar.compareTo(car)).isEqualTo(PROCEEDED);
        };

        //then
        assertRandomNumberInRangeTest(proceedTest, MOVE_FORWARD, DUMMY);
    }

    @Test
    @DisplayName("생성되는 랜덤 값이 3 이하 일 때 변함없는 자동차를 반환해야한다.")
    void test_ConductActionSuccessful_ReturnSameCar() {
        //given
        Car car = new Car("jay");

        //when
        Executable stopTest = () -> {
            Car stoppedCar = car.conductAction();
            assertThat(stoppedCar).isSameAs(car);
        };

        //then
        assertRandomNumberInRangeTest(stopTest, STOP, DUMMY);
    }

    @Test
    @DisplayName("이동한 거리가 다른 차를 비교하면 false를 반환해야한다.")
    void test_IsTieWithSuccessful_ReturnFalse() {
        //given
        Car winner = new Car("first", 2);
        Car runnerUp = new Car("sec", 1);
        Car last = new Car("last", 0);

        //when
        boolean isWinnerTieWithRunnerUp = winner.isTieWith(runnerUp);
        boolean isRunnerUpTieWithLast = runnerUp.isTieWith(last);
        boolean isLastTieWithWinner = last.isTieWith(winner);

        //then
        assertThat(isWinnerTieWithRunnerUp).isFalse();
        assertThat(isRunnerUpTieWithLast).isFalse();
        assertThat(isLastTieWithWinner).isFalse();
    }

    @Test
    @DisplayName("이동한 거리가 같은 자동차를 비교하면 true를 반환해야한다.")
    void test_IsTieWithSuccessful_ReturnTrue() {
        //given
        Car winner = new Car("first", 4);
        Car tieWinner = new Car("tie", 4);

        //when
        boolean isTieWinners = winner.isTieWith(tieWinner);

        //then
        assertThat(isTieWinners).isTrue();
    }

    @Test
    @DisplayName("두 자동차를 비교해서 주 객체가 더 많이 전진하면 양수를 반환해야한다.")
    void test_CompareToSuccessful_ReturnPositive() {
        //given
        Car hero = new Car("hero", 10);
        Car villain = new Car("bad", 2);

        //when
        int compared = hero.compareTo(villain);

        //then
        assertThat(compared).isPositive();
    }

    // 같을 때 0
    @Test
    @DisplayName("두 자동차의 전진 거리가 같으면 0을 반환해야한다.")
    void test_CompareToSuccesful_ReturnZero() {
        //given
        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 3);

        //when
        int compared = car1.compareTo(car2);

        //then
        assertThat(compared).isZero();
    }

    @Test
    @DisplayName("두 자동차를 비교할 때 주 객체가 덜 전진했으면 음수를 반환해야한다.")
    void test_CompareToSuccessful_ReturnNegative() {
        //given
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 5);

        //when
        int compared = car1.compareTo(car2);

        //then
        assertThat(compared).isNegative();
    }
}
