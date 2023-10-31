package study;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.core.PickNumber;
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
}
