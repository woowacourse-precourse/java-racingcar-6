package study;

import org.junit.jupiter.api.Test;
import racingcar.entity.RaceCount;
import racingcar.entity.RaceStatus;
import racingcar.entity.Racer;
import racingcar.entity.RoundScore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class EntityTest {

    @Test
    void Racer_유일_객체_인스턴스_테스트(){
        //given
        String racerName="test";
        int testRacerHashCode = Racer.getInstance("test").hashCode();

        //when
        Racer instance = Racer.getInstance(racerName);

        //then
        assertThat(instance.hashCode()).isEqualTo(testRacerHashCode);
    }

    @Test
    void RaceStatus_값_저장_로직_0점인경우_테스트(){
        //given
        Racer testRacer = Racer.getInstance("test");
        RoundScore testScore = RoundScore.STOP;

        //when
        RaceStatus.scoreWriteByRacer(testRacer, testScore);
        Integer roundResult = RaceStatus.scoreCheckByRacer(testRacer);

        //then
        assertThat(roundResult).isZero();
    }
}
