package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut((new PrintStream(output)));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("자동차 이동 성공 판단 테스트")
    void canMoveCarGeneralTest(int testInput) throws Exception{
        Car car = new Car("TEST");
        Method method = car.getClass().getDeclaredMethod("moveSuccessfully", int.class);

        method.setAccessible(true);
        boolean answer = (boolean) method.invoke(car, testInput);
        assertThat(answer).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("자동차 이동 실패 판단 테스트")
    void canMoveCarFailTest(int testInput) throws Exception{
        Car car = new Car("TEST");
        Method method = car.getClass().getDeclaredMethod("moveSuccessfully", int.class);

        method.setAccessible(true);
        boolean answer = (boolean) method.invoke(car, testInput);
        assertThat(answer).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("자동차 이동 성공 후 위치변경 테스트")
    void canMoveCarAfterDistanceGeneralTest(int testInput) throws Exception{
        Car car = new Car("TEST");
        Field field = car.getClass().getDeclaredField("information");

        field.setAccessible(true);
        car.move(testInput);
        Information information = (Information) field.get(car);
        assertThat(information.getDestination() == 1).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("자동차 이동 실패 후 위치변경 테스트")
    void canMoveCarAfterDistanceFailTest(int testInput) throws Exception{
        Car car = new Car("TEST");
        Field field = car.getClass().getDeclaredField("information");

        field.setAccessible(true);
        car.move(testInput);
        Information information = (Information) field.get(car);
        assertThat(information.getDestination() == 0).isTrue();
    }

    @Test
    @DisplayName("자동차 정보 출력 테스트")
    void canPrintInformationTest() throws Exception{
        Car car = new Car("TEST");
        String lineSeparator = System.lineSeparator();

        car.printInformation();
        assertThat(output.toString()).isEqualTo("TEST : " + lineSeparator);
        car.move(9);
        output.reset();
        car.printInformation();
        assertThat(output.toString()).isEqualTo("TEST : -" + lineSeparator);
        car.move(9);
        output.reset();
        car.printInformation();
        assertThat(output.toString()).isEqualTo("TEST : --" + lineSeparator);
    }
}
