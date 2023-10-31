package model.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

import model.domain.Name;
import model.domain.Participant;
import org.junit.jupiter.api.Test;

class GamePlayTest {

    @Test
    void 랜덤값이_4이상이면_전진() {
        assertRandomNumberInRangeTest(() -> {
            Participant test = new Participant("a,b,c,d,e,f,g,h,i,j");
            GamePlay.round(test);

            for(int i = 0; i <= 3; i++){
                assertEquals(0, test.getParticipant().get(i).getGoValue());
            }

            for(int i = 4; i <= 9; i++){
                assertEquals(1, test.getParticipant().get(i).getGoValue());
            }

        }, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    }

}