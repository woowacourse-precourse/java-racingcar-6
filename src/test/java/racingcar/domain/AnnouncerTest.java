package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AnnouncerTest {

    @Test
    void 우승자_안내_문구를_작성한다() {
        List<String> winners = Arrays.asList("우아한", "우테코", "나아연");

        Announcer announcer = mock(Announcer.class);
        when(announcer.generateWinnerAnnouncement(winners)).thenCallRealMethod();

        String result = announcer.generateWinnerAnnouncement(winners);
        String expected = "우아한, 우테코, 나아연";

        assertThat(result).isEqualTo(expected);
    }
}
