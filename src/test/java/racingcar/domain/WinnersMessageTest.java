package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinnersMessageTest {

    @Test
    void toString_메시지_생성() {
        WinnersMessage message = new WinnersMessage(List.of("foo", "bar"));
        assertEquals(message.toString(), "최종 우승자 : foo, bar");
    }

}