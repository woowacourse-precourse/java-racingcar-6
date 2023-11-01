package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    void 리스트_요소가_중복되면_IllegalArgumentException_에러를_던진다() {
        List<String> carNames = new ArrayList<>();

        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("pobi");

        assertThrows(IllegalArgumentException.class, () -> {
            new Cars(carNames);
        });
    }

    @Test
    void 리스트_요소가_중복되면_메소드명_checkDuplicateCarName_에서_에러를_던진다() {
        List<String> carNames = new ArrayList<>();

        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("pobi");

        String methodName = "checkDuplicateCarName";

        try{
            new Cars(carNames);
        }catch (IllegalArgumentException e){
            String throwsFromMethod = e.getStackTrace()[0].getMethodName();
            assertEquals(throwsFromMethod, methodName);
        }
    }
    @Test
    void 경주_우승_자동차_position_테스트() {
        List<String> carNames = new ArrayList<>();
        carNames.add("pobi");
        carNames.add("wooni");
        carNames.add("hook");

        Cars cars = new Cars(carNames);

        int condition = Car.FORWARD_CONDITION_NUMBER;
        cars.getCars().get(0).forwardOrStay(condition);
        cars.getCars().get(1).forwardOrStay(condition -1);
        cars.getCars().get(2).forwardOrStay(condition - 2);

        int maxPostion = cars.getMaxPosition();

        assertEquals(1, maxPostion);
    }

    @Test
    void 경주_우승자_테스트() {
        List<String> carNames = new ArrayList<>();
        carNames.add("pobi");
        carNames.add("wooni");
        carNames.add("hook");

        Cars cars = new Cars(carNames);

        int condition = Car.FORWARD_CONDITION_NUMBER;
        cars.getCars().get(0).forwardOrStay(condition);
        cars.getCars().get(0).forwardOrStay(condition -1);
        cars.getCars().get(0).forwardOrStay(condition - 2);

        Winners winners = cars.getWinners();

        assertEquals("pobi", winners.getWinnersName().get(0));
    }

}