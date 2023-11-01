package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarGameTest extends NsTest {

    @Test
    @Order(1)
    void 여러_이름_쉼표로_나누기(){
        RacingCarGame game = new RacingCarGame();
        System.setIn(createTestingInput("cys1,cys2,cys3"));

        assertThat(game.splitInputNames()).contains("cys1", "cys2", "cys3");
    }

    @Test
    @Order(2)
    void 여러_이름으로_Car_생성하기(){
        RacingCarGame game = new RacingCarGame();
        System.setIn(createTestingInput("aa,bb,cc"));
        String[] names = game.splitInputNames();
        game.inputNames(names);

        assertThat(game.carsToString()).isEqualTo(List.of("aa","bb","cc"));
    }

    @Test
    @Order(3)
    void 시도_횟수_입력확인(){
        RacingCarGame game = new RacingCarGame();
        System.setIn(createTestingInput("1"));
        game.inputTryLimit();

        assertThat(game.getTryLimit()).isEqualTo(1);
    }

    @Test
    @Order(4)
    void 게임_한_회분_테스트(){
        assertRandomNumberInRangeTest(
                ()->{
                    RacingCarGame game = new RacingCarGame();
                    System.setIn(createTestingInput("aa,bb,cc"));
                    String[] names = game.splitInputNames();
                    game.inputNames(names);
                    Console.close();

                    System.setIn(createTestingInput("1"));
                    game.inputTryLimit();

                    assertThat(game.raceForOneTry()).contains("aa : -\nbb : \ncc : -");

                },
                6,2,6
        );
    }

    @Test
    @Order(5)
    void 게임_2회분_테스트(){
        assertRandomNumberInRangeTest(
                ()->{
                    RacingCarGame game = new RacingCarGame();
                    System.setIn(createTestingInput("aa,bb,cc"));
                    String[] names = game.splitInputNames();
                    game.inputNames(names);
                    Console.close();

                    System.setIn(createTestingInput("2"));
                    game.inputTryLimit();

                    assertThat(game.race()).isEqualTo("aa : -\nbb : \ncc : -\n\naa : --\nbb : \ncc : -\n\n");

                },
                6,2,6
                ,6, 2, 2
        );
    }

    @Test
    @Order(5)
    void 우승_후보_트랙_길이_출력(){
        assertRandomNumberInRangeTest(
                ()->{
                    RacingCarGame game = new RacingCarGame();
                    System.setIn(createTestingInput("aa,bb,cc"));
                    String[] names = game.splitInputNames();
                    game.inputNames(names);
                    Console.close();

                    System.setIn(createTestingInput("2"));
                    game.inputTryLimit();

                    game.race();
                    game.setMax();

                    assertThat(game.getMax()).isEqualTo(2);

                },
                6,2,6
                ,6, 2, 2
        );
    }

    @Test
    @Order(6)
    void 게임_3명_5회() {
        assertRandomNumberInRangeTest(
                ()->{
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains(
                            "pobi : -", "woni : ","jun : -"
                            ,"pobi : --","woni : -","jun : --"
                            ,"pobi : ---","woni : --","jun : ---"
                            ,"pobi : ----","woni : ---","jun : ----"
                            ,"pobi : -----","woni : ----","jun : -----"
                            ,"최종 우승자 : pobi, jun"
                    );
                },
                4, 3, 4
                ,4, 4, 4
                ,4, 4, 4
                ,4, 4, 4
                ,4, 4, 4
        );
    }

    InputStream createTestingInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
    @AfterEach
    void closeConsoleStream(){
        Console.close();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
