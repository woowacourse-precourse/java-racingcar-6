package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Turn;

public class RacingCarTest {


    @Test
    void 자동차_생성_기능() {
        Car car = new Car("john");
        assertThat("john").isEqualTo(car.getName());
        assertThat(0).isEqualTo(car.getPosition());
    }

    @Test
    void 자동차_이름_길이_5자_제한_기능() {
        List<String> fiveLengthOverName = List.of("abcdef", "aifhiawkgha", "awhdfaighkwuhgakhgka", "asdfakhfkah",
                "adwlafla");
        for (String name : fiveLengthOverName) {
            assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    @Test
    void 자동차_정보_저장() {
        List<String> carNames = List.of("jamy", "risa", "jun");
        Cars cars = new Cars(carNames);
    }

    @Test
    void 자동차_정보_저장_실패() {
        List<String> carNames = List.of("jamiese", "risa", "jun");
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_시도_횟수_입력() {
        Turn turn = new Turn("1");
        assertThat(1).isEqualTo(turn.getCount());
    }

    @Test
    void 이동_시도_횟수_입력_실패_문자열_처리() {
        assertThatThrownBy(() -> new Turn("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_시도_횟수_입력_실패_공백_처리() {
        List<String> blanks = List.of(" ", "");
        for (String blank : blanks) {
            assertThatThrownBy(() -> new Turn(blank))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
