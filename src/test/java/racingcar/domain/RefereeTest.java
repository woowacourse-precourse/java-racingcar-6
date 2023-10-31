package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RefereeTest {

    @Test
    public void 입력한_실행_횟수가_판단_기준보다_크다() {
        Referee referee = new Referee();

        assertThat(referee.isGreaterThanEqual(9)).isTrue();
        assertThat(referee.isGreaterThanEqual(8)).isTrue();

        assertThat(referee.isGreaterThanEqual(2)).isFalse();
    }

    @Test
    public void 우승자를_판별한다() {
        List<Car> carList = Arrays.asList(
                mock(Car.class),
                mock(Car.class),
                mock(Car.class)
        );

        when(carList.get(0).getName()).thenReturn("Car1");
        when(carList.get(0).getLocation()).thenReturn(3);

        when(carList.get(1).getName()).thenReturn("Car2");
        when(carList.get(1).getLocation()).thenReturn(3);

        when(carList.get(2).getName()).thenReturn("Car3");
        when(carList.get(2).getLocation()).thenReturn(2);

        Referee referee = mock(Referee.class);
        when(referee.judgeWinner(carList)).thenCallRealMethod();

        List<String> result = referee.judgeWinner(carList);
        List<String> expected = List.of("Car1", "Car2");

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
