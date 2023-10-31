package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }
    @Test
    public void getCarNames_Test() {
        String input = "pobi,woni,jun";
        String[] result = input.split(",");

        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    public void getRoundCount_Test() {
        String input = "5";
        String[] result = input.split(",");

        assertThat(result).contains("5");
    }
}
