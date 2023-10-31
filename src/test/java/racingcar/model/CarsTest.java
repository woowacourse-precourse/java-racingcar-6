package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("[Cars] 자동차 이름을 구분한 List를 저장")
    void saveCarNameListTest() {
        // Given
        Cars cars = new Cars();
        List<String> carNameList = List.of("pobi", "woni", "jun");

        // When
        cars.saveCarNameList(carNameList);

        // Then
        assertThat(cars.carList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("[Cars] 사용자가 자동차 이름을 입력했을 때, 쉼표로 기준으로 구분")
    void splitCarNamesTest() {
        // Given
        Cars cars = new Cars();
        String carNames = "pobi,woni,jun";

        // When
        List<String> carNameList = cars.splitCarNames(carNames);

        // Then
        assertThat(carNameList).contains("pobi", "woni", "jun");
    }
}
