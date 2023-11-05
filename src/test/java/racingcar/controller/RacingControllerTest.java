package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingService;

class RacingControllerTest {
    private RacingController racingController;
    private RacingService racingService;

    @BeforeEach
    public void beforeEach() {
        racingService = new RacingService();
        racingController = new RacingController(racingService);
    }

    @Test
    @DisplayName("기능9 테스트: 차량이 한대 일 때 userInputToCarArray가 carArray를 정확하게 반환한다.")
    void userInputToCarArrayReturnCarArrayWhenCarIsOne() {
        // given
        String userInput = "A";

        // when
        String[] carArray = racingController.userInputToCarArray(userInput);

        // then
        Assertions.assertThat(carArray).isEqualTo(new String[]{"A"});
    }

    @Test
    @DisplayName("기능9 테스트: 차량이 두대 일 때 userInputToCarArray가 carArray를 정확하게 반환한다.")
    void userInputToCarArrayReturnCarArrayWhenCarIsTwo() {
        // given
        String userInput = "A,B";

        // when
        String[] carArray = racingController.userInputToCarArray(userInput);

        // then
        Assertions.assertThat(carArray).isEqualTo(new String[]{"A","B"});
    }
}