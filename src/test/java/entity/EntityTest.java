package entity;

import org.junit.jupiter.api.Test;
import racingcar.entity.*;
import racingcar.property.ErrorProperty;

import static org.assertj.core.api.Assertions.*;

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
    void Racer_객체_생성_시_이름_유효성_검사_로직_테스트(){
        //given
        String targetName="한글1";

        //when
        assertThatThrownBy(()->{
            Racer.getInstance(targetName);
        }
            ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorProperty.NAME_VALUE_IS_NOT_CORRECT_FORM);
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
    @Test
    void RaceStatus_값_저장_로직_1점인경우_테스트(){
        //given
        Racer testRacer = Racer.getInstance("test");
        RoundScore testScore = RoundScore.FORWARD;

        //when
        RaceStatus.scoreWriteByRacer(testRacer, testScore);
        Integer roundResult = RaceStatus.scoreCheckByRacer(testRacer);

        //then
        assertThat(roundResult).isOne();
    }

    @Test
    void Racing_값_난수_생성_테스트(){
        //given
        Racer testRacer = Racer.getInstance("test");

        //when
        Racing racing = new Racing(testRacer);
        RoundScore roundResult = racing.racingByRacer();

        //then
        assertThat(roundResult).isInstanceOf(RoundScore.class);
    }

    @Test
    void RoundResult_라운드_결과_기록_로직_테스트(){
        //given
        Racer testRacer = Racer.getInstance("test");
        String targetResult = "test : -\n";
        //when
        racerScored(testRacer);
        RoundResult.writeRoundResult(testRacer);
        //then
        assertThat(RoundResult.getResultOfRound().toString()).isEqualTo(targetResult);
    }

    private static void racerScored(Racer racer){
        //given
        RoundScore roundResult=RoundScore.FORWARD;

        RaceStatus.scoreWriteByRacer(racer,roundResult);
    }
}
