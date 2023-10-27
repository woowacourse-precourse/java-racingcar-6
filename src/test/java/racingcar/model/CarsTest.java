package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {
    List<String> names = Arrays.asList("Car1", "Car2", "Car3");

    @Test
    void 문자열_이름이_들어있는_리스트를_받아_Car_리스트를_생성() {
        Cars cars = new Cars(names);
        assertNotNull(cars);
    }

    @Test
    void 문자열_이름_리스트를_받아_Car_리스트로_변환한다() {
        //메서드 사용을 위해 임의 생성
        Cars cars = new Cars(Arrays.asList("Car4", "Car5", "Car6"));

        List<Car> carList = cars.userInputToCars(names);

        assertNotNull(carList);
        assertEquals(3, carList.size());
        assertEquals("Car1", carList.get(0).getName());
        assertEquals("Car2", carList.get(1).getName());
        assertEquals("Car3", carList.get(2).getName());
    }

    @Test
    void 최종_승리자를_찾는다() {
        Cars cars = new Cars(names);

        // 각각 이동
        cars.getCars().get(0).moveForward(4);
        cars.getCars().get(0).moveForward(4);
        cars.getCars().get(1).moveForward(2);
        cars.getCars().get(1).moveForward(2);
        cars.getCars().get(2).moveForward(4);
        cars.getCars().get(2).moveForward(4);

        List<String> winners = cars.findWinners();
        assertEquals(2, winners.size());
        assertEquals("Car1", winners.get(0));
        assertEquals("Car3", winners.get(1));
    }

}


