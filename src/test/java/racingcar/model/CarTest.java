package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatus;
import racingcar.util.ProductionRandomNumberUtil;
import racingcar.util.RandomNumberUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 이름을 넘기면, 그 이름을 가진 자동차 객체가 생성된다.")
    @Test
    void Given_CarName_When_InitCar_Then_CarCreate() throws Exception {
        // Given
        String carName = "edgar";
        RandomNumberUtil randomNumberUtil = new ProductionRandomNumberUtil();
        int initialPosition = 0;

        // When
        Car car = new Car(randomNumberUtil, carName, initialPosition);
        CarStatus status = car.getStatus();

        // Then
        assertThat(status.carName()).isEqualTo(carName);
        assertThat(status.position()).isEqualTo(initialPosition);
    }

    @DisplayName("공백의 자동차 이름을 넘기면, 예외가 발생한다.")
    @Test
    void Given_EmptyCarName_When_InitCars_Then_ThrowException() throws Exception {
        // Given
        String emptyCarName = "";
        RandomNumberUtil randomNumberUtil = new ProductionRandomNumberUtil();
        int initialPosition = 0;

        // When & Then
        assertThatThrownBy(() -> new Car(randomNumberUtil, emptyCarName, initialPosition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 자동차 이름입니다.");
    }

    @DisplayName("최대 유효 길이를 초과하는 자동차 이름을 넘기면, 예외가 발생한다.")
    @Test
    void Given_SoLongCarName_When_InitCars_Then_ThrowException() throws Exception {
        // Given
        String soLongCarName = "abcdefghizklmkdjefefekfjekfjekfjekfjekfjek";
        RandomNumberUtil randomNumberUtil = new ProductionRandomNumberUtil();
        int initialPosition = 0;

        // When & Then
        assertThatThrownBy(() -> new Car(randomNumberUtil, soLongCarName, initialPosition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 자동차 이름입니다.");
    }

    @DisplayName("자동차가 전진하면, 자동차의 위치값이 증가한다.")
    @Test
    void Given_Car_When_CarForward_Then_CarPositionIncrease() throws Exception {
        // Given
        int startingCarPosition = 0;
        int expectedCarPosition = 1;
        Car car = new Car(createBoundedRandomNumberGenerator(), "edgar", startingCarPosition);

        // When
        car.forward();
        int currentPosition = car.getStatus().position();

        // Then
        assertThat(currentPosition).isEqualTo(expectedCarPosition);
    }

    @DisplayName("자동차가 전진하지 않으면, 자동차의 위치값은 변하지 않는다.")
    @Test
    void Given_Car_When_CarNotForward_Then_CarPositionNotChange() throws Exception {
        // Given
        int startingCarPosition = 0;
        int expectedCarPosition = 0;
        Car car = new Car(createNotBoundedRandomNumberGenerator(), "edgar", startingCarPosition);

        // When
        car.forward();
        int currentPosition = car.getStatus().position();

        // Then
        assertThat(currentPosition).isEqualTo(expectedCarPosition);
    }

    private RandomNumberUtil createBoundedRandomNumberGenerator() {
        return new RandomNumberUtil() {
            @Override
            public int generateNumberInRange(int startNumber, int endNumber) {
                return 5;
            }
        };
    }

    private RandomNumberUtil createNotBoundedRandomNumberGenerator() {
        return new RandomNumberUtil() {
            @Override
            public int generateNumberInRange(int startNumber, int endNumber) {
                return 0;
            }
        };
    }
}
