package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameClientIOTest {
    GameClientIO gameClientIO = new GameClientIO();

    public void setupInputStream(String inputString) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(byteArrayInputStream);
    }

    @Test
    @DisplayName("주어진 이름을 콤마(,)를 기준으로 정확히 분할한다.")
    public void splitByDelimiters() {
        String inputString = "a,b,c,d,e";
        setupInputStream(inputString);

        List<String> names = gameClientIO.getNames();
        assertThat(names).hasSameElementsAs(List.of("a", "b", "c", "d", "e"));
    }
}