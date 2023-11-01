package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class GameFuctionTest {

    GameFunction gameFunction = new GameFunction();
    UserInput userInput = new UserInput();
    ValueCheck valueCheck = new ValueCheck();

    @Test
    void 사용자에게_자동차이름_입력받기() {
        String input = "1,2";
        String[] expected = input.split(",");

        List<String> result = gameFunction.SplitCarName(input);

        assertThat(result).contains(expected);
    }

    @Test
    void 구분자를_포함하지_않으면_예외발생() {

        //UserInput userInput = new UserInput();

        String input = "1";
        InputStream readLine = new ByteArrayInputStream(input.getBytes());
        System.setIn(readLine);

        assertThatThrownBy(userInput::getCarNames)
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 이름이_다섯자_이하인가() {

        //ValueCheck valueCheck = new ValueCheck();

        List<String> input = new ArrayList<>(List.of("aaaaaa,bbbb"));
        assertThatThrownBy(() -> valueCheck.sizeUnderFive(input))
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 자동차_전진횟수_숫자가_아닌경우_예외발생() {

        String input = "a";
        InputStream readLine = new ByteArrayInputStream(input.getBytes());
        System.setIn(readLine);

        assertThatThrownBy(userInput::getTurn)
            .isInstanceOf(IllegalArgumentException.class);


    }

    @Test
    void 매회차마다_차의_전진여부를_합산() {
        List<Car> carList = new ArrayList<>();
        List<Boolean> carCanGo = new ArrayList<>();

        Car a = new Car("a");
        Car b = new Car("b");
        carList.add(a);
        carList.add(b);

        carCanGo.add(true);
        carCanGo.add(false);

        gameFunction.applyScore(carList, carCanGo);

        assertThat(a.score).isEqualTo(1);
        assertThat(b.score).isEqualTo(0);

    }


}
