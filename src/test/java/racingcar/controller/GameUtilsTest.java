package racingcar.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameUtilsTest {
    private GameUtils utility;
    @BeforeEach
    void setUp(){
        this.utility = new GameUtils();
    }
    @Test
    void 사용자_입력값을_정상적으로_처리(){
        String input = "123,456,789";
        List<String> result = utility.splitByComma(input);
        assertThat(result)
                .isNotEmpty()
                .contains("123","456","789");

    }
}
