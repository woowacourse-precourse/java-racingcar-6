package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.game.ResultGame;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputTest {
    @Test
    void 단독_우승자_반환_기능(){
        List<String> list = new ArrayList<>();
        list.add("a");
        String result = ResultGame.connectWinners(list);
        assertEquals("a", result);
    }

    @Test
    void 공동_우승자_반환_기능(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        String result = ResultGame.connectWinners(list);
        assertEquals("a, b", result);
    }

    @Test
    void 단독_우승자_안내_문구_반환_기능(){
        String result = ResultGame.getResultGame("a");
        assertEquals("최종 우승자 : a", result);
    }

    @Test
    void 공동_우승자_안내_문구_반환_기능(){
        String result = ResultGame.getResultGame("a, b");
        assertEquals("최종 우승자 : a, b", result);
    }



}
