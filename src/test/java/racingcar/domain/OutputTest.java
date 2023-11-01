package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {

    Output output = new Output();
    OutputStream outputStream;

    List<CarName> carNameList = Arrays.asList(new CarName("test1"), new CarName("test2"), new CarName("test3"));
    CarNames carNames = new CarNames(carNameList);
    Cars cars = new Cars(carNames);

    @BeforeEach
    void setOutput() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("자동차이름 입력요구 출력")
    void printInputCarNameMessageTest() {
        //given

        //when
        output.printInputCarNameMessage();

        //then
        assertThat(outputStream.toString()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("게임횟수 입력요구 출력")
    void printInputGameCountMessageTest() {
        //given

        //when
        output.printInputGameCountMessage();

        //then
        assertThat(outputStream.toString()).contains("시도할 회수는 몇회인가요?");
    }

    @Test
    @DisplayName("실행결과 출력")
    void printResultMessageTest() {
        //given

        //when
        output.printResultMessage();

        //then
        assertThat(outputStream.toString()).contains("실행 결과");
    }

    @Test
    @DisplayName("Cars의 move()결과 출력")
    void printMoveResultTest() {
        //given

        //when
        output.printMoveResult(cars);

        //then
        assertThat(outputStream.toString()).contains("test1 : \ntest2 : \ntest3 : ");
    }

    @Test
    @DisplayName("우승자 명단 출력")
    void printWinner() {
        //given

        //when
        output.printWinner(cars);

        //then
        assertThat(outputStream.toString()).contains("최종 우승자 : test1, test2, test3");
    }
}