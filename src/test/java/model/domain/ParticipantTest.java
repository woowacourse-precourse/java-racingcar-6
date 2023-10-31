package model.domain;

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
    void 각_이름의_앞뒤_공백_제거(){
        String carNames = "lee, na ,  yeon";
        Participant test = new Participant(carNames);

        assertEquals("lee", test.getParticipant().get(0).getNameValue());
        assertEquals("na", test.getParticipant().get(1).getNameValue());
        assertEquals("yeon", test.getParticipant().get(2).getNameValue());
    }
}