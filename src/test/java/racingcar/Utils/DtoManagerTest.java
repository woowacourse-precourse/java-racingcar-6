package racingcar.Utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class DtoManagerTest {
    private static DtoManager dtoManager = new DtoManager();

    // 정상 newRacingCar
    @Test
    void newRacingCar_정상_테스트() {
        dtoManager = new DtoManager();
        dtoManager.newRacingCar("A");
        assertThat(dtoManager.getRacingCarInstanceCount()).isEqualTo(1);
    }

    @Test
    void newRacingCar_정상_테스트_2() {
        dtoManager = new DtoManager();
        dtoManager.newRacingCar("A");
        dtoManager.newRacingCar("B");
        assertThat(dtoManager.getRacingCarInstanceCount()).isEqualTo(2);
    }

    @Test
    void newRacingCar_정상_테스트_3() {
        dtoManager = new DtoManager();
        dtoManager.newRacingCar("A");
        dtoManager.newRacingCar("B");
        dtoManager.newRacingCar("C");
        assertThat(dtoManager.getRacingCarInstanceCount()).isEqualTo(3);
    }
}
