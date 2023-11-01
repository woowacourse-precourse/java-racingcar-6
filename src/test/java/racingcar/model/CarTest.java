package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racingcar.util.RandomNumberGenerator;
import racingcar.vo.CarName;

class CarTest {

    private static final Integer START_POINT = 0;
    private static final Integer THRESHOLD = 4;

    private static MockedStatic<RandomNumberGenerator> randomNumberGeneratorMockedStatic;
    private Car car;

    @BeforeAll
    public static void beforeAll() {
        randomNumberGeneratorMockedStatic = mockStatic(RandomNumberGenerator.class);
    }

    @AfterAll
    public static void AfterAll() {
        randomNumberGeneratorMockedStatic.close();
    }

    @DisplayName("자동차 이름이 5자 이하인 경우 예외 발생 없이, 객체가 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"12345", "abcde"})
    void valid_carName_test(String name) {
        // given
        CarName carName = new CarName(name);

        // when
        car = new Car(carName);

        // then
        assertNotNull(car);
        assertEquals(carName.name(), car.getCarName().name());
        assertEquals(START_POINT, car.getCarPosition().position());
    }

    @DisplayName("자동차 이름이 6자 이상인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "abcdef"})
    void inValid_carName_test(String name) {
        assertThrows(IllegalArgumentException.class, () -> {
            CarName carName = new CarName(name);
        });
    }

    @DisplayName("랜덤 숫자가 임계치 이상인 경우 자동차는 전진한다.")
    @Test
    void updatePosition_moving_required_test() throws Exception {
        Car car = new Car(new CarName("Car1"));
        given(RandomNumberGenerator.pickNumber()).willReturn(THRESHOLD);

        Integer originalPosition = car.getCarPosition().position();

        for (int i = 1; i <= 1000; i++) {
            car.updatePosition();
            Integer newPosition = car.getCarPosition().position();
            assertTrue(newPosition == (originalPosition + i));
        }
    }

    @DisplayName("랜덤 숫자가 임계치 미만인 경우 자동차는 전진하지 않는다.")
    @Test
    void updatePosition_not_moving_required_test() throws Exception {
        Car car = new Car(new CarName("Car1"));
        given(RandomNumberGenerator.pickNumber()).willReturn(THRESHOLD - 1);

        Integer originalPosition = car.getCarPosition().position();

        for (int i = 1; i <= 1000; i++) {
            car.updatePosition();
        }

        Integer newPosition = car.getCarPosition().position();
        assertTrue(newPosition == originalPosition);
    }
}
