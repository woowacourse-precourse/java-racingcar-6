package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.Parser;
import racingcar.view.OutputView;

public class myTest extends NsTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "aca", "312"})
    void 올바른_자동차_이름_생성_테스트(String carName) {
        assertThatCode(() -> new Car(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "more_than_five", "abcde", "11111"})
    void 자동차_이름이_1자_이상_5자_이하가_아닌_경우(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("이름은 1자 이상 5자 이하");
    }

    @Test
    void 중복된_자동차_이름이_있는_경우() {
        assertThatThrownBy(() -> {
            List<Car> carList = new ArrayList<>();
            String carNames = "succ,ess,ful,ess";
            Parser.parseWithComma(carNames)
                    .forEach(name -> carList.add(new Car(name)));
            new Cars(carList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 있습니다.");
    }



    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
