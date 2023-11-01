package racingcar.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    @DisplayName("입력된 숫자와 동일하게 자동차들 전진. - 숫자가 모두 기준점보다 작은 경우")
    void runMatch_underStandard() {
        // given
        setNames(Arrays.asList("pobi", "wooni", "kong")); // 자동차 이름 설정

        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3); // 각 자동차에 들어갈 숫자들
        List<Integer> expectedDistance = Arrays.asList(0, 0, 0); // 예상 결과

        // when
        List<Car> matchResult = runMatch(expectedNumbers);

        // then
        List<Integer> distanceList = convertToDistance(matchResult);
        assertThat(distanceList).isEqualTo(expectedDistance);
    }

    @Test
    @DisplayName("입력된 숫자와 동일하게 자동차들 전진. - 숫자가 모두 기준점보다 클 경우")
    void runMatch_upStandard() {
        // given
        setNames(Arrays.asList("pobi", "wooni", "kong")); // 자동차 이름 설정

        List<Integer> expectedNumbers = Arrays.asList(5, 6, 7); // 각 자동차에 들어갈 숫자들
        List<Integer> expectedDistance = Arrays.asList(1, 1, 1); // 예상 결과

        // when
        List<Car> matchResult = runMatch(expectedNumbers);

        // then
        List<Integer> distanceList = convertToDistance(matchResult);
        assertThat(distanceList).isEqualTo(expectedDistance);
    }

    @Test
    @DisplayName("입력된 숫자와 동일하게 자동차들 전진. - match 2회")
    void runMatch_2cycle() {
        // given
        setNames(Arrays.asList("pobi", "wooni", "kong")); // 자동차 이름 설정


        List<Integer> expectedNumbers = Arrays.asList(5, 6, 7, 5, 6, 7); // 각 자동차에 순서대로 주어질 숫자들
        List<Integer> expectedDistance = Arrays.asList(2, 2, 2); // 예상 결과

        // when
        runMatch(expectedNumbers); // 1회
        List<Car> matchResult = runMatch(expectedNumbers); //2회

        // then
        List<Integer> distanceList = convertToDistance(matchResult);
        assertThat(distanceList).isEqualTo(expectedDistance);
    }

    private void setNames(List<String> nameList) {
        carManager.generateCarList(nameList);
    }

    private List<Car> runMatch(List<Integer> expectedNumbers) {
        expectedNumberMaker.setExpectedNumbers(expectedNumbers);
        return carManager.runMatch();
    }

    private List<String> convertToName(List<Car> carList) {
        return carList.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Integer> convertToDistance(List<Car> carList) {
        return carList.stream()
                .map(Car::getDistance)
                .collect(Collectors.toList());
    }

}