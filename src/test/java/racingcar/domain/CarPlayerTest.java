package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.service.GameService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarPlayerTest {
    private final int id = 0;
    private final String name = "1번차";

    @Test
    void 이름가져오기_테스트(){
        CarPlayer carPlayer  = new CarPlayer(id, name);
        assertThat(carPlayer.getName()).isEqualTo("1번차");
    }
    @Test
    void 스코어_업데이트_테스트(){
        CarPlayer carPlayer  = new CarPlayer(id, name);
        carPlayer.setScore();
        assertThat(carPlayer.getScore()).isEqualTo(1);
    }
}
