package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

class makeTest {


    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Test
    void 난수에_따른_전진_테스트() {
        Application.RacingCar = new LinkedList<>(Arrays.asList("Car1", "Car2"));
        Application.RacingScore = new LinkedList<>(Arrays.asList(0, 0));

        Application.Match_game();

        assertThat(Application.RacingScore)
                .allSatisfy(score -> assertThat(score).isGreaterThan(-1).isLessThan(2));
    }


    @Test
    void 이긴_자동차_고르기() {
        Application.RacingCar = new LinkedList<>(Arrays.asList("Car1", "Car2"));
        Application.RacingScore = new LinkedList<>(Arrays.asList(2, 5));

        Application.Racing_winner();

        assertThat(Application.Winner).contains("Car2");
    }

    @Test
    void 이긴_자동차_고르기_중복() {
        Application.RacingCar = new LinkedList<>(Arrays.asList("Car1", "Car2"));
        Application.RacingScore = new LinkedList<>(Arrays.asList(3, 3));

        Application.Racing_winner();

        assertThat(Application.Winner).contains("Car1", "Car2");
    }


    @Test
    void 우승자_출력_한명일때() {

        Application.InputCarName = "Car1, Car2, Car3";
        Application.Winner = new LinkedList<>();
        Application.Winner.add("Car2");

        System.setOut(new PrintStream(output));

        Application.Winner_Print();

        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : Car2");

        System.setOut(System.out);
    }


    @Test
    void 우승자_출력_여러명일때() {
        Application.InputCarName = "Car1, Car2, Car3";
        Application.Winner = new LinkedList<>();
        Application.Winner.add("Car2");
        Application.Winner.add("Car3");

        System.setOut(new PrintStream(output));

        Application.Winner_Print();

        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : Car2, Car3");

        System.setOut(System.out);
    }
}