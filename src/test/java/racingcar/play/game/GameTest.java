package racingcar.play.game;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void 게임_승자_한명(){
        //given
        List<String> names = Arrays.asList("test1", "test2", "test3");
        Map<String, String> score = new LinkedHashMap<>();
        for(String name : names){
            score.put(name, "");
        }
        score.put("test1", "---");

        String s = "최종 우승자 : test1";

        //when

        String temp = Game.end(score);
        //then
        assertThat(temp).isEqualTo(s);
    }

    @Test
    void 게임_승자_여러명(){
        //given
        List<String> names = Arrays.asList("test1", "test2", "test3");
        Map<String, String> score = new LinkedHashMap<>();
        for(String name : names){
            score.put(name, "");
        }
        score.put("test1", "---");
        score.put("test2", "---");

        String s = "최종 우승자 : test1, test2";

        //when

        String temp = Game.end(score);
        //then
        assertThat(temp).isEqualTo(s);
    }

}
