package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FeatureTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    void input_정상_케이스(){
        //given
        String carNamesInput = "lee,juho,test";
        List<String> carNameList = Arrays.asList(carNamesInput.split(","));
        String attemptInput = "3";
        //when
        run(carNamesInput,attemptInput);

        List<Car> cars = Application.cars;
        int attempt = Application.attempt;
        //then
        assertThat(cars.size()).isEqualTo(3);
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            String carName = carNameList.get(i);
            assertThat(car.getName()).isEqualTo(carName);
        }
        assertThat(Integer.parseInt(attemptInput)).isEqualTo(attempt);
    }
    @Test
    void input_자동차_5글자_이상_입력_시_예외_발생(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("juho,leejuho,hello,test", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void input_자동차_알파벳_제외_문자_입력_시_예외_발생(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("juho,2juho,hello,test", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void input_자동차_중복된_이름_입력_시_예외_발생(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("juho,juho,hello,test", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void input_횟수_0회_입력_시_예외_발생(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("juho,lee,hello,test", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void input_횟수_문자_입력_시_예외_발생(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("juho,lee,hello,test", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
