package racingcar;

import model.CarName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    @DisplayName("이름 생성 테스트")
    void 자동차_이름_생성(){
        CarName name = new CarName("mycar");
        Assertions.assertThat(name).isNotNull();
    }
}
