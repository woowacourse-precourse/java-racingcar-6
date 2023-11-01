package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.car.Car;
import racingcar.car.CarCollection;
import racingcar.name.Name;

import java.util.stream.Collectors;
import java.util.List;

class CarCollectionTest extends NsTest {
    @Test
    void 자동차_담기_성공() {
        assertThatCode(() -> {
            CarCollection givenCarCollect = CarCollection.initCarCollect();
            givenCarCollect.add(Car.fromString("mooso"));
            givenCarCollect.add(Car.fromString("woni"));
            givenCarCollect.add(Car.fromString("pobi"));
            givenCarCollect.add(Car.fromString("jun"));
        }).doesNotThrowAnyException();
    }

    @Test
    void 자동차_담기_실패() {
        assertThatThrownBy(() -> {
            CarCollection givenCarCollect = CarCollection.initCarCollect();
            givenCarCollect.add(Car.fromString("moosoo"));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


    @Test
    void 자동차_일괄_전진_후_출력() {
        assertRandomNumberInRangeTest(() -> {
            CarCollection givenCarCollect = CarCollection.initCarCollect();
            givenCarCollect.add(Car.fromString("mooso"));
            givenCarCollect.add(Car.fromString("woni"));
            givenCarCollect.add(Car.fromString("pobi"));
            givenCarCollect.add(Car.fromString("jun"));
            givenCarCollect.batchMoveCarOnRandomCondition();
            givenCarCollect.batchDisplayCarStatus();
            assertThat(output()).contains("mooso : -", "woni : ", "pobi : -", "jun : ");
        }, 4, 3, 4, 3);
    }

    @Test
    void 자동차_위치가_최대값인_차_이름_반환() {
        assertRandomNumberInRangeTest(() -> {
            CarCollection givenCarCollect = CarCollection.initCarCollect();
            givenCarCollect.add(Car.fromString("mooso"));
            givenCarCollect.add(Car.fromString("woni"));
            givenCarCollect.add(Car.fromString("pobi"));
            givenCarCollect.add(Car.fromString("jun"));
            givenCarCollect.batchMoveCarOnRandomCondition();
            String carNames = givenCarCollect.getMaxLocationCarName();
            String expectedCarNames = "woni, jun";
            assertThat(carNames).isEqualTo(expectedCarNames);
        }, 3, 4, 3, 4);
    }

    @Test
    void 자동차_이름_리스트_반환() {
        List<String> expectCarNameStringList = List.of("mooso", "woni", "pobi", "jun");
        CarCollection givenCarCollect = CarCollection.initCarCollect();

        expectCarNameStringList.stream()
                .forEach(carName -> givenCarCollect.add(Car.fromString(carName)));
        List<Name> carNameList = givenCarCollect.getCarNameList();
        List<String> givenCarNameStringList = carNameList.stream()
                .map(Name::getName).collect(Collectors.toList());
        assertThat(givenCarNameStringList).isEqualTo(expectCarNameStringList);
    }

    @Test
    void 자동차_개수_반환() {
        List<String> givenCarNameStringList = List.of("mooso", "woni", "pobi", "jun");
        CarCollection givenCarCollect = CarCollection.initCarCollect();
        givenCarNameStringList.stream()
                .forEach(carName -> givenCarCollect.add(Car.fromString(carName)));
        int expectedSize = 4;
        int carCollectionSize = givenCarCollect.size();
        assertThat(carCollectionSize).isEqualTo(expectedSize);
    }

    @Override
    protected void runMain() {

    }

}
