package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingBoardTest {

    RacingBoard racingBoard;

    @BeforeEach
    public void beforeEach() {
        racingBoard = new RacingBoard();
    }

    @Test
    void viewWinner() {
        //given
        String compareStr = "abc, def, ghi";
        String[] testStrArray = {"abc", "def", "ghi"};
        ArrayList<String> testWinnerList = new ArrayList<>(Arrays.asList(testStrArray));
        racingBoard.recordWinner(testWinnerList);
        //when
        String result = racingBoard.viewWinner();
        //then
        Assertions.assertThat(result).isEqualTo(compareStr);
    }
}