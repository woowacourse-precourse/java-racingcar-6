package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.CarDto;
import racingcar.fixture.FixtureNumberGenerator;

class CarTest {

    private static final int MOVE_THRESHOLD = 4;


    @DisplayName("moveUsingRandomNumber() 테스트 : 랜덤으로 생성된 값이 기준값보다 크거나 같으면 전진한다.")
    @ParameterizedTest(name = "생성된 랜덤값이 {0}일 때 0에서 1로 전진한다.")
    @ValueSource(ints = {4, 5, 9})
    void moveUsingRandomNumber_램덤값이_4보다_클때(int random) {
        Car car = new Car(new Name("홍길동"), new Position(0));

        car.moveUsingRandomNumber(new FixtureNumberGenerator(random),
                randomNumber -> randomNumber.isGreaterThan(MOVE_THRESHOLD));

        assertThat(car).usingRecursiveComparison()
                .comparingOnlyFields("position")
                .isEqualTo(new Car(new Name("홍길동"), new Position(1)));
    }

    @DisplayName("moveUsingRandomNumber() 테스트 : 랜덤으로 생성된 값이 기준값보다 작으면 가만히 있는다.")
    @ParameterizedTest(name = "생성된 랜덤값이 {0}일 때 0에서 전진하지 않는다.")
    @ValueSource(ints = {0, 1, 3})
    void moveUsingRandomNumber_랜덤값이_4보다_작을때(int random) {
        Car car = new Car(new Name("홍길동"), new Position(0));

        car.moveUsingRandomNumber(new FixtureNumberGenerator(random),
                randomNumber -> randomNumber.isGreaterThan(MOVE_THRESHOLD));

        assertThat(car).usingRecursiveComparison()
                .comparingOnlyFields("position")
                .isEqualTo(new Car(new Name("홍길동"), new Position(0)));
    }

    @DisplayName("toDto() 테스트 : Car를 CarDto로 변환한다.")
    @Test
    void toDto() {
        Car car = new Car(new Name("홍길동"), new Position(5));

        CarDto carDto = car.toDto();

        assertThat(carDto).usingRecursiveComparison()
                .comparingOnlyFields("name", "position")
                .isEqualTo(new Car(new Name("홍길동"), new Position(5)));
    }

    @DisplayName("isFrontOf() 테스트 : Car 객체가 다른 Car 보다 더 앞에 있으면 true를 반환한다.")
    @ParameterizedTest(name = "내 차가(5) 다른차({0})보다 앞에 있으므로 true를 반환한다.")
    @ValueSource(ints = {0, 3, 4})
    void isFrontOf_다른차보다_앞에있을때_true(int otherPosition) {
        Car car = new Car(new Name("홍길동"), new Position(5));

        boolean expectedTrue = car.isFrontOf(new Car(new Name("성춘향"), new Position(otherPosition)));

        assertThat(expectedTrue).isTrue();
    }

    @DisplayName("isFrontOf() 테스트 :Car 객체가 다른 Car 보다 같거나 뒤에있으면 false를 반환한다.")
    @ParameterizedTest(name = "내 차가(5) 다른차({0})와 같거나 뒤에 있으므로 false를 반환한다.")
    @ValueSource(ints = {5, 6, 7})
    void isFrontOf_다른차보다_뒤에있을때_false(int otherPosition) {
        Car car = new Car(new Name("홍길동"), new Position(5));

        boolean expectedFalse = car.isFrontOf(new Car(new Name("성춘향"), new Position(otherPosition)));

        assertThat(expectedFalse).isFalse();
    }

    @DisplayName("move() 테스트 : 자동차의 position 이 한칸 전진한다.")
    @Test
    void move() {
        Car car = new Car(new Name("홍길동"), new Position(5));

        car.move();

        assertThat(car).usingRecursiveComparison()
                .comparingOnlyFields("position")
                .isEqualTo(new Car(new Name("홍길동"), new Position(6)));
    }

    @DisplayName("isSamePosition() 테스트 : 자동차의 position 이 같으면 true, 다르면 false 반환한다.")
    @Test
    void isSamePosition() {
        Car car = new Car(new Name("홍길동"), new Position(5));

        assertAll(
                () -> assertThat(car.isSamePosition(5)).isTrue(),
                () -> assertThat(car.isSamePosition(7)).isFalse()
        );
    }

    @DisplayName("isSamePositionCar() 테스트 : 자동차의 position 이 같으면 true, 다르면 false 반환한다.")
    @Test
    void isSamePositionCar() {
        Car car1 = new Car(new Name("홍길동"), new Position(5));
        Car car2 = new Car(new Name("성춘향"), new Position(5));
        Car car3 = new Car(new Name("이몽룡"), new Position(6));

        assertAll(
                () -> assertThat(car1.isSamePosition(car2)).isTrue(),
                () -> assertThat(car1.isSamePosition(car3)).isFalse()
        );
    }

    @DisplayName("Car(name) 생성 테스트 : Car 생성 시 이름을 부여할 수 있다.")
    @Test
    void create_생성자에_이름이주어짐() {
        Car car = new Car(new Name("홍길동"));

        assertThat(car).usingRecursiveComparison()
                .comparingOnlyFields("name", "field")
                .isEqualTo(new Car(new Name("홍길동"), new Position(0)));
    }

    @DisplayName("Car(name, position) 생성 테스트 : Car 생성 시 이름과 초기 위치값을 부여할 수 있다.")
    @Test
    void create_생성자에_이름과_위치값이_주어짐() {
        Car car = new Car(new Name("홍길동"), new Position(5));

        assertThat(car).usingRecursiveComparison()
                .comparingOnlyFields("name", "field")
                .isEqualTo(new Car(new Name("홍길동"), new Position(5)));
    }

    @DisplayName("Car(name) 생성 예외 테스트 : 5초과라면 IllegalArgumentException가 발생한다.")
    @Test
    void 예외발생_이름크기가_5자_초과인경우() {
        assertThatThrownBy(() -> new Car(new Name("일이삼사오륙")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 이름 크기는 5이하여야 합니다.");
    }

    @DisplayName("Car(name) 생성 예외 테스트 : 5이하라면 성공적으로 Car객체가 생성된다.")
    @Test
    void 예외발생하지않음_이름크기가_5자_이하인경우() {
        assertAll(
                () -> assertThatCode(() -> new Car(new Name("일이삼사오")))
                        .doesNotThrowAnyException(),
                () -> assertThatCode(() -> new Car(new Name("일이삼")))
                        .doesNotThrowAnyException(),
                () -> assertThatCode(() -> new Car(new Name("일")))
                        .doesNotThrowAnyException()
        );
    }

    @DisplayName("Car(name, position) 생성 예외 테스트 : 0보다 작다면 IllegalArgumentException가 발생한다.")
    @Test
    void 예외발생_위치값이_0보다_작은_경우() {
        assertThatThrownBy(() -> new Car(new Name("홍길동"), new Position(-1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 초기위치값은 0보다 작을 수 없습니다.");
    }

    @DisplayName("Car(name, position) 생성 예외 테스트 : 0이상이라면 성공적으로 Car객체가 생성된다.")
    @Test
    void 예외발생하지않음_위치값이_0_이상인_경우() {
        assertAll(
                () -> assertThatCode(() -> new Car(new Name("홍길동"), new Position(0)))
                        .doesNotThrowAnyException(),
                () -> assertThatCode(() -> new Car(new Name("홍길동"), new Position(1)))
                        .doesNotThrowAnyException()
        );
    }
}