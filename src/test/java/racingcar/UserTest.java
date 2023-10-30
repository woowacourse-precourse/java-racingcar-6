package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    @BeforeEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void giveCarName() {
        User user = new User();
        String names = "a,b,c,d";

        ByteArrayInputStream input = new ByteArrayInputStream(names.getBytes());
        System.setIn(input);

        List<String> carNames = user.giveCarName();
        assertThat(carNames).containsExactly(names.split(","));
    }

    @Test
    void numberOfRepeats() {
        User user = new User();
        String repeat = "5";

        ByteArrayInputStream input = new ByteArrayInputStream(repeat.getBytes());
        System.setIn(input);

        Long number = user.numberOfRepeats();
        assertThat(number).isEqualTo(Long.parseLong(repeat));
    }
}