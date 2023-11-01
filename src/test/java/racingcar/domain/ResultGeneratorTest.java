package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


class ResultGeneratorTest {
    private ResultGenerator resultGenerator;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        resultGenerator = new ResultGenerator();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void playRound_메서드로_게임라운드_진행() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", 0));
        carList.add(new Car("B", 0));
        carList.add(new Car("C", 0));

        // when
        resultGenerator.playRound(carList);

        // then
        assertThat(outputStreamCaptor.toString())
                .contains("A :", "B : ", "C :");
    }

    @Test
    void getMaxMovingDistance() {
    }

    @Test
    void generateWinnerList() {
    }

    @Test
    void printFinalResult() {
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}