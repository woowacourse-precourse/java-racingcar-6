package racingcar.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Service.RaceService.EXCEED_ERROR_MESSAGE;


class RaceServiceTest {
    private RaceService raceService;
    private List<Car> carList;

    @BeforeEach
    void setRaceService() {
        raceService = new RaceService();
        carList = new ArrayList<>();
    }

    @Test
    void 레이스_최종_단일_우승자_확인() {
        carList.add(new Car("jung", 5));
        carList.add(new Car("yuju", 4));
        carList.add(new Car("dong", 3));
        String result = raceService.winnerResult(carList);
        assertThat(result).isEqualTo("jung");
    }

    @Test
    void 레이스_최종_공동_우승자_확인() {
        carList.add(new Car("jung", 5));
        carList.add(new Car("yuju", 5));
        carList.add(new Car("dong", 3));
        String result = raceService.winnerResult(carList);
        assertThat(result).isEqualTo("jung, yuju");
    }

    @Test
    void 입력받은_자동차_이름_검증() {
        assertThat(raceService.isSplitValue("jung,yuju,dong")).isTrue();
        assertThat(raceService.CountOfNameSpelling("jung,yuju,dong")).isTrue();
        assertThat(raceService.CountOfNameSpelling("jungyeon,yuju,dong")).isFalse();
    }

    @Test
    void 이름입력시_최대_이름_글자수_이상일때() {
        assertThatThrownBy(() -> raceService.checkCarNamesValidation("jungyeon,yuju,dong"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEED_ERROR_MESSAGE);
    }

}