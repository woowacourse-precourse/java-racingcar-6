package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameClientInputTest {
    GameClientInput gameClientInput = new GameClientInput();

    public void setupInputStream(String inputString) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(byteArrayInputStream);
    }

    @Test
    @DisplayName("주어진 이름을 콤마(,)를 기준으로 정확히 분할한다.")
    public void splitByDelimiters() {
        String inputString = "a,b,c,d,e";
        setupInputStream(inputString);

        List<String> names = gameClientInput.getNames();
        assertThat(names).hasSameElementsAs(List.of("a", "b", "c", "d", "e"));
    }

    @Test
    @DisplayName("총 이동 횟수가 입력으로 주어지면 올바르게 변환한다.")
    public void getMoves() {
        String inputString = "123";
        setupInputStream(inputString);

        int moves = gameClientInput.getTotalMoves();
        assertThat(moves).isEqualTo(123);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1001"})
    @DisplayName("주어진 수가 범위 내에 존재하지 않으면 예외를 발생한다.")
    public void movesRangeException(String inputString) {
        setupInputStream(inputString);
        assertThatThrownBy(gameClientInput::getTotalMoves)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @AfterEach
    public void tearDown() {
        Console.close();
    }
}