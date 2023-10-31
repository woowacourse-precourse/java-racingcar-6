package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.verification.InputVerification;

class GameManageControllerTest {

    @Test
    @DisplayName("사용자로부터 자동차 이름을 입력받는 기능 및 검증 테스트")
    void 자동차_이름_입력_검증() {
        String carName = "pobi,lisa";
        InputVerification.checkAll(carName);
    }

    @Test
    @DisplayName("사용자로부터 각 자동차의 이동횟수를 입력받는 기능 및 검증 테스트")
    void 이동_횟수_입력_검증() {
        String repeatCount = "1";
        InputVerification.checkInputType(repeatCount);
    }
}