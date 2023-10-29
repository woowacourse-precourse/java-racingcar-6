package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.service.CarMove;
import racingcar.service.CarName;
import racingcar.service.RandomNumber;

public class CarMoveTest {

    RandomNumber randomNumber = new RandomNumber();
    CarMove carMove = new CarMove();
    CarName carName = new CarName();

    @Test
    void 일정숫자_이상이면_길이증가() {
        System.out.println(randomNumber.generate());
        if (randomNumber.generate() >= 4) {
            assertThat(carMove.increaseLength() == 1);
        } else if (randomNumber.generate() < 4) {
            assertThat(carMove.increaseLength() == 0);
        }

    }

    @Test
    void 전체_자동차_리스트_길이증가(){
        List<Integer> LengthCount = new ArrayList<>();
        for (int i=0; i<3; i++){
            LengthCount.add(carMove.increaseLength());
        }
        System.out.println(LengthCount);
        assertThat(LengthCount.size()==3);
    }


}


