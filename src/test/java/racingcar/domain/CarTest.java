package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.framework;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.util.RandomNumber;

public class CarTest {

    private MockedStatic<RandomNumber> mockedRandomNumber;

    @BeforeEach
    void setUp() {
        mockedRandomNumber = mockStatic(RandomNumber.class);
    }

    @AfterEach
    void tearDown() {
        mockedRandomNumber.close();
    }

    @Test
    void car_생성자() {
        String name = "pobi";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 랜덤숫자_4미만_수에서_움직이지_않음_확인() {
        // 모의 객체(Mock)을 사용하여 RandomNumber.createRandomNumber()의 결과 조작
        mockedRandomNumber.when(RandomNumber::createRandomNumber).thenReturn(2);

        Car car = new Car("pobi");
        car.move();

        assertEquals(0, car.getMoveDistance());
    }

    @Test
    void 랜덤숫자_4이상_수에서_전진_확인() {
        // 모의 객체(Mock)을 사용하여 RandomNumber.createRandomNumber()의 결과 조작
        mockedRandomNumber.when(RandomNumber::createRandomNumber).thenReturn(7);

        Car car = new Car("pobi");
        car.move();

        assertEquals(1, car.getMoveDistance());
    }
}
