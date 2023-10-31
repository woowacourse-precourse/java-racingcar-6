package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MessageContainerTest {

    @Test
    void showCarResult_메서드로_자동차의_이름과_현재_위치를_나타내는_문자열_생성() {
        Car car1 = new Car("pobi", 0);
        Car car2 = new Car("woni", 2);
        Car car3 = new Car("jun", 5);
        MessageContainer messageContainer = new MessageContainer();

        String actual1 = messageContainer.showCarResult(car1);
        String actual2 = messageContainer.showCarResult(car2);
        String actual3 = messageContainer.showCarResult(car3);

        assertThat(actual1).isEqualTo("pobi : ");
        assertThat(actual2).isEqualTo("woni : --");
        assertThat(actual3).isEqualTo("jun : -----");
    }

    @Test
    void showWinners_메서드로_우승자_안내_문구_생성() {
        List<String> winnerNames1 = new ArrayList<>();
        List<String> winnerNames2 = new ArrayList<>();
        winnerNames2.add("pobi");
        List<String> winnerNames3 = new ArrayList<>();
        winnerNames3.add("jun");
        winnerNames3.add("lisa");
        MessageContainer messageContainer = new MessageContainer();

        String actual1 = messageContainer.showWinners(winnerNames1);
        String actual2 = messageContainer.showWinners(winnerNames2);
        String actual3 = messageContainer.showWinners(winnerNames3);

        assertThat(actual1).isEqualTo("최종 우승자 : ");
        assertThat(actual2).isEqualTo("최종 우승자 : pobi");
        assertThat(actual3).isEqualTo("최종 우승자 : jun, lisa");
    }
}
