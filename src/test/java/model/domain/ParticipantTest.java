package model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParticipantTest {

    @Test
    void 이름은_콤마로_구분() {
        String carNames = "lee,na,yeon";
        Participant test = new Participant(carNames);

        assertEquals("lee", test.getParticipant().get(0).getNameValue());
        assertEquals("na", test.getParticipant().get(1).getNameValue());
        assertEquals("yeon", test.getParticipant().get(2).getNameValue());
    }

    @Test
    void 각_이름의_앞뒤_공백_제거() {
        String carNames = "lee, na ,  yeon";
        Participant test = new Participant(carNames);

        assertEquals("lee", test.getParticipant().get(0).getNameValue());
        assertEquals("na", test.getParticipant().get(1).getNameValue());
        assertEquals("yeon", test.getParticipant().get(2).getNameValue());
    }

    @Test
    void 자동차_이름은_중복_불가에_대한_예외_처리() {
        String carNames = "lee,na,na";
        assertThatThrownBy(() -> {
            new Participant(carNames);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_공백_불가에_대한_예외_처리() {
        String carNames = "lee,,na";
        assertThatThrownBy(() -> {
            new Participant(carNames);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}