package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class RaceTest extends NsTest{
    private static final int MOVE_FORWARD = 4;
    private static final int INCLUDE_WINNER_OUTPUT = 5;
    @Test
    void 사용자_입력으로_자동차_생성() {
        assertSimpleTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi","woni");
        });
    }

    @Test
    void 공동_우승_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVE_FORWARD,MOVE_FORWARD
        );
    }

    @Test
    void 입력된_회수에_맞게_진행되는지_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "4");
                    int count = 0;
                    Pattern pattern = Pattern.compile("pobi");
                    Matcher matcher = pattern.matcher(output());
                    while(matcher.find()) {
                        count++;
                    }
                    assertThat(count).isEqualTo(INCLUDE_WINNER_OUTPUT);
                },
                MOVE_FORWARD
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
