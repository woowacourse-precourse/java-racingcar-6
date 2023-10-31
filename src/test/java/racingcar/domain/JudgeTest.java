package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.InputHandler;

class JudgeTest {
    private Judge judge;

    @BeforeEach
    void setUp() {
        judge = new Judge();
        Console.close();
    }

    void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    @DisplayName("차량 등록 기능 테스트")
    void setCarsTest1() {
        setInput("pobi,woni,jun\n");
        judge.setCars(InputHandler.makeCarNamesArray());
        List<Car> actualCars = judge.getCars();
        List<Car> expectedCars = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun"));
        assertThat(actualCars).isEqualTo(expectedCars);
    }

    @Test
    @DisplayName("run 메소드 1회 테스트")
    void runTest1() {
        setInput("pobi,woni,jun\n");
        judge.setCars(InputHandler.makeCarNamesArray());
        judge.moveCars();
        judge.selectWinner();
    }

    @Test
    @DisplayName("run 메소드 2회 테스트")
    void runTest2() {
        setInput("pobi,woni,jun\n");
        judge.setCars(InputHandler.makeCarNamesArray());
        judge.moveCars();
        judge.moveCars();
        judge.selectWinner();
    }
}