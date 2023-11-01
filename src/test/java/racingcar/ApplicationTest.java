package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 입력이름_예외_처리(){
        ErrorOccur errorOccur = new ErrorOccur();
        String carName = "moreThanFive";

        assertThatThrownBy(() -> errorOccur.returnCarError(carName))
                .hasCauseInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동값_처리(){
        MoveCar moveCar = new MoveCar();
        int move = 3;
        String result = moveCar.CarMove(move);
        assertThat(result).isEqualTo("---");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
