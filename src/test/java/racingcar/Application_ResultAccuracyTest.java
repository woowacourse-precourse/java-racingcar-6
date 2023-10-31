package racingcar;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Application_ResultAccuracyTest extends MyApplicationTest {
    private List<String> winners;

    @BeforeEach
    void setGameRandom() {
        Application.setRandom(null);
    }

    @AfterEach
    void resetWinners() {
        winners = null;
    }

    @Test
    void 정확한_최종_우승자를_산출() {
        Application.setRandom(new FixedGameRandom(List.of(3, 4)));
        run("pobi,woni", "10");

        assertThatNoException()
                .isThrownBy(() -> getWinners());

        assertThat(winners)
                .hasSize(1)
                .first()
                .isEqualTo("woni");
    }

    @Test
    void 최종_우승자가_여러명일_때_우승자_모두를_출력() {
        Application.setRandom(new FixedGameRandom(List.of(4, 3, 4)));
        run("pobi,woni,jun", "10");

        assertThatNoException()
                .isThrownBy(() -> getWinners());

        assertThat(winners)
                .hasSize(2)
                .containsExactly("pobi", "jun");

    }

    void getWinners() {
        Optional<String> resultString = outputs().stream()
                .filter(output -> output.contains("최종 우승자"))
                .findFirst();

        if (resultString.isEmpty()) {
            throw new RuntimeException("최종 우승자가 출력되지 않습니다.");
        }

        winners = getWinnersFromResultString(resultString.get());

    }

    List<String> getWinnersFromResultString(String resultString) {
        String[] tokens = resultString.split(":");
        return Arrays.stream(tokens[1].split(","))
                .map(str -> str.trim())
                .collect(toList());
    }
}
