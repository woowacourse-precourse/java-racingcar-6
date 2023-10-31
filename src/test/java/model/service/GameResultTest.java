package model.service;

import static org.junit.jupiter.api.Assertions.*;

import model.domain.Participant;
import model.domain.Winner;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void 단독_우승일_경우() {
        Participant test = new Participant("lee,na,yeon");
        test.getParticipant().get(0).addGo();

        Winner result = GameResult.winner(test);

        assertEquals("lee", result.toString());
    }

    @Test
    void 공동_우승일_경우() {
        Participant test = new Participant("lee,na,yeon");
        test.getParticipant().get(0).addGo();
        test.getParticipant().get(2).addGo();

        Winner result = GameResult.winner(test);

        assertEquals("lee, yeon", result.toString());
    }

}