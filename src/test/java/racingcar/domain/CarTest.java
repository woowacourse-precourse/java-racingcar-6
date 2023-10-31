package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.policy.MovingPolicy;
import racingcar.policy.NumberGeneratePolicy;
import racingcar.policy.RacingCarGameMovingPolicy;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    @Test
    void 모든_필드값이_같다면_자동차의_동등성을_보장한다() {
        // given, when
        Car car1 = new Car(new CarName("자동차1"), new Position(0));
        Car car2 = new Car(new CarName("자동차1"), new Position(0));

        // then
        assertAll(
                () -> assertThat(car1).isEqualTo(car2),
                () -> assertThat(car1).hasSameHashCodeAs(car2)
        );
    }

    @Test
    void 모든_필드값이_같지_않으면_자동차의_동등성을_보장하지_않는다() {
        // given, when
        Car car1 = new Car(new CarName("자동차1"), new Position(0));
        Car car2 = new Car(new CarName("자동차1"), new Position(1));

        // then
        assertAll(
                () -> assertThat(car1).isNotEqualTo(car2),
                () -> assertThat(car1).doesNotHaveSameHashCodeAs(car2)
        );
    }

    @ParameterizedTest(name = "{index}번째 NumberGeneratePolicy")
    @MethodSource("movableNums")
    void 정책에_따라서_움직일_수_있다면_위치를_하나_증가시킨다(NumberGeneratePolicy numberGeneratePolicy) {
        // given
        MovingPolicy movingPolicy = new RacingCarGameMovingPolicy();
        Car car = new Car(new CarName("자동차1"), new Position(0));

        // when
        Car movedCar = car.move(movingPolicy, numberGeneratePolicy);

        // then
        Car expectedCar = new Car(new CarName("자동차1"), new Position(1));
        assertThat(movedCar).isEqualTo(expectedCar);
    }

    @ParameterizedTest(name = "{index}번째 NumberGeneratePolicy")
    @MethodSource("nonMovableNums")
    void 정책에_따라서_움직일_수_없다면_위치를_증가시키지_않는다(NumberGeneratePolicy numberGeneratePolicy) {
        // given
        MovingPolicy movingPolicy = new RacingCarGameMovingPolicy();
        Car car = new Car(new CarName("자동차1"), new Position(0));

        // when
        Car movedCar = car.move(movingPolicy, numberGeneratePolicy);

        // then
        Car expectedCar = new Car(new CarName("자동차1"), new Position(0));
        assertThat(movedCar).isEqualTo(expectedCar);
    }

    static Stream<NumberGeneratePolicy> movableNums() {
        return Stream.of(
                () -> 4,
                () -> 5,
                () -> 6,
                () -> 7,
                () -> 8,
                () -> 9
        );
    }

    static Stream<NumberGeneratePolicy> nonMovableNums() {
        return Stream.of(
                () -> 0,
                () -> 1,
                () -> 2,
                () -> 3
        );
    }

}