package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {
    @Test
    @DisplayName("경주 생성 성공")
    public void create() {
        // given
        String names = "car,race,win";
        String count = "5";

        // when
        Race race = new Race(names, count);

        // then
        assertThat(race).isNotNull();
        assertThat(race.getMoveCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("입력받은 이동 횟수가 1 미만일 경우, 경주 생성 실패")
    public void createRangeFail() throws Exception {
        // given
        String name = "car,race,win";
        String count = "0";

        // when
        // then
        assertThatThrownBy(() -> new Race(name, count))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 이동 횟수가 숫자가 아닐 경우, 경주 생성 실패")
    public void createNumberFail() throws Exception {
        // given
        String names = "car,race,win";
        String count = "$$";

        // when
        // then
        assertThatThrownBy(() -> new Race(names, count))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경주 결과, 최대 이동 횟수 구하기")
    public void getMaxCount() {
        // given
        String name = "car";
        String count = "5";
        Race race = new Race(name, count);

        // when
        Car car = race.getCars().get(0);
        car.move(5);
        car.move(6);

        // then
        assertThat(race.getMaxCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("최종 우승자 1명인 경우")
    public void getWinner() {
        // given
        String name = "car";
        String count = "5";
        Race race = new Race(name, count);

        // when
        Car car = race.getCars().get(0);
        car.move(5);

        // then
        assertThat(race.getWinnerNames().size()).isEqualTo(1);
        assertThat(race.getWinnerNames()).contains(name);
    }

    @Test
    @DisplayName("최종 우승자 여러 명인 경우")
    public void getWinners() {
        // given
        String name = "car,race,win";
        String count = "5";
        Race race = new Race(name, count);

        // when
        List<Car> cars = race.getCars();
        cars.get(0).move(5);
        cars.get(2).move(6);

        // then
        assertThat(race.getWinnerNames().size()).isEqualTo(2);
        assertThat(race.getWinnerNames()).contains("car");
        assertThat(race.getWinnerNames()).contains("win");
    }
}