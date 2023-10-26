package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenrator;

class CarTest {
    @Test
    void 자동차_모델_4이상의_값이_들어올_경우_움직이는_지_확인(){
        //given
        Car car = new Car("JJONG", 0);
        int moveCommand = new MoveNumberGenerator().generate();

        //when
        car.moveOrStop(moveCommand);

        //then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
    private class MoveNumberGenerator implements NumberGenrator {
        @Override
        public int generate() {
            return 4;
        }
    }
}