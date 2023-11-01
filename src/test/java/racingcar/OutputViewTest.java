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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.race.Car;
import racingcar.view.OutputView;

class OutputViewTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
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
    @DisplayName("결과출력 인스턴스 생성확인")
    void ResultView_인스턴스_생성확인() {
        OutputView outputView = new OutputView(new ArrayList<Car>());
    }

    @Test
    @DisplayName("각 라운드 경주 상태에 대한 출력 확인")
    void printRace_동작확인() {
        OutputView.printRace(cars);
        String expectedOutput = "kim : \n" + "mi : \n\n";
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("우승자 출력 확인")
    void printWinners_동작확인() {
        OutputView.printWinners(winners);
        String expectedOutput = "최종 우승자 : kim, mi\n";
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectedOutput);
    }
}