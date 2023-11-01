package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.TestCommon;

class GameTest extends TestCommon {
    private Game game;

    @BeforeEach
    void testInit() {
        game = new Game(new Cars(), new Rounds());
    }

    @Test
    void 우승자가_한명일때_결과가_정상적으로_출력_되는지_확인한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    String expectedResult = 우승자가_한명일때_결과();
                    setInputs("pobi,woni", "1");

                    game.start();

                    assertThat(getOutput()).isEqualTo(expectedResult);
                },
                MOVING_FORWARD, STOP
        );
    }

    private String 우승자가_한명일때_결과() {
        return makeString(
                "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", NEW_LINE
                , "시도할 회수는 몇회인가요?", NEW_LINE
                , "pobi : -", NEW_LINE
                , "woni : ", NEW_LINE
                , NEW_LINE
                , "최종 우승자 : pobi"
        );
    }

    @Test
    void 우승자가_세명일때_결과가_정상적으로_출력_되는지_확인한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    String expectedResult = 우승자가_세명일때_결과();
                    setInputs("pobi,woni,hong", "1");

                    game.start();

                    assertThat(getOutput()).isEqualTo(expectedResult);
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    private String 우승자가_세명일때_결과() {
        return makeString(
                "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", NEW_LINE
                , "시도할 회수는 몇회인가요?", NEW_LINE
                , "pobi : -", NEW_LINE
                , "woni : -", NEW_LINE
                , "hong : -", NEW_LINE
                , NEW_LINE
                , "최종 우승자 : pobi, woni, hong"
        );
    }

    @Test
    void 라운드가_2개일때_정상적으로_출력_되는지_확인한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    String expectedResult = 라운드가_2개일때_결과();
                    setInputs("pobi,woni", "2");

                    game.start();

                    assertThat(getOutput()).isEqualTo(expectedResult);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    private String 라운드가_2개일때_결과() {
        return makeString(
                "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", NEW_LINE
                , "시도할 회수는 몇회인가요?", NEW_LINE
                , "pobi : -", NEW_LINE
                , "woni : ", NEW_LINE
                , NEW_LINE
                , "pobi : --", NEW_LINE
                , "woni : -", NEW_LINE
                , NEW_LINE
                , "최종 우승자 : pobi"
        );
    }
}