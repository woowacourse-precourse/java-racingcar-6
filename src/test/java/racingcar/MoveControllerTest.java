package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MoveControllerTest {
    final MoveController moveController = new MoveController();

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 난수가_4_이상이면_차_이동하기(int randomNumber) {
        //given
        StringBuilder mark = new StringBuilder();

        //when
        moveController.moveCar(mark, randomNumber);

        //then
        assertEquals(mark.toString(), "-");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 난수가_4_미만이면_이동하지_않기(int randomNumber) {
        //given
        StringBuilder mark = new StringBuilder();

        //when
        moveController.moveCar(mark, randomNumber);

        //then
        assertEquals(mark.toString(), "");
    }
}
