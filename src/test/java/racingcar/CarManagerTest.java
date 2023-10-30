package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarManagerTest {
    CarManager carManager = new CarManager();

    @Test
    void 입력받은_이름_목록의_레이싱카_목록을_생성한다() {
        // given
        String[] names = {"성겸", "성민", "성우"};

        // when
        carManager.createCars(names);

        // then
        Assertions.assertThat(carManager.getCars().getCars().size()).isEqualTo(3);
    }
}