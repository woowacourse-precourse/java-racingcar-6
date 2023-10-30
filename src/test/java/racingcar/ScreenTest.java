package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ScreenTest {

    @Test
    void 자동차_이름_입력() {
        String input = "pobi,yen,joy,red";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] result = Screen.askCarNames();

        assertThat(result).hasSize(4);
        assertThat(result).containsExactly("pobi", "yen", "joy", "red");
    }

    @Test
    void 길이_5이상의_자동차_이름_입력() {
        String input = "computer,yen,joy,red";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(Screen::askCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이_0인_자동차_이름_입력() {
        String input = ",yen,joy,red";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(Screen::askCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주_시행_횟수_입력() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int result = Screen.askRacingTime();

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 경주_시행_횟수_숫자가_아닌_문자열_입력() {
        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(Screen::askRacingTime)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동이_하나도_없는_경우_한_라운드_실행_결과_출력() {
        String[] names = {"pobi", "yen"};
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Screen.displayResult(cars);
        assertThat(out.toString()).isEqualTo("pobi : \nyen : \n\n");
    }

    @Test
    void 이동이_있는_경우_한_라운드_실행_결과_출력() {
        String[] names = {"pobi", "yen"};
        List<Car> cars = new ArrayList<>();
        int idx = 1;
        for (String name : names) {
            cars.add(new Car(name, idx++));
        }
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Screen.displayResult(cars);
        assertThat(out.toString()).isEqualTo("pobi : -\nyen : --\n\n");
    }

    @Test
    void 우승자_출력() {
        List<String> winners = new ArrayList<>();
        winners.add("yen");
        winners.add("pobi");
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Screen.displayWinners(winners);
        assertThat(out.toString()).isEqualTo("최종 우승자 : yen, pobi\n");

    }

    @Test
    void 단독_우승자_메시지_만들기() {
        List<String> winner = new ArrayList<>();
        winner.add("yen");
        String result = Screen.makeWinnerListMessage(winner);

        assertThat(result).isEqualTo("yen");
    }

    @Test
    void 공동_우승자_메시지_만들기() {
        List<String> winners = new ArrayList<>();
        winners.add("yen");
        winners.add("pobi");
        String result = Screen.makeWinnerListMessage(winners);

        assertThat(result).isEqualTo("yen, pobi");
    }
}
