package core;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.core.GenerateHighScores;
import racingcar.core.GenerateRacer;
import racingcar.core.PickNumber;
import racingcar.entity.Racer;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CoreTest {

    @Test
    void PickNumber_인터페이스_랜덤숫자_기능_테스트(){
        //given
        Integer pickNumber = pickRandomNumber().racerPickNumber();
        System.out.println(pickNumber);
        //when & then
        assertThat(pickNumber).isGreaterThan(0);
        assertThat(pickNumber).isLessThan(10);
    }


    @Test
    void GenerateRacer_인터페이스_레이서_생성_기능_테스트(){
        //given
        String target = "test";

        //when
        Racer generateRacer = generateRacer().generateRacerByInputValue(target);

        //then
        assertThat(Racer.getInstance(target).hashCode()).isEqualTo(generateRacer.hashCode());
    }

    @Test
    void GenerateHighScores_문자열_생성_로직_테스트(){
        //given
        List<Racer> racerList = List.of(Racer.getInstance("test1"),  Racer.getInstance("test3"));
        String targetResult = "test1, test3";

        //when
        GenerateHighScores generateHighScores = new GenerateHighScores(racerList);

        //then
        assertThat(generateHighScores.generateHighScoresByRacerList()).isEqualTo(targetResult);
    }
    private static PickNumber pickRandomNumber(){
        return ()-> Randoms.pickNumberInRange(1,9);
    }

    private static GenerateRacer generateRacer(){
        return (name)-> Racer.getInstance(name);
    }

}
