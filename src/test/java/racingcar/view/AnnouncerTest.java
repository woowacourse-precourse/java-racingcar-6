package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.History;

class AnnouncerTest extends NsTest {
    private final Announcer announcer = new Announcer();

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
