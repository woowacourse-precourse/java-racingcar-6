package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrafficControllerTest {
    @Test
    void 랜덤숫자_생성() {
        TrafficController trafficController = new TrafficController();

        //randomNumber이 0~9의 숫자인지 테스트
        assertThat(trafficController.getRandomNumber())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }

    @Test
    void 전진_또는_정지() {
        TrafficController trafficController = new TrafficController();

        //randomNumber이 4이상이면 true, 아니면 false
        if (trafficController.getRandomNumber() >= 4){
            assertThat(trafficController.isMoveForward()).isTrue();
        } else {
            assertThat(trafficController.isMoveForward()).isFalse();
        }
    }

}