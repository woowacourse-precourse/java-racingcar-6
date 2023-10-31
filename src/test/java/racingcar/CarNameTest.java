package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.CarNameValidationService;
import racingcar.service.GameService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarNameTest {

    @DisplayName("자동차 이름 입력받은 값 유효성 체크 확인")
    @Test
    void CarNameValidationCheck() {
        String[] carNameArray = {"hi", " 가, ", "가,가", "가,,가", "가,다,", "가나다라마바, 아자", "간ㄴ, 아자", ","};


        CarNameValidationService carNameValidationService = new CarNameValidationService();

        for (String carNames : carNameArray) {
            assertThrows(IllegalArgumentException.class, () -> {
                carNameValidationService.carNameValidation(carNames);
            });
        }
    }

    @DisplayName("자동차 이름 입력받은 값이 List<Car>에 정상적으로 들어가는 지 확인")
    @Test
    void stringToCarListTest() {
        String[] carNameArray = {"kitty", "mango", "pizza"};
        String testString = "";

        for (String name : carNameArray) {
            testString = testString + name + ",";
        }

        GameService gameService = new GameService();
        List<Car> carList = gameService.setCarList(testString);

        for (int i = 0; i < carNameArray.length; i++) {
            assertEquals(carList.get(i).getName(), carNameArray[i]);
        }

    }
}
