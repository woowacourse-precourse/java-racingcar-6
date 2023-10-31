package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarTest {

    private static MockedStatic<Randoms> randoms;
    private Car car;

    @BeforeAll
    static void beforeSetUp() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterAll
    static void afterAll() {
        randoms.close();
    }

    @BeforeEach
    void init() {
        car = Car.create("test");
    }

    @Test
    @DisplayName("전진 조건을 만족할 경우, 자동차는 전진한다.")
    void testCarMoveWhenConditionsMet(){
        randoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(5);
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진 조건을 만족하지 못할 경우, 자동차는 정지한다.")
    void testCarStopsWhenConditionsUnmet(){
        randoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(2);
        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
