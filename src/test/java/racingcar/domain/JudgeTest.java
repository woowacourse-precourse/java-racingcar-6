package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgeTest {
    private Judge judge;

    @BeforeEach
    void setUp() {
        judge = new Judge();
    }

    @Test
    @DisplayName("차량 등록 기능 테스트")
    void setCarsTest1(){
        List<Car> expectedCars = new ArrayList<>();
        expectedCars.add(new Car("pobi"));
        expectedCars.add(new Car("woni"));
        expectedCars.add(new Car("jun"));

        String[] carNamesWithStringArray = {"pobi", "woni", "jun"};
        judge.setCars(carNamesWithStringArray);
        List<Car> actualCars = judge.getCars();

        Assertions.assertThat(actualCars).isEqualTo(expectedCars);
    }
}