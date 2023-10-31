package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.History;

class AnnouncerTest {
    private final Announcer announcer = new Announcer();

    @Nested
    class 자동차_위치_출력_테스트 extends NsTest {
        @Test
        void 자동차들의_위치를_정상적으로_출력() {
            assertSimpleTest(() -> {
                runMain();
                assertThat(output()).contains("pobi : -", "woni : --");
            });
        }

        @Override
        protected void runMain() {
            Map<String, Integer> nameAndPosition = Map.of("pobi", 1, "woni", 2);
            History history = new History(nameAndPosition);
            announcer.announceRaceHistories(List.of(history));
        }

    }

    @Nested
    class 자동차_우승자_출력_테스트 extends NsTest {

        @Test
        void 우승자_여러명를_정상적으로_출력() {
            assertSimpleTest(() -> {
                runMain();
                assertThat(output()).contains("최종 우승자 : pobi, woni");
            });
        }

        @Override
        protected void runMain() {
            announcer.announceWinner(List.of("pobi", "woni"));
        }
    }
}
