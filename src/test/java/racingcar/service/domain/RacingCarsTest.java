package racingcar.service.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi"})
    @DisplayName("[실패 테스트] 중복 이름의 자동차가 존재")
    void duplicateCarTest(String carNames) {
        // given
        List<String> carNamesList = Arrays.asList(carNames.split(","));
        // when, then
        Assertions.assertThatThrownBy(() -> new RacingCars(carNamesList, new WootecoEngine()))
                .hasMessage("중복된 이름이 존재합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"jun"})
    @DisplayName("[실패 테스트] 자동차가 최소 제한 2개를 미만")
    void lessThanMinTotalCount(String carName) {
        // given
        List<String> carNameList = Arrays.asList(carName);
        // when, then
        Assertions.assertThatThrownBy(() -> new RacingCars(carNameList, new WootecoEngine()))
                .hasMessage("자동차 개수 범위가 맞지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"jun,pobi,hey,!!!, QGG,QWE,*_*,pay,runne,guuc,shake"})
    @DisplayName("[실패 테스트] 자동차가 최대 제한 10개를 초과")
    void greaterThanMaxTotalCount(String carNames) {
        // given
        List<String> carNameList = Arrays.asList(carNames.split(","));
        // when, then
        Assertions.assertThatThrownBy(() -> new RacingCars(carNameList, new WootecoEngine()))
                .hasMessage("자동차 개수 범위가 맞지 않습니다.");
    }
}