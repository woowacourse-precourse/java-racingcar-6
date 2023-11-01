package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingTest {

    @Test
    public void testInsertCarName() {
        // 시뮬레이트할 입력
        String input = "car1,car2,car3";

        // 메서드 호출
        List<Car> cars = Application.insertCarName(input);

        // 결과 검증
        assertEquals(3, cars.size());
    }

    @Test
    public void testInsertCarName_InvalidInput() {
        // 시뮬레이트할 입력
        String input = "car1,car2,car3456";
        // Console.readLine()을 모의(Mock)화하고 입력값 설정

        // 메서드 호출 및 예외 검증
        assertThrows(IllegalArgumentException.class, () -> {
            Application.insertCarName(input);
        });
    }

    @Test
    public void testInsertNumberOfMoves() {
        // 시뮬레이트할 입력
        int input = 5;
        // Console.readLine()을 모의(Mock)화하고 입력값 설정

        // 메서드 호출
        int numberOfMoves = Application.insertNumberOfMoves(input);

        // 결과 검증
        assertEquals(5, numberOfMoves);
    }

    @Test
    public void testInsertNumberOfMoves_NegativeInput() {
        // 시뮬레이트할 입력
        int input = -5;
        // Console.readLine()을 모의(Mock)화하고 입력값 설정

        // 메서드 호출 및 예외 검증
        assertThrows(IllegalArgumentException.class, () -> {
            Application.insertNumberOfMoves(input);
        });
    }

    @Test
    public void testInsertNumberOfMoves_InvalidInput() {
        String input = "invalid";

        // 이전 System.in 저장
        InputStream originalSystemIn = System.in;

        // 모의(Mock) 입력 설정
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 예외를 던지는지 검증
        assertThrows(IllegalArgumentException.class, () -> {
            Application.insertNumberOfMoves(0);
        });
    }

    @Test
    public void testGetWinner() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move(5);
        car2.move(3);
        List<Car> cars = Arrays.asList(car1, car2);

        List<String> winners = Application.getWinner(cars);

        assertEquals(1, winners.size());
        assertTrue(winners.contains("car1"));
    }

    @Test
    public void testGetWinner_MultipleWinners() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move(3);
        car2.move(3);
        List<Car> cars = Arrays.asList(car1, car2);

        List<String> winners = Application.getWinner(cars);

        assertEquals(2, winners.size());
        assertTrue(winners.contains("car1"));
        assertTrue(winners.contains("car2"));
    }

}
