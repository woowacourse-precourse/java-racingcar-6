package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class MoveTest {

    @Test
    void Car_객체_생성_시_이동_리스트_초기화(){

        // given
        Car car = new Car(Arrays.asList("pobi","woni","jun"));

        // then
        assertThat(car.movedDistances).isEqualTo(Arrays.asList("","",""));
    }

}
