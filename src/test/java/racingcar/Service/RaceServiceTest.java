package racingcar.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


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
        carList.add(new Car("정연", 5));
        carList.add(new Car("유주", 4));
        carList.add(new Car("동현", 3));
        String result = raceService.winnerResult(carList);
        assertThat(result).isEqualTo("정연");
    }

    @Test
    void 레이스_최종_공동_우승자_확인() {
        carList.add(new Car("정연", 5));
        carList.add(new Car("유주", 5));
        carList.add(new Car("동현", 3));
        String result = raceService.winnerResult(carList);
        assertThat(result).isEqualTo("정연, 유주");
    }

    @Test
    void 입력받은_자동차_이름_검증() {
        assertThat(raceService.isSplitValue("정연,유주,동현")).isTrue();
        assertThat(raceService.CountOfNameSpelling("정연,유주,동현")).isTrue();
        assertThat(raceService.CountOfNameSpelling("정연정연정연,유주,동현")).isFalse();
    }

    @Test
    void 이름입력시_최대_이름_글자수_이상일때() {
        assertThatThrownBy(() -> raceService.checkCarNamesValidation("빅정정정정정연,유주,동현"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대 이름 글자수를 초과하였습니다.");
    }

}