package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.generic.RacerProgress;

public class StringTest {

    @Test
    void 정말로문자열붙이기보다스트링빌더가빠를까() {
        List<RacerProgress> progresses = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            progresses.add(
                    new RacerProgress(
                            "유니코드" + String.valueOf(Randoms.pickNumberInRange(1, 9)) + Randoms.pickNumberInRange(1, 9)
                                    + Randoms.pickNumberInRange(
                                    1, 9),
                            Randoms.pickNumberInRange(1, 9)));
        }

        List<String> result1list = new ArrayList<>();
        long beforeTime = System.currentTimeMillis();

        for (RacerProgress progress : progresses) {
            result1list.add(
                    progress.name() + " : " + "-".repeat(progress.mileage()));
        }

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("1번 시간차이(m) : " + secDiffTime);

        System.out.println("================================================");

        List<String> result2list = new ArrayList<>();

        long beforeTime2 = System.currentTimeMillis();

        for (RacerProgress progress : progresses) {
            result2list.add(
                    new StringBuffer()
                            .append(progress.name())
                            .append(" : ")
                            .append("-".repeat(progress.mileage()))
                            .toString());
        }

        long afterTime2 = System.currentTimeMillis();
        long secDiffTime2 = (afterTime2 - beforeTime2);
        System.out.println("2번 시간차이(m) : " + secDiffTime2);
    }

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void substring_메서드로_특정_구간_값을_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_메서드로_특정_위치의_문자_찾기() {
        String input = "abc";
        char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

}
