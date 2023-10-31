package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private Cars cars;
    private OutputStream outputStream;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    public void beforeEach() {
        cars = new Cars(List.of(new Car("kim"), new Car("lee"), new Car("han")));
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("자동차 경주 진행상황을 출력")
    public void printCurrentRaceResult_메서드_사용시_진행상황을_출력한다() {
        String expectedOutput = "kim : -\nlee : \nhan : \n\n";
        assertRandomNumberInRangeTest(
                () -> {
                    cars.move();
                    OutputView.printCurrentRaceResult(cars);
                    assertThat(outputStream.toString()).isEqualTo(expectedOutput);
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    @DisplayName("우승자 이름 출력")
    public void printWinnerNames_메서드_사용시_우승자_이름을_출력한다() {
        String expectedOutput = "최종 우승자 : kim, lee\n";
        assertRandomNumberInRangeTest(
                () -> {
                    cars.move();
                    OutputView.printWinnerNames(cars);
                    assertThat(outputStream.toString()).isEqualTo(expectedOutput);
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }
}