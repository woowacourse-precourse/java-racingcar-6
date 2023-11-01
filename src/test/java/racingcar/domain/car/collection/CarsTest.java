package racingcar.domain.car.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.wrapper.Name;

import java.util.List;

class CarsTest {

    @Test
    void moveAll_후_toString_정상_작동_테스트() {
        List<Name> names = List.of(new Name("test1"), new Name("test2"));
        Cars cars = new Cars(names);
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(cars::moveAll, 4);
        Assertions.assertEquals(cars.toString(), "test1 : -\ntest2 : -");
    }

    @Test
    void getWinnerNames_정상_작동_테스트() {
        List<Name> nameList = List.of(new Name("test1"), new Name("test2"));
        Names names = new Names(nameList);
        Cars cars = new Cars(nameList);
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(cars::moveAll, 4);
        Assertions.assertEquals(cars.getWinnerNames().toString(), names.toString());
    }
}
