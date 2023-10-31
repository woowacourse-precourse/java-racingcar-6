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

}
