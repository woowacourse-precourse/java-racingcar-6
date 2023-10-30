package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.exception.ExceptionMessage;
import racingcar.player.Player;
import racingcar.utils.Utils;
import racingcar.view.OutputView;

class RacingCarGameTest {

    private final Car car = new Car();

    @Test
    void resultForMidder_메서드_사용시_중간_실행_결과_츌력() {
        OutputView outputView = new OutputView();
        car.createName("ccc,ppp,ooo");
        List<String> names = car.getNames();
        String result = outputView.resultForMiddle(names, car);

        System.out.println(result);

        assertThat(result).contains("ccc : \n", "ppp : \n");
    }

    @Test
    void winnerList_메서드_사용시_우승자_확인() {
        car.createName("ccc,ppp,ooo");
        List<String> names = car.getNames();
        car.driving(names);

        for (String name : names) {
            System.out.println("차 이름: " + name + " / 전진 횟수: " + car.getValue(name));
        }

        List<String> result = car.winnerList();
        System.out.println(result);
    }

    @Test
    void driving_메서드_사용시_전진_또는_멈춤_수행() {
        car.createName("ccc,ppp,ooo");
        car.driving(car.getNames());
        List<String> names = car.getNames();
        Collection<Integer> values = car.getValues();

        for (String name : names) {
            System.out.println("차 이름: " + name + " / 전진 횟수: " + car.getValue(name));
        }

        assertThat(values).contains(0);
    }

    @Test
    void createName_메서드_사용시_이름_대응된_정수값_빈문자열로_초기화() {
        car.createName("ccc,ppp,ooo");
        List<String> names = car.getNames();

        for (String name : names) {
            System.out.println("차 이름: " + name + " / 전진 횟수: " + car.getValue(name));
        }
        assertThat(names).contains("ccc", "ppp", "ooo");
    }

    @Test
    void validateName_메서드_사용시_자동차_이름이_5자_초과할_때_예외_발생() {
        assertThatThrownBy(() -> car.createName("pooooo"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NAME_OF_RANGE);
    }

    @Test
    void splitToName_메서드_사용시_쉼표_없는_문자열_반환() {
        car.createName("oop,ppp,123");

        assertThat(car.getNames()).isEqualTo(Arrays.asList("oop", "ppp", "123"));
    }

    @Test
    void moveOnInput_메서드_사용시_0보다_큰_정수_아니면_예외_발생() {
        Player player = new Player();

        assertThatThrownBy(() -> player.moveOnInput("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.MOVE_OF_RANGE);
    }

    @Test
    void createRandomNumber_메서드로_랜덤_값을_반환() {
        int result = Utils.randomNumberGenerator();

        assertThat(Utils.isNumberRange(result)).isTrue();
    }

    @Test
    void printToResult_메서드_사용시_최종_우승자_출력() {
        OutputView outputView = new OutputView();

        String result = outputView.printToResult(List.of("pppp", "angel", "라이언"));

        assertThat(result).isEqualTo("pppp, angel, 라이언");
    }
}
