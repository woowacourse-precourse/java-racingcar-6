package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultViewTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private List<Car> cars;
    private List<Car> winners;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
        cars = Arrays.asList(new Car("kim"), new Car("mi"));
        winners = Arrays.asList(new Car("kim"), new Car("mi"));
    }

    @AfterEach
    public void restoreStreams() {
        Console.close();
    }


    @Test
    void ResultView_인스턴스_생성확인() {
        ResultView resultView = new ResultView(new ArrayList<Car>());
    }

    @Test
    void printRace_동작확인() {
        ResultView resultView = new ResultView(cars);
        resultView.printRace(cars);
        String expectedOutput = "kim : \n" + "mi : \n\n";
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void printWinners_동작확인() {
        ResultView resultView = new ResultView(winners);
        resultView.printWinners(winners);
        String expectedOutput = "최종 우승자 : kim, mi\n";
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectedOutput);
    }
}