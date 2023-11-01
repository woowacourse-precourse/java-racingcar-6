package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class AttemptExecutorTest {

    @Test
    public void execute_한번_실행된_후에_전진_문자열이_0또는1만큼_늘어났나() {
        HashMap<String, String> hs = new HashMap<>();
        hs.put("aa", "");
        hs.put("bb", "-");
        RaceDto raceDto = new RaceDto(hs, 1);
        AttemptExecutor attemptExecutor = new AttemptExecutor(raceDto);

        attemptExecutor.execute();

        assertThat(hs.get("aa").length()).isBetween(0, 1);
        assertThat(hs.get("bb").length()).isBetween(1, 2);
    }
}