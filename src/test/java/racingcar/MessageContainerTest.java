package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MessageContainerTest {

    @Test
    void printCarResult_메서드로_자동차의_이름과_현재_위치를_출력() {
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
}
