package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.GameService;
import view.InputView;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionTest {
    GameService gameService = new GameService();
    @Test
    void 연산자_에러테스트() { // 고쳐야됨
        String input = "abd,def";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String result = gameService.getInputLineOfCarNames();
        assertThat(result).isEqualTo("abd,def");
    }

}

