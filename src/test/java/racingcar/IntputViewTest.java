package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("입력 뷰 테스트")
class IntputViewTest {

    private final InputView inputView = new InputView();
    private final List<Car> expectedCars = List.of(new Car("Car1"), new Car("Car2"), new Car("Car3"));

    @Test
    @DisplayName("출전할 레이싱 이름을 입력받아 RacingCars 로 반환한다. ")
    void inputNameOfRacingCars() {
        String userInput = "Car1,Car2,Car3";
        RacingCars racingCars = inputView.inputNameOfRacingCars(userInput);
        List<Car> actualCars = racingCars.getCars();

        Assertions.assertThat(expectedCars.size()).isEqualTo(actualCars.size());
        for (int i = 0; i < expectedCars.size(); i++) {
            assertThat(expectedCars.get(i).isSame(actualCars.get(i))).isTrue();
        }
    }
}