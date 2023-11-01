package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
    private Game game;
    private Cars cars;
    private ResultByRace resultByRace;

    @BeforeEach
    void setUp() {
        game = new Game();
        cars = new Cars();
        resultByRace = new ResultByRace();
    }

    @Test
    void play() {
        testCreateCars();
        Console.close();
        testAskPlayTime();
        showWinner();
    }

    @DisplayName("경주를 진행할 각 자동차 이름을 입력")
    @Test
    void testCreateCars() {
        System.setIn(createUserInput("pobi,woni,jun"));
        cars.createCars();
        assertEquals(3, cars.getCars().size());
    }

    @DisplayName("전진할 이동 회수를 입력")
    @Test
    void testAskPlayTime() {
        System.setIn(createUserInput(3));
        resultByRace.askPlayTime();
        assertEquals(3, resultByRace.getFinalRound());
    }
    @DisplayName("각 차수 별 실행결과 출력")
    @Test
    void showEachResult() {
        resultByRace.showEachResult(cars);
    }

    @DisplayName("우승자 판단 후 출력")
    @Test
    void showWinner() {
        resultByRace.showWinner(cars);
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    InputStream createUserInput(int input) {
        return new ByteArrayInputStream(String.valueOf(input).getBytes());
    }
}