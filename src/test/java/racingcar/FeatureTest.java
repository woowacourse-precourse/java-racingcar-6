package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class FeatureTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    // 테스트 후 필드 초기화
    @AfterEach
    public void afterEach() {
        Application.cars = new ArrayList<>();
        Application.attempt = 0;
    }

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
    @Test
    void race_랜덤값_3_이하_시_거리_유지(){
        //given
        String carNamesInput = "lee,juho,test";
        String attemptInput = "1";

        //when
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNamesInput,attemptInput);
                },
                0,1,2,3
        );
        List<Car> cars = Application.cars;

        //then
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }
    @Test
    void race_랜덤값_4_이상_시_거리_증가(){
        //given
        String carNamesInput = "lee,juho,test";
        String attemptInput = "2";

        //when
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNamesInput,attemptInput);
                },
                4,5,6,7,8,9
        );
        List<Car> cars = Application.cars;

        //then
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            assertThat(car.getDistance()).isEqualTo(2);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
