package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.CarsTest.StubNineNumberGenerator;
import racingcar.domain.Cars;
import racingcar.domain.RaceRound;
import racingcar.view.OutputView;

class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    StubNineNumberGenerator stubNineNumberGenerator = new StubNineNumberGenerator();

    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("레이싱 라운드의 결과를 올바르게 처리한다.")
    @Test
    void printRacingResult() {

        List<String> stringCarName = new ArrayList<>();
        stringCarName.add("pobi");
        stringCarName.add("woni");
        Cars cars = new Cars(stringCarName);
        RaceRound raceRound = new RaceRound("1");

        OutputView outputView = new OutputView();
        // 숫자가 9만 생성되는 stubNineNumberGenerator 주입
        outputView.printRacingResult(cars, raceRound, stubNineNumberGenerator);

        assertThat(output.toString().trim()).isEqualTo("실행 결과\r\npobi : -\r\nwoni : -");
    }

    @DisplayName("최종 우승자가 여러명이면 ,로 구분한다.")
    @Test
    void printWinners() {
        OutputView outputView = new OutputView();
        outputView.printWinner(Arrays.asList("pobi", "woni"));

        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : pobi, woni");
    }

    @DisplayName("최종 우승자가 한명일때는 ,가 없다.")
    @Test
    void printWinner() {
        OutputView outputView = new OutputView();
        outputView.printWinner(Arrays.asList("pobi"));

        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : pobi");
    }
}