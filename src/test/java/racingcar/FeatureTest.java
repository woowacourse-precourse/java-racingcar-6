package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import racingcar.Util.OutputMessage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FeatureTest extends NsTest {
    Game game = new Game();

    @BeforeAll
    static void inputInitialize() {
        StringBuilder inputBuilder = new StringBuilder();
        // input_정상_케이스
        inputBuilder.append("lee,juho,test");
        inputBuilder.append("\n");
        inputBuilder.append("3");

        // input_자동차_5글자_이상_입력_시_예외_발생
        inputBuilder.append("\n");
        inputBuilder.append("lee,juho,testAbc");

        // input_자동차_알파벳_제외_문자_입력_시_예외_발생
        inputBuilder.append("\n");
        inputBuilder.append("lee,juho,t12c");

        // input_자동차_중복된_이름_입력_시_예외_발생
        inputBuilder.append("\n");
        inputBuilder.append("juho,juho,test");

        // input_횟수_0회_입력_시_예외_발생
        inputBuilder.append("\n");
        inputBuilder.append("lee,juho,test");
        inputBuilder.append("\n");
        inputBuilder.append("0");

        // input_횟수_문자_입력_시_예외_발생
        inputBuilder.append("\n");
        inputBuilder.append("lee,juho,test");
        inputBuilder.append("\n");
        inputBuilder.append("a");

        InputStream testInput = new ByteArrayInputStream(inputBuilder.toString().getBytes());
        System.setIn(testInput);
    }

    @Test
    @Order(1)
    void input_정상_케이스() {
        String carNames = "lee,juho,test";
        String attempt = "3";

        //given
        List<String> carNameList = Arrays.asList(carNames.split(","));

        //when
        game.input();

        //then
        assertThat(game.cars.size()).isEqualTo(3);

        for (int i = 0; i < game.cars.size(); i++) {
            Car car = game.cars.get(i);
            String carName = carNameList.get(i);
            assertThat(car.getName()).isEqualTo(carName);
        }

        assertThat(game.attempt).isEqualTo(Integer.parseInt(attempt));
    }

    @Test
    @Order(2)
    void input_자동차_5글자_이상_입력_시_예외_발생() {
        //given
        String carNames = "lee,juho,testAbc";
        String attempt = "3";

        //when
        //then
        assertThatThrownBy(game::input)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Util.OutputMessage.CAR_NAME_LENGTH_ERROR_MESSAGE.getMessage());
    }

    @Test
    @Order(3)
    void input_자동차_알파벳_제외_문자_입력_시_예외_발생() {
        //given
        String carNames = "lee,juho,t12c";
        String attempt = "3";
        //when
        //then
        assertThatThrownBy(game::input)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Util.OutputMessage.CAR_NAME_LENGTH_ERROR_MESSAGE.getMessage());
    }

    @Test
    @Order(4)
    void input_자동차_중복된_이름_입력_시_예외_발생() {
        //given
        String carNames = "juho,juho,test";
        String attempt = "3";
        //when
        //then
        assertThatThrownBy(game::input)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OutputMessage.SAME_CAR_NAME_ERROR_MESSAGE.getMessage());
    }

    @Test
    @Order(5)
    void input_횟수_0회_입력_시_예외_발생() {
        //given
        String carNames = "lee,juho,test";
        String attempt = "0";
        //when
        //then
        assertThatThrownBy(game::input)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OutputMessage.ATTEMPT_VALUE_ERROR_MESSAGE.getMessage());
    }

    @Test
    @Order(6)
    void input_횟수_문자_입력_시_예외_발생() {
        //given
        String carNames = "lee,juho,test";
        String attempt = "a";
        //when
        //then
        assertThatThrownBy(game::input)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OutputMessage.ATTEMPT_VALUE_ERROR_MESSAGE.getMessage());
    }

    @Test
    void race_랜덤값_3_이하_시_거리_유지() {
        //given
        game.cars = Arrays.asList(new Car("lee"),
                new Car("juho"));
        game.attempt = 2;

        //when
        assertRandomNumberInRangeTest(
                () -> {
                    game.race();
                },
                0, 1, 2, 3
        );
        List<Car> cars = game.cars;

        //then
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }

    @Test
    void race_랜덤값_4_이상_시_거리_증가() {
        //given
        game.cars = Arrays.asList(new Car("lee"),
                new Car("juho"),
                new Car("test"));
        game.attempt = 2;
        List<Car> cars = game.cars;

        //when
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < game.attempt; i++) {
                        game.race();
                    }
                },
                4, 5, 6, 7, 8, 9
        );

        //then
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            assertThat(car.getDistance()).isEqualTo(2);
        }
    }

    @Test
    void distanceOutput_거리_별_출력_값_확인() {
        //given
        game.cars = Arrays.asList(new Car("lee"),
                new Car("juho"),
                new Car("test"));
        List<Car> cars = game.cars;
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            for (int j = 0; j < i; j++) {
                car.run(4);
            }
        }

        //when
        for (Car car : cars) {
            game.distanceOutput(car);
        }

        //then
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int distance = car.getDistance();
            StringBuilder hyphen = new StringBuilder(car.getName() + " : ");
            for (int j = 0; j < distance; j++) {
                hyphen.append("-");
            }
            assertThat(output()).contains(hyphen.toString());
        }
    }

    @Test
    void getWinners_우승자가_한_명인_경우() {
        //given
        game.cars = Arrays.asList(new Car("lee"),
                new Car("juho"));
        game.cars.get(0).run(4);
        game.cars.get(1).run(3);

        //when
        List<String> winners = game.getWinners();

        //then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo("lee");
    }

    @Test
    void getWinners_우승자가_두_명인_경우() {
        //given
        game.cars = Arrays.asList(new Car("lee"),
                new Car("juho"));
        game.cars.get(0).run(4);
        game.cars.get(1).run(4);

        //when
        List<String> winners = game.getWinners();

        //then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0)).isEqualTo("lee");
        assertThat(winners.get(1)).isEqualTo("juho");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
