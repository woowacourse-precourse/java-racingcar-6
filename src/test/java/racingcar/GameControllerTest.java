package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Controller.GameController;
import racingcar.Model.Car;

class GameControllerTest {
    static GameController gameController = new GameController();

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @BeforeAll
    static void set() {
        Car pobi = new Car("pobi", 5);
        Car woni = new Car("woni", 2);
        Car jun = new Car("jun", 3);

        gameController.getCarsList().add(pobi);
        gameController.getCarsList().add(woni);
        gameController.getCarsList().add(jun);
    }

    @DisplayName("해당 index의 car 이동 출력")
    @Test
    void printRaceTest() {
        gameController.printInRace(0);

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("pobi : -----");
    }

    @DisplayName("움직인 만큼 '-' 출력")
    @Test
    void calculateMoveTextTest() {
        var text = gameController.calculateMoveText(5);

        assertThat(text).isEqualTo("-----");
    }

    @DisplayName("자동차들 중 가장 많이 움직인 값 반환")
    @Test
    void calculateMaxMoveCountTest() {
        var maxCount = gameController.calculateMaxMoveCount(-1);

        assertThat(maxCount).isEqualTo(5);
    }

    @DisplayName("가장 많이 움직인 자동차(들)을 winnerList에 추가")
    @Test
    void addWinnerListTest() {
        gameController.addWinnerList(5);
        var winnerList = gameController.getWinnerList();

        assertThat(winnerList).contains("pobi");
    }

    @DisplayName("winnerList 안에 우승자 1명일 때 출력")
    @Test
    void createOneWinnerTextTest() {
        var text = "";
        gameController.getWinnerList().clear();
        gameController.getWinnerList().add("pobi");

        text = gameController.createWinnerText(text);

        assertThat(text).isEqualTo("pobi");
    }

    @DisplayName("winnerList 안에 우승자 여러명일 때 ','를 두고 출력")
    @Test
    void createMultipleWinnersTextTest() {
        var text = "";
        gameController.getWinnerList().clear();
        gameController.getWinnerList().add("pobi");
        gameController.getWinnerList().add("woni");

        text = gameController.createWinnerText(text);

        assertThat(text).isEqualTo("pobi,woni");
    }

    @DisplayName("최종 우승자 한 명일 때 결과 출력")
    @Test
    void printResultOneWinnerTest() {
        var text = "pobi";
        gameController.printResult(text);

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("최종 우승자 : pobi");
    }

    @DisplayName("최종 우승자 여러 명일 때 결과 출력")
    @Test
    void printResultMultipleWinnerTest() {
        var text = "pobi,woni";
        gameController.printResult(text);

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("최종 우승자 : pobi,woni");
    }
}