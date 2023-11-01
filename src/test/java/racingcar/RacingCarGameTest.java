package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {
    @Test
    public void 자동차_이름들을_입력받는_기능() {
        String input = "red,green,blue";
        RacingCarGame racingCarGame = new RacingCarGame();

        racingCarGame.setRacingCars(input);

        List<RacingCar> cars = racingCarGame.getCars();
        Assertions.assertThat(cars.size()).isEqualTo(3);
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("red");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("green");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("blue");
    }

    @Test
    public void 자동차_이름들을_입력받을때_쉼표_기준으로_틀렸을_경우_예외가_발생_해야한다() {
        String input = "red,,green,blue";
        RacingCarGame racingCarGame = new RacingCarGame();

        Assertions.assertThatThrownBy(() -> {
            racingCarGame.setRacingCars(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이름들을_입력받을때_이름이_5자_초과일_경우_예외가_발생_해야한다() {
        String input = "red,green,blue,rainbow";
        RacingCarGame racingCarGame = new RacingCarGame();

        Assertions.assertThatThrownBy(() -> {
            racingCarGame.setRacingCars(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사용자에게_이동_횟수_입력을_받는_기능() {
        String input = "6";
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.setMoveCnt(input);

        int moveCnt = racingCarGame.getMoveCnt();

        Assertions.assertThat(moveCnt).isEqualTo(6);
    }

    @Test
    public void 사용자에게_이동_횟수를_입력받을때_하나의_자연수가_아니면_예외가_발생_해야한다() {
        String input = "6,9";
        RacingCarGame racingCarGame = new RacingCarGame();

        Assertions.assertThatThrownBy(() -> {
            racingCarGame.setMoveCnt(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 모든_자동차의_위치를_출력하는_기능() {
        String input = "red,green,blue";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.setRacingCars(input);
        racingCarGame.getCars().get(0).moveForward();
        racingCarGame.getCars().get(0).moveForward();
        racingCarGame.getCars().get(1).moveForward();

        racingCarGame.printCarsLocation();

        Assertions.assertThat(out.toString()).isEqualTo("red : --\ngreen : -\nblue : \n");
    }

    @Test
    public void 최종_우승자를_출력하는_기능() {
        String input = "red,green,blue";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.setRacingCars(input);
        racingCarGame.getCars().get(0).moveForward();
        racingCarGame.getCars().get(1).moveForward();

        racingCarGame.printWinner();

        Assertions.assertThat(out.toString()).isEqualTo("최종 우승자 : red, green\n");
    }
}