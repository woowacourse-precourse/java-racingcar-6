package racingcar.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class CarManagerTest {

    CarManager carManager;
    ExpectedNumberMaker expectedNumberMaker;

    @BeforeEach
    public void create() {
        expectedNumberMaker = new ExpectedNumberMaker();
        carManager = new CarManager(expectedNumberMaker);
    }

    @Test
    @DisplayName("생성자로 만든 자동차들의 이름과 match 후 출력된 자동차의 이름이 동일하다.")
    void generateCarList_EqualName() {
        // given
        List<String> nameList = Arrays.asList("pobi", "wooni", "kong");
        List<Integer> expectedNumbers = Arrays.asList(0, 0, 0); // 각 자동차에 들어갈 숫자들

        // when
        carManager.generateCarList(nameList);

        // then
        List<Car> matchResult = runMatch(expectedNumbers);
        assertThat(convertToName(matchResult)).isEqualTo(nameList);
    }

    @Test
    @DisplayName("생성자로 넣어준 자동차의 이름 갯수와 match 후 출력된 자동차의 갯수가 일치한다.")
    void generateCarList_EqualSize() {
        // given
        List<String> nameList = Arrays.asList("pobi", "wooni", "kong");
        List<Integer> expectedNumbers = Arrays.asList(0, 0, 0); // 각 자동차에 들어갈 숫자들

        // when
        carManager.generateCarList(nameList);

        // then
        int size = runMatch(expectedNumbers).size();
        assertThat(nameList.size()).isEqualTo(size);
    }



}