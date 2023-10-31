package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;


public class CarTest extends NsTest {
    private Car testCar;
    private static final String TEST_CAR_NAME = "k-5";
    private static final int REPEAT_TEST_NUMBER = 1000;

    @BeforeEach
    void 셋팅() {
        testCar = new Car(TEST_CAR_NAME);
    }

    private void 차_이동_메소드_시나리오(int randomNumber, int expectedPosition) {
        Car car = new Car(TEST_CAR_NAME) {
            @Override
            protected int createRandomNumber() {
                return randomNumber;
            }
        };
        car.moveIfRandomSuccess();
        assertEquals(expectedPosition, car.getCurrentPosition());
    }

    @Test
    public void 차_이동_메소드_시나리오_숫자_0() {
        차_이동_메소드_시나리오(0, 0);
    }

    @Test
    public void 차_이동_메소드_시나리오_숫자_3() {
        차_이동_메소드_시나리오(3, 0);
    }

    @Test
    public void 차_이동_메소드_시나리오_숫자_4() {
        차_이동_메소드_시나리오(4, 1);
    }

    @Test
    public void 차_이동_메소드_시나리오_숫자_9() {
        차_이동_메소드_시나리오(9, 1);
    }

    @Test
    void 차_이름_호출_메소드() {
        assertEquals(testCar.getName(), TEST_CAR_NAME);
    }

    @Test
    void 차_현재_위치_호출_메소드() throws Exception {
        int testCarPosition = 3;

        Field currentPositionField = Car.class.getDeclaredField("currentPosition");
        currentPositionField.setAccessible(true);
        currentPositionField.set(testCar, testCarPosition);

        assertEquals(testCar.getCurrentPosition(), testCarPosition);
    }

    @Test
    public void 차_랜덤수_생성_메소드() throws Exception {
        Method createRandomNumberMethod = Car.class.getDeclaredMethod("createRandomNumber");
        createRandomNumberMethod.setAccessible(true);

        for (int i = 0; i < REPEAT_TEST_NUMBER; i++) {
            int result = (int) createRandomNumberMethod.invoke(testCar);
            assertTrue(result >= 0 && result <= 9);
        }
    }

    @Test
    void 차_이름_공백_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Car("  "));
    }

    @Test
    void 차_이름_길이_초과_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Car(" 123141123"));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
