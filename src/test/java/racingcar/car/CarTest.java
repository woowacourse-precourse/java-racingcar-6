package racingcar.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {

    public static final String STRING_SIX_VALUE = "aaaaaa";
    public static final String EMPTY_VALUE = "";
    public static final String SPECIAL_SIGN = "$#%@";
    public static final String NUMBER_VALUE = "1234";
    public static final String NUMBER_AND_STRING_VALUE = "123car";
    public static final String CORRECT_NAME_VALUE = "pobi";
    public static final int MOVE_ZERO = 0;
    public static final int MOVE_ONE = 1;
    public static final int GO_VALUE = 4;
    public static final int STOP_VALUE = 3;

    @Nested
    class 자동차_생성 {
        @Test
        void 자동차_생성_실패_null_입력() {
            assertThatThrownBy(() -> new Car(null))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 자동차_생성_실패_길이가_5글자보다_큰_입력() {
            assertThatThrownBy(() -> new Car(STRING_SIX_VALUE))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 자동차_생성_실패_빈_문자열_입력() {
            assertThatThrownBy(() -> new Car(EMPTY_VALUE))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 자동차_생성_실패_특문_숫자_입력() {
            assertThatThrownBy(()-> new Car(SPECIAL_SIGN))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> new Car(NUMBER_VALUE))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 자동차_생성_실패_글자_숫자_입력() {
            assertThatThrownBy(()-> new Car(NUMBER_AND_STRING_VALUE))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 자동차_생성_성공() {
            Car car = new Car(CORRECT_NAME_VALUE);
            assertThat(car.getName()).isEqualTo(CORRECT_NAME_VALUE);
        }
    }

    @Test
    void 정지확인_3이하() {
        Car car = new Car(CORRECT_NAME_VALUE);
        car.goOrStop(STOP_VALUE);

        assertThat(car.getLocation()).isEqualTo(MOVE_ZERO);
    }

    @Test
    void 이동확인_4이상() {
        Car car = new Car(CORRECT_NAME_VALUE);
        car.goOrStop(GO_VALUE);

        assertThat(car.getLocation()).isEqualTo(MOVE_ONE);
    }

}
