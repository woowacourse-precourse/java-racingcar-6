package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class GameTest extends NsTest {
    @Test
    void 자동차_객체_생성_테스트(){
        Racingcar car = new Racingcar("TEST");

        for (int i = 0; i < 10; i++){
            car.upMoveDistance();
        }

        assertThat(car.getName()).isEqualTo("TEST");
        assertThat(car.getMoveDistance()).isEqualTo(10);
    }

    @Test
    void 정수_문자열_무결성_검사_테스트(){

    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
