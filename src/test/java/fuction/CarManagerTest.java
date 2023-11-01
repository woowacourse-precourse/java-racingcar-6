package fuction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.MockedStatic;
import racingcar.Car;
import racingcar.CarManager;
import racingcar.InputManager;

@TestInstance(Lifecycle.PER_CLASS)
public class CarManagerTest {
    private final int RUN_NUMBER = 4;
    private CarManager carManager;
    private ByteArrayOutputStream outputCaptor;

    @BeforeAll
    void setUp() {
        InputManager inputManager = new InputManager();
        this.carManager = new CarManager();
        this.outputCaptor = new ByteArrayOutputStream();

        ByteArrayInputStream in = new ByteArrayInputStream("p1,p2,p3".getBytes());
        System.setIn(in);

        carManager.setCars(inputManager.getNames());
    }

    @Test
    void printResultTest() {
        // given
        try (MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(RUN_NUMBER);

            carManager.runCars();
            carManager.runCars();
            System.setOut(new PrintStream(outputCaptor));

            // when
            carManager.printResult();

            // then
            assertEquals("p1 : --\r\np2 : --\r\np3 : --", outputCaptor.toString().strip());
        }
    }

    @Test
    void printWinnerTest() {
        // given
        try (MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(RUN_NUMBER);

            Car car = new Car("p4");
            car.run();

            Field privateField = carManager.getClass().getDeclaredField("cars");
            privateField.setAccessible(true);
            privateField.set(carManager, List.of(car));

            // when
            System.setOut(new PrintStream(outputCaptor));
            carManager.printWinner();

            // then
            assertEquals("최종 우승자 : p4", outputCaptor.toString().strip());

        } catch (NoSuchFieldException | IllegalAccessException e) {

        }
    }
}
