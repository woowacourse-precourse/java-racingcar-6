package racingcar.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static racingcar.Service.InputValidation.*;


class ServiceTest {
    private RaceService raceService;
    private InputValidation inputValidation;
    private List<Car> carList;

    @BeforeEach
    void setRaceService() {
        raceService = new RaceService();
        inputValidation = new InputValidation();
        carList = new ArrayList<>();
        carList.add(new Car("jung", 5));
        carList.add(new Car("yuju", 4));
        carList.add(new Car("dong", 3));
    }

    @Test
    void 레이스_최종_단일_우승자_확인() {
        String result = raceService.winnerResult(carList);
        assertThat(result).isEqualTo("jung");
    }

    @Test
    void 레이스_최종_공동_우승자_확인() {
        carList.add(new Car("yeon", 5));
        String result = raceService.winnerResult(carList);
        assertThat(result).isEqualTo("jung, yeon");
    }

    @Test
    void 입력받은_자동차_이름_검증() {
        assertThat(inputValidation.SpellingCountValidation(Arrays.asList("jung", "yuju", "dong"))).isTrue();
        assertThat(inputValidation.SpellingCountValidation(Arrays.asList("jungyeon", "yuju", "dong"))).isFalse();
    }

    @Test
    void 예외_이름입력시_최대_이름_글자수_이상일때() {
        assertThatThrownBy(() -> inputValidation.checkCarNamesValidation("jungyeon,yuju,dong"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEED_ERROR_MESSAGE);
    }

    @Test
    void 예외_이름입력시_중복된_이름이_들어왔을때() {
        assertThatThrownBy(() -> inputValidation.checkCarNamesValidation("jung,yuju,jung"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NAME_ERROR_MESSAGE);
    }

    @Test
    void 예외_이름입력시_빈칸일때() {
        assertThatThrownBy(() -> inputValidation.checkCarNamesValidation(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_ERROR_MESSAGE);
    }

    @Test
    void 예외_이름입력시_쉼표만_들어왔을때() {
        assertThatThrownBy(() -> inputValidation.checkCarNamesValidation(","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DISTINGUISH_ERROR_MESSAGE);
    }

    @Test
    void 예외_이름입력시_쉼표로_구분할_수_없을때() {
        assertThatThrownBy(() -> inputValidation.checkCarNamesValidation("jung yuju dong"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DISTINGUISH_ERROR_MESSAGE);
    }

}