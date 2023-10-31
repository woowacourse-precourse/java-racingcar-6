package racingcar.model;

import model.Car;
import model.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : racingcar.model
 * fileName       : CarsTest
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-30        qkrtn_ulqpbq2       최초 생성
 */
public class CarsTest {

    @Test
    @DisplayName("자동차 리스트 정상 생성")
    void makeCars(){
        String carNames = "자동차1, 자동차2, 자동차3";
        Cars cars = new Cars(carNames);
        assertNotNull(cars);
        assertEquals(3, cars.getCars().size());
        assertTrue(cars.getCars().stream()
                .allMatch(car -> car.getName().equals("자동차1") || car.getName().equals("자동차2") || car.getName().equals("자동차3")));
    }

    @Test
    @DisplayName("자동차 이름이 중복된 경우 예외 발생")
    void duplicateCheck(){
        String carNames = "자동차1, 자동차1, 자동차2";
        String errorMessage = "[ERROR] 중복된 이름이 존재합니다.";

        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);

    }
}
