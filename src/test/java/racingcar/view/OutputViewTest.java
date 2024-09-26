package racingcar.view;

import static org.assertj.core.api.Assertions.*;
import static racingcar.view.OutputView.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class OutputViewTest {

    @Test
    @DisplayName("기능22 테스트: 우승자가 한 명일 때 makeFinalResult가 최종 결과 출력문을 제대로 반환한다.")
    void makeFinalResultOutputStatementWhenWinnerIsOne() {
        // given
        List<String> winnerList = new ArrayList<>(List.of("A"));

        // when
        String result = makeFinalWinnerOutputStatement(winnerList);

        // then
        assertThat(result).isEqualTo("최종 우승자 : A");
    }

    @Test
    @DisplayName("기능22 테스트: 우승자가 두 명일 때 최종 결과 출력문을 제대로 반환한다.")
    void makeFinalResultOutputStatementWhenWinnerIsTwo() {
        // given
        List<String> winnerList = new ArrayList<>(List.of("A", "B"));

        // when
        String result = makeFinalWinnerOutputStatement(winnerList);

        // then
        assertThat(result)
                .isEqualTo("최종 우승자 : A,B");
    }

    @Test
    @DisplayName("기능22 테스트: 우승자가 세 명일 때 최종 결과 출력문을 제대로 반환한다.")
    void makeFinalResultOutputStatementWhenWinnerIsThree() {
        // given
        List<String> winnerList = new ArrayList<>(List.of("A", "B", "C"));

        // when
        String result = makeFinalWinnerOutputStatement(winnerList);

        // then
        assertThat(result)
                .isEqualTo("최종 우승자 : A,B,C");
    }
}