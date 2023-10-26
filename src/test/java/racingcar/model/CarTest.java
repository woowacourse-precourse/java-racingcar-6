package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenrator;

class CarTest {
    @Test
    void 자동차_모델_4이상의_값이_들어올_경우_포지션_상승하는_지_확인(){
        //given
        final Car car = new Car("JJONG", 0);
        final int moveCommand = new MoveNumberGenerator().generate();

        //when
        car.moveOrStop(moveCommand);

        //then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_모델_4이하의_값이_들어올_경우_포지션_증감_없는_지_확인(){
        //given
        final Car car = new Car("JJONG", 0);
        final int moveCommand = new NotMoveNumberGenerator().generate();

        //when
        car.moveOrStop(moveCommand);

        //then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    private class MoveNumberGenerator implements NumberGenrator {
        @Override
        public int generate() {
            return 4;
        }
    }

    private class NotMoveNumberGenerator implements NumberGenrator {
        @Override
        public int generate() {
            return 3;
        }
    }
}