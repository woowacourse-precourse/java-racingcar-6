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

    @Test
    void 위치_안내_문구를_작성한다() {
        List<Car> carList = Arrays.asList(
                mock(Car.class),
                mock(Car.class),
                mock(Car.class)
        );

        when(carList.get(0).getName()).thenReturn("Car1");
        when(carList.get(0).getLocation()).thenReturn(3);

        when(carList.get(1).getName()).thenReturn("Car2");
        when(carList.get(1).getLocation()).thenReturn(5);

        when(carList.get(2).getName()).thenReturn("Car3");
        when(carList.get(2).getLocation()).thenReturn(2);

        Announcer announcer = mock(Announcer.class);
        when(announcer.generateLocationAnnouncement(carList)).thenCallRealMethod();

        String result = announcer.generateLocationAnnouncement(carList);
        String expected = "Car1 : ---\nCar2 : -----\nCar3 : --\n";

        assertThat(result).isEqualTo(expected);
    }
}
