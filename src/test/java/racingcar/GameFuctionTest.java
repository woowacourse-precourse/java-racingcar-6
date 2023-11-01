package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;


public class GameFuctionTest {
    GameFunction gameFunction = new GameFunction();

    @Test
    void 사용자에게_자동차이름_입력받기(){
        String input = "1,2";
        String[] expected = input.split(",");

        List<String> result = gameFunction.SplitCarName(input);

        assertThat(result).contains(expected);
    }
    @Test
    void 구분자를_포함하는가(){

    }
    @Test
    void 구분자를_포함하지_않았을떄_(){

    }

    @Test
    void 이름이_다섯자_이하인가(){

    }
    @Test
    void 자동차_전진횟수_입력받기(){

    }
    @Test
    void 이동횟수에_숫자를_입력했는가(){

    }
    @Test
    void 영에서_구사이_난수_발생(){

    }

    @Test
    void 사_이상인_경우에_전진(){

    }
    @Test
    void 매회차마다_차의_전진여부를_합산(){

    }

    @Test
    void 시도횟수만큼_반복하기(){

    }
    @Test
    void 매_턴마다_게임_진행_출력하는_기능(){

    }
    @Test
    void 우승자_출력하기(){

    }

}
