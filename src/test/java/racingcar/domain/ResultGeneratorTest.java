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
    void getMaxMovingDistance_메서드로_가장_멀리_이동한_자동차의_위치_구하기_최댓값이_1개() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", 1));
        carList.add(new Car("B", 2));
        carList.add(new Car("C", 3));

        // when
        int maxMovingDistance = resultGenerator.getMaxMovingDistance(carList);

        // then
        assertThat(maxMovingDistance).isEqualTo(3);
    }

    @Test
    void getMaxMovingDistance_메서드로_가장_멀리_이동한_자동차의_위치_구하기_최댓값이_2개() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", 1));
        carList.add(new Car("B", 3));
        carList.add(new Car("C", 3));

        // when
        int maxMovingDistance = resultGenerator.getMaxMovingDistance(carList);

        // then
        assertThat(maxMovingDistance).isEqualTo(3);
    }

    @Test
    void getMaxMovingDistance_메서드로_가장_멀리_이동한_자동차의_위치_구하기_최댓값이_3개() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", 3));
        carList.add(new Car("B", 3));
        carList.add(new Car("C", 3));

        // when
        int maxMovingDistance = resultGenerator.getMaxMovingDistance(carList);

        // then
        assertThat(maxMovingDistance).isEqualTo(3);
    }

    @Test
    void generateWinnerList_메서드로_우승자_리스트_만들기_우승자_1명() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", 1));
        carList.add(new Car("B", 2));
        carList.add(new Car("C", 3));

        // when
        List<String> winnerList = resultGenerator.generateWinnerList(carList);

        // then
        assertThat(winnerList).isEqualTo(List.of("C"));
    }

    @Test
    void generateWinnerList_메서드로_우승자_리스트_만들기_우승자_2명() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", 1));
        carList.add(new Car("B", 3));
        carList.add(new Car("C", 3));

        ResultGenerator resultGenerator = new ResultGenerator();

        // when
        List<String> winnerList = resultGenerator.generateWinnerList(carList);

        // then
        assertThat(winnerList).isEqualTo(List.of("B", "C"));
    }

    @Test
    void generateWinnerList_메서드로_우승자_리스트_만들기_우승자_3명() {
        // given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("A", 3));
        carList.add(new Car("B", 3));
        carList.add(new Car("C", 3));

        // when
        List<String> winnerList = resultGenerator.generateWinnerList(carList);

        // then
        assertThat(winnerList).isEqualTo(List.of("A", "B", "C"));
    }

    @Test
    void printFinalResult_메서드로_최종_결과_출력_우승자_1명() {
        // given
        List<String> winnerList = List.of("A");

        // when
        resultGenerator.printFinalResult(winnerList);

        // then
        assertThat(outputStreamCaptor.toString())
                .contains("최종 우승자 :", "A");
    }

    @Test
    void printFinalResult_메서드로_최종_결과_출력_우승자_2명() {
        // given
        List<String> winnerList = List.of("A,B");

        // when
        resultGenerator.printFinalResult(winnerList);

        // then
        assertThat(outputStreamCaptor.toString())
                .contains("최종 우승자 :", "A,B");
    }

    @Test
    void printFinalResult_메서드로_최종_결과_출력_우승자_3명() {
        // given
        List<String> winnerList = List.of("A,B,C");

        // when
        resultGenerator.printFinalResult(winnerList);

        // then
        assertThat(outputStreamCaptor.toString())
                .contains("최종 우승자 :", "A,B,C");
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}