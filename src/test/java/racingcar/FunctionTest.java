package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.InputController;
import racingcar.model.Car;
import racingcar.util.CarNameValidator;
import racingcar.util.Constant;
import racingcar.util.RoundCountValidator;
import racingcar.util.Util;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionTest {
    @Test
    void 정규식테스트() {
        String regex = "^[0-9a-zA-Zㄱ-ㅎ가-힣,]*$";
        assertThat("1,2".matches(regex)).isEqualTo(true);
        assertThat("1123,,24325".matches(regex)).isEqualTo(true);
        assertThat("가나,다라".matches(regex)).isEqualTo(true);
        assertThat("ㄱㄴㄷㄹ1,2ㅁㅄ".matches(regex)).isEqualTo(true);
        assertThat("abc,def".matches(regex)).isEqualTo(true);
        assertThat("a1bc,deㄱf".matches(regex)).isEqualTo(true);
        assertThat(",".matches(regex)).isEqualTo(true);
        assertThat("123456".matches(regex)).isEqualTo(true);
        assertThat("abcdef".matches(regex)).isEqualTo(true);
        assertThat("ㄱㄴㄷㄹ".matches(regex)).isEqualTo(true);
        assertThat("가나다라".matches(regex)).isEqualTo(true);
        assertThat("1!,3432".matches(regex)).isEqualTo(false);
        assertThat("%%,^^".matches(regex)).isEqualTo(false);
        assertThat(", ,".matches(regex)).isEqualTo(false);
    }

    @Test
    void 스플릿테스트() {

        boolean error = false;
        try {
            new CarNameValidator("123,456");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(false);

        error = false;
        try {
            new CarNameValidator("123,,456");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator(",,123,456");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator("123,456,,");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator(",");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator(",,");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);
    }

    @Test
    void 중복테스트() {

        boolean error = false;
        try {
            new CarNameValidator("12345,12345,123");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator("가나,나다,가나,가나다");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator("abc,def,def");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator("abc,def,gh");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(false);

    }

    @Test
    void 길이테스트() {

        boolean error = false;
        try {
            new CarNameValidator("123456,123");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator("가나다라마바,나다,가나");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator("abc,def,def123");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator("abcde,가나다라마,12345,가나123");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(false);

    }

    @Test
    void 라운드횟수정규식테스트() {
        String regex = "^[1-9]\\d*$";
        assertThat("123".matches(regex)).isEqualTo(true);
        assertThat("1".matches(regex)).isEqualTo(true);
        assertThat("0".matches(regex)).isEqualTo(false);
        assertThat("012".matches(regex)).isEqualTo(false);
        assertThat("a12".matches(regex)).isEqualTo(false);
        assertThat("12a".matches(regex)).isEqualTo(false);
        assertThat("".matches(regex)).isEqualTo(false);
        assertThat("-12".matches(regex)).isEqualTo(false);
        assertThat("0.12".matches(regex)).isEqualTo(false);
    }

    @Test
    void 라운드횟수최소값테스트() {

        boolean error = false;
        try {
            new RoundCountValidator("1");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(false);

        error = false;
        try {
            new RoundCountValidator("0");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new RoundCountValidator("-1");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

    }

    @Test
    void 자동차이름셋팅테스트() {
        InputController inputController = new InputController();

        inputController.setCarNames("123,456,789").forEach(car -> System.out.println(car.getName()));
        inputController.setCarNames("가나다,abc,123").forEach(car -> System.out.println(car.getName()));

    }

    @Test
    void 랜덤숫자테스트() {
        for(int i = 0; i < 1000000; i++) {
            int num = Util.getRandomNumber();
            assertThat(num >= Constant.MIN_RANDOM_NUM && num <= Constant.MAX_RANDOM_NUM).isEqualTo(true);
        }
    }

    @Test
    void 이동거리출력테스트() {
        Car car1 = new Car("123");
        Car car2 = new Car("456");
        Car car3 = new Car("789");
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        for(int i = 0; i < 10; i++) {
            System.out.println(i+1+"round");
            cars.forEach(Car::move);
            OutputView.printRoundResult(cars);
        }
    }

    @Test
    void 우승자출력테스트() {
        OutputView.printWinner(List.of("123,456,789".split(",")));
        OutputView.printWinner(List.of("가나다,ABC,abc,123".split(",")));
    }
}
