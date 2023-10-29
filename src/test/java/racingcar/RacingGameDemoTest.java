package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarDemo;
import racingcar.domain.RacingGameDemo;

class RacingGameDemoTest {
    @AfterEach
    void restoreSystemIn() {
        Console.close();
    }

    @Test
    @DisplayName("자동차에 이름을 부여한다.")
    void test1() {
        System.setIn(new ByteArrayInputStream("pobi,go,kim".getBytes()));
        String carNames = Console.readLine();
        RacingGameDemo racingGameDemo = new RacingGameDemo(carNames);

        assertThat(racingGameDemo.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("플레이어에게 시도 횟수를 묻는다.")
    void test2() {
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        int playCount = Integer.parseInt(Console.readLine());

        assertThat(playCount).isEqualTo(5);
    }

    @Test
    @DisplayName("0에서 9까지의 무작위 숫자를 생성한다.")
    void test3() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    @DisplayName("우승자를 결정한다.")
    void test4() {
        CarDemo car1 = new CarDemo("go");
        CarDemo car2 = new CarDemo("kim");
        CarDemo car3 = new CarDemo("lee");
        List<CarDemo> cars = List.of(car1, car2, car3);

        RacingGameDemo racingGameDemo = new RacingGameDemo(cars);
        List<CarDemo> winners = racingGameDemo.findWinner();

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isSameAs(car1);
    }

    @Test
    @DisplayName("자동차 이름 입력 시 아무것도 입력하지 않는다.")
    void test5() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        assertThrows(NoSuchElementException.class, Console::readLine);
    }

    @Test
    @DisplayName("자동차 이름을 5자 초과로 입력한다.")
    void test6() {
        System.setIn(new ByteArrayInputStream("가나다라마바사".getBytes()));
        String carName = Console.readLine();

        assertThatIllegalArgumentException().isThrownBy(() -> new CarDemo(carName));
    }

    @Test
    @DisplayName("시도 횟수 입력 시 아무것도 입력하지 않는다.")
    void test7() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        assertThrows(NoSuchElementException.class, Console::readLine);
    }

    @Test
    @DisplayName("시도 횟수 입력 시 숫자가 아닌 다른 문자를 입력한다.")
    void test8() {
        System.setIn(new ByteArrayInputStream("abc".getBytes()));
        String playCount = Console.readLine();
        final Boolean isNumber = Pattern.matches("^[\\d]$", playCount);

        assertThat(isNumber).isEqualTo(false);
    }
}