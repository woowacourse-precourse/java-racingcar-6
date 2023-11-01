package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void 가장_많이_이동한_자동차_이름_찾기(){
        //given
        List<String> cars = List.of("carA", "carB", "carC");
        List<StringBuilder> moves = List.of(
                new StringBuilder("--"),
                new StringBuilder("---"),
                new StringBuilder("---")
        );

        //when
        List<String> winners =  List.of("carB", "carC");

        //then
        assertThat(String.join(",", moveController.findWinner(cars, moves)))
                .isEqualTo(String.join(",", winners));
    }
}
