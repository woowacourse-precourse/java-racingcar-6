package study;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.core.GenerateRacer;
import racingcar.core.PickNumber;
import racingcar.entity.Racer;

import static org.assertj.core.api.Assertions.*;

public class CoreTest {

    @Test
    void PickNumber_인터페이스_랜덤숫자_기능_테스트(){
        //given
        Integer pickNumber = pickRandomNumber().racerPickNumber();
        System.out.println(pickNumber);
        //when & then
        assertThat(pickNumber).isGreaterThan(1);
        assertThat(pickNumber).isLessThan(9);
    }

    private static PickNumber pickRandomNumber(){
        return ()-> Randoms.pickNumberInRange(1,9);
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

    private static GenerateRacer generateRacer(){
        return (name)-> Racer.getInstance(name);
    }
}
