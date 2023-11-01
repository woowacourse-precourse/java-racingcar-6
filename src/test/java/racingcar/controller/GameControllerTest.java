package racingcar.controller;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingGameService;
import racingcar.service.domain.CarEngine;
import racingcar.view.Input;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class GameControllerTest {

    PrintStream standardOut;
    OutputStream outputStream;

    GameController gameController = new GameController(new OutputView(), new InputView(new CustomInput()),
            new RacingGameService(), new CustomEngine());

    static final String expectedOutput = """
            경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
            시도할 회수는 몇회인가요?
                        
            실행 결과
            pobi : -
            woni :\s
            jun : -
                        
            pobi : --
            woni : -
            jun : --
                        
            pobi : ---
            woni : --
            jun : ---
                        
            pobi : ----
            woni : ---
            jun : ----
                        
            pobi : -----
            woni : ----
            jun : -----
                        
            최종 우승자 : pobi, jun""";

    @BeforeEach
    void beforeEach() {
        standardOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void afterEach() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("자동차 게임을 순서에 맞게 실행시키고, 최종 출력을 확인")
    void runTest() {
        gameController.run();
        Assertions.assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }

    static class CustomInput implements Input {

        @Override
        public String readCarNameLine() {
            return "pobi,woni,jun";
        }

        @Override
        public String readTotalRoundLine() {
            return "5";
        }
    }

    static class CustomEngine implements CarEngine {
        List<Integer> roundOnePowers = Lists.newArrayList(4, 3, 9);
        List<Integer> roundTwoPowers = Lists.newArrayList(7, 4, 8);
        List<Integer> roundThreePowers = Lists.newArrayList(4, 4, 4);
        List<Integer> roundFourPowers = Lists.newArrayList(6, 5, 9);
        List<Integer> roundFivePowers = Lists.newArrayList(8, 6, 5);


        @Override
        public int generateNumber() {
            if (!roundOnePowers.isEmpty()) {
                return roundOnePowers.remove(0);
            }
            if (!roundTwoPowers.isEmpty()) {
                return roundTwoPowers.remove(0);
            }
            if (!roundThreePowers.isEmpty()) {
                return roundThreePowers.remove(0);
            }
            if (!roundFourPowers.isEmpty()) {
                return roundFourPowers.remove(0);
            }
            return roundFivePowers.remove(0);
        }
    }
}