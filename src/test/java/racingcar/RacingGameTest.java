package racingcar;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

@DisplayName("RacingGame 테스트")
public class RacingGameTest {

    @Test
    @DisplayName("첫 문자열 오류 테스트")
    void 문자열오류테스트(){
        RacingGame game = new RacingGame();
        String input = "abc,,efg";
        Assertions.assertThatThrownBy(()->
                game.getNameList(input))
                        .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("첫 문자열 비교 테스트")
    void 문자열비교테스트(){
        String[] inputline;
        RacingGame game = new RacingGame();
        String input = "abc,bcdef,efg";
        inputline = game.getNameList(input);
        Assertions.assertThat(inputline).containsExactly("abc","bcdef","efg");
    }

    @Test
    @DisplayName("점수 문자열 변환 및 입력 테스트")
    void 점수문자열변환테스트(){
        int testscore = 5;
        RacingGame game = new RacingGame();
        String scoreLine = RacingGame.scoretoString(testscore);
        Assertions.assertThat(scoreLine).isEqualTo("-----");
    }

    @Test
    @DisplayName("승자 테스트")
    void 승자테스트(){
        RacingGame game = new RacingGame();
        String testWinner = "ama, mam";
        String gameWinner;
        game.setScoreboard(new HashMap<String,Integer>(){{
                put("abc",5);
                put("mam",6);
                put("bcd",3);
                put("ama",6);
            }});

        gameWinner = game.chooseWinner();
        Assertions.assertThat(gameWinner).isEqualTo(testWinner);
    }
}
