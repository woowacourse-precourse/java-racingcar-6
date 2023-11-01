package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    Game game = new Game();
    Car car;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 다수의_우승자_존재() {
        List<Car> cars = List.of(new Car("Car1", 2), new Car("Car2", 2), new Car("Car3", 2));
        assertTrue(game.areWinners(cars));
        List<Car> cars2 = List.of(new Car("Car1", 2));
        assertFalse(game.areWinners(cars2));
    }

    @Test
    void 우승자_선정() {
        List<Car> cars = List.of(new Car("Car1", 2), new Car("Car2", 2), new Car("Car3", 2));
        // 단일 우승인 경우
        cars.get(0).totalGoNumber = 1;
        cars.get(1).totalGoNumber = 2;
        cars.get(2).totalGoNumber = 0;
        assertEquals(game.selectWinner(cars), List.of(cars.get(1)));
        // 공동 우승인 경우
        cars.get(2).totalGoNumber = 2;
        assertEquals(game.selectWinner(cars), List.of(cars.get(1), cars.get(2)));
    }

    @Test
    void 배열을_문자열로_바꾸기() {
        // 테스트 입력 데이터
        String[] arr = {"A", "B", "C", "D", "E"};
        int turn = 3;
        // 메서드 호출 및 결과 확인
        String result = game.arrayToStringByTurn(arr, turn);
        // turn은 0부터 시작하므로 ABC가 아닌 ABCD가 나와야함
        assertEquals("ABCD", result);
    }

    @Test
    void 우승자_출력() {
        List<Car> cars = List.of(new Car("Car1", 3));
        // 테스트를 실행
        game.printWinner(cars);
        // 출력 결과를 문자열로 변환
        String output = outputStream.toString().trim();
        assertEquals("최종 우승자 : Car1", output);
    }

    @Test
    void 우승자들_출력() {
        List<Car> cars = List.of(new Car("Car1", 3), new Car("Car2", 3), new Car("Car3", 3));
        // 테스트를 실행
        game.printWinners(cars);
        // 출력 결과를 문자열로 변환
        String output = outputStream.toString().trim();
        assertEquals("최종 우승자 : Car1, Car2, Car3", output);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}