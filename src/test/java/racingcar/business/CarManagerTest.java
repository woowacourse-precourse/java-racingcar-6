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

    @BeforeEach
    public void create() {
        NumberMaker numberMaker = new ExpectedNumberMaker();
        carManager = new CarManager(numberMaker);
    }

    @Test
    @DisplayName("생성자로 만든 자동차들의 이름과 match 후 출력된 자동차의 이름이 동일하다.")
    void generateCarList_EqualName() {
        // given
        List<String> nameList = Arrays.asList("pobi", "wooni", "kong");

        // when
        carManager.generateCarList(nameList);

        // then
        Stream<String> carNames = carManager.runMatch().stream().map(Car::getName);
        assertThat(carNames).isEqualTo(nameList);
    }

    @Test
    @DisplayName("생성자로 넣어준 자동차의 이름 갯수와 match 후 출력된 자동차의 갯수가 일치한다.")
    void generateCarList_EqualSize() {
        // given
        List<String> nameList = Arrays.asList("pobi", "wooni", "kong");

        // when
        carManager.generateCarList(nameList);

        // then
        int size = carManager.runMatch().size();
        assertThat(nameList.size()).isEqualTo(size);
    }



}