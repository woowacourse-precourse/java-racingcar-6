package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

class GameTest extends NsTest {
    @Test
    void 이름_공백_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_5자_제한_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcdef", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_중복_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("moi,rei,moi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_미입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_0_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("moi,rei", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_한영_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("moi,rei", "ab가"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 무작위_값_입력_테스트() {
        Random random = new Random();
        List<Integer> randomAC = random.ints(33, 123)
                .limit(25)
                .boxed().toList();
        List<String> randomCarNames = Arrays.asList("","","","","");
        String randomNumber = "" + random.nextInt(1, 1001);

        for (int i = 0; i < randomAC.size(); i++) {
            int listIndex = i / 5;
            int ascii = randomAC.get(i);
            String carName = randomCarNames.get(listIndex);
            randomCarNames.set(listIndex, carName + (char) ascii);
        }

        String randomCarNamesString = String.join(",", randomCarNames);

        System.out.println("자동차 이름: " + randomCarNamesString);
        System.out.println("횟수: " + randomNumber);

        assertSimpleTest(() -> run(randomCarNamesString, randomNumber));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}