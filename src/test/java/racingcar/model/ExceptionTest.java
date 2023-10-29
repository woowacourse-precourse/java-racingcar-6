package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;
import racingcar.utils.Parser;

public class ExceptionTest extends NsTest {
    // 모델 생성자 테스트
    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "aca", "12345"})
    void 자동차_이름_정상_테스트(String carName) {
        assertThatCode(() -> new Car(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "more_than_five", "abcdef", "123456", "아에이오우으"})
    void 자동차_이름_1자_이상_5자_이하가_아닌_경우(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("이름은 1자 이상 5자 이하");
    }

    @Test
    void 자동차_이름_중복이_있는_경우() {
        assertThatThrownBy(() -> {
            List<Car> carList = new ArrayList<>();
            String carNames = "succ,ess,ful,ess";
            Parser.parseWithComma(carNames)
                    .forEach(name -> carList.add(new Car(name)));
            new Cars(carList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 있습니다.");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
