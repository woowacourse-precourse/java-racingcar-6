package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("입력 뷰 테스트")
class IntputViewTest {

    private final InputView inputView = new InputView();

    @Test
    @DisplayName("출전할 레이싱 이름을 입력받아 RacingCars 로 반환한다. ")
    void inputNameOfRacingCars() {
        String userInput = "Car1,Car2,Car3";
        RacingCars racingCars = inputView.inputNameOfRacingCars(userInput);

        assertThat(racingCars.getNames()).contains("Car2", "Car1", "Car3");
        assertThat(racingCars.getNames()).containsExactly("Car1", "Car2", "Car3");
    }
}