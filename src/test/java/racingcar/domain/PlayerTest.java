
package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Player;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    @AfterEach
    void setUP() {
        Console.close();
    }

    @Test
    void 자동차_이름_입력_테스트() {
        String input = "pobi,woni,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Player player = Player.getInstance();
        List<String> cars = player.inputCarName();

        assertThat(cars.get(0)).isEqualTo("pobi");
        assertThat(cars.get(1)).isEqualTo("woni");
        assertThat(cars.get(2)).isEqualTo("jun");
    }

    @Test
    void 시도_횟수_입력_테스트() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Player player = Player.getInstance();
        int count = player.inputCount();

        assertThat(count).isEqualTo(5);
    }

    @Test
    void 자동차대수가_3대_이상일_경우_예외_검증() {
        String input = "pobi,woni,jun,wuni";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Player player = Player.getInstance();

        assertThatThrownBy(player::inputCarName).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_5자_초과시_예외_검증() {
        String input = "pobi,woni,junnnn";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Player player = Player.getInstance();

        assertThatThrownBy(player::inputCarName).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_범위_초과_예외_검증() {
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Player player = Player.getInstance();

        assertThatThrownBy(player::inputCount).isInstanceOf(IllegalArgumentException.class);
    }
}