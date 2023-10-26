package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import racingcar.Cars;
import racingcar.InputView;
import racingcar.OutputView;

public class StringTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = InputView.splitCarName(input);

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        String[] result = InputView.splitCarName(input);

        assertThat(result).contains("1");
    }

    @Test
    void 우승자_이름_반환() {
        ArrayList<String> name = new ArrayList<>();
        name.add("james");
        name.add("kim");
        OutputView ouputview = new OutputView();
        ouputview.printFinalWinner(name);
    }

    @Test
    void 게임_결과_반환() {
        Cars james = new Cars("james");
        Cars peter = new Cars("peter");
        Cars kim = new Cars("kim");

        ArrayList<Cars> players = new ArrayList<>();
        players.add(james);
        players.add(peter);
        players.add(kim);
        OutputView ouputview = new OutputView();

        ouputview.printSingleGame(players);
    }

    @Test
    @Disabled
    void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

}
