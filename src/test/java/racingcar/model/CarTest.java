package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.CarDto;
import racingcar.fixture.FixtureNumberGenerator;

class CarTest {

    private static final String ANONYMOUS_NAME = "name";
    private static final int ANONYMOUS_POSITION = 5;
    private static final int MOVE_THRESHOLD = 4;


    @DisplayName("move() 테스트 : 랜덤으로 생성된 값이 기준값보다 크거나 같으면 전진한다.")
    @ParameterizedTest(name = "생성된 랜덤값이 {0}일 때 0에서 1로 전진한다.")
    @ValueSource(ints = {4, 5, 9})
    void moveUsingRandomNumber_램덤값이_4보다_클때(int random) {
        Car car = new Car(ANONYMOUS_NAME, 0);

        car.moveUsingRandomNumber(new FixtureNumberGenerator(random),
                randomNumber -> randomNumber.isGreaterThan(MOVE_THRESHOLD));

        assertThat(car).usingRecursiveComparison()
                .comparingOnlyFields("position")
                .isEqualTo(new Car(ANONYMOUS_NAME, 1));
    }

    @DisplayName("move() 테스트 : 랜덤으로 생성된 값이 기준값보다 작으면 가만히 있는다.")
    @ParameterizedTest(name = "생성된 랜덤값이 {0}일 때 0에서 전진하지 않는다.")
    @ValueSource(ints = {0, 1, 3})
    void moveUsingRandomNumber_랜덤값이_4보다_작을때(int random) {
        Car car = new Car(ANONYMOUS_NAME, 0);

        car.moveUsingRandomNumber(new FixtureNumberGenerator(random),
                randomNumber -> randomNumber.isGreaterThan(MOVE_THRESHOLD));

        assertThat(car).usingRecursiveComparison()
                .comparingOnlyFields("position")
                .isEqualTo(new Car(ANONYMOUS_NAME, 0));
    }

    @DisplayName("CarDto로 변환 테스트 : 모든 필드값을 통해 CarDto로 변환한다.")
    @Test
    void toDto() {
        Car car = new Car("홍길동", 5);

        CarDto carDto = car.toDto();

        assertThat(carDto).usingRecursiveComparison()
                .comparingOnlyFields("name", "position")
                .isEqualTo(new Car("홍길동", 5));
    }

    @DisplayName("더 앞에 있는지 테스트 :Car 객체가 다른 Car 보다 더 앞에 있으면 true, 그렇지 않으면 false 반환")
    @Test
    void isFrontOf() {
        Car car = new Car("홍길동", 5);

        boolean expectedTrue = car.isFrontOf(new Car("성춘향", 3));
        boolean expectedFalse = car.isFrontOf(new Car("성춘향", 6));

        assertAll(
            () -> assertThat(expectedTrue).isTrue(),
            () -> assertThat(expectedFalse).isFalse()
        );
    }

    @DisplayName("move 테스트 : 자동차의 position 이 한칸 전진한다.")
    @Test
    void move() {
        Car car = new Car("홍길동", 5);

        car.move();

        assertThat(car).usingRecursiveComparison()
                .comparingOnlyFields("position")
                .isEqualTo(new Car("홍길동", 6));
    }

    @DisplayName("같은 position 인지 테스트 : 자동차의 position 이 같으면 true, 다르면 false 반환.")
    @Test
    void isSamePosition() {
        Car car = new Car("홍길동", 5);

        assertAll(
                () -> assertThat(car.isSamePosition(5)).isTrue(),
                () -> assertThat(car.isSamePosition(7)).isFalse()
        );

    }

    @DisplayName("같은 position 값을 가지는 Car 인지 테스트 : 자동차의 position 이 같으면 true, 다르면 false 반환.")
    @Test
    void isSamePositionCar() {
        Car car1 = new Car("홍길동", 5);
        Car car2 = new Car("성춘향", 5);
        Car car3 = new Car("이몽룡", 6);

        assertAll(
                () -> assertThat(car1.isSamePosition(car2)).isTrue(),
                () -> assertThat(car1.isSamePosition(car3)).isFalse()
        );

    }

    @DisplayName("create 생성 테스트 : Car 생성 시 이름을 부여할 수 있다.")
    @Test
    void create() {
        Car car = new Car("홍길동");

        assertThat(car).usingRecursiveComparison()
                .comparingOnlyFields("name")
                .isEqualTo(new Car("홍길동"));
    }

    @DisplayName("name 사이즈 5이하 테스트 : 5이하가 아니라면 IllegalArgumentException가 발생한다.")
    @Test
    void name_size_less_than_5() {
        assertThatThrownBy(() -> new Car("홍길동홍길동"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름 크기는 5이하여야 합니다.");
    }

    @DisplayName("position 값 0이상 테스트 : 0이상이 아니라면 IllegalArgumentException가 발생한다.")
    @Test
    void position_init_size_more_than_0() {
        assertThatThrownBy(() -> new Car("홍길동", -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 초기위치값은 0보다 작을 수 없습니다.");
    }
}