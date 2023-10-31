package racingcar.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    @ParameterizedTest
    @CsvSource(value = {
              "jungyeon,yuju,dong:  최대 이름 글자수를 초과하였습니다."
            , "jung,yuju,jung    :  중복된 이름을 입력하셨습니다."
            , "''                :  입력된 이름이 없습니다."
            , ",                 :  이름을 쉼표(,)로 구분할 수 없습니다."
            , "jung yuju dong    :  이름을 쉼표(,)로 구분할 수 없습니다."}
            , delimiter = ':')
    void 입력값_검증(String input, String message){
        assertThatThrownBy(() -> inputValidation.checkCarNamesValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
    }

}