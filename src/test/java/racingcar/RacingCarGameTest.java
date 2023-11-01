package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {
    @AfterEach
    public void 콘솔_입력_초기화() {
        Console.close();
    }

    @Test
    public void 자동차_이름들을_입력받는_기능() {
        String input = "red,green,blue";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.insertRacingCars();

        List<RacingCar> cars = racingCarGame.getCars();
        Assertions.assertThat(cars.size()).isEqualTo(3);
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("red");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("green");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("blue");
    }

    @Test
    public void 자동차_이름들을_입력받을때_쉼표_기준으로_틀렸을_경우_예외가_발생_해야한다() {
        String input = "red,,green,blue";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        RacingCarGame racingCarGame = new RacingCarGame();

        Assertions.assertThatThrownBy(() -> {
            racingCarGame.insertRacingCars();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 입력 형식입니다.");
    }

    @Test
    public void 자동차_이름들을_입력받을때_이름이_5자_초과일_경우_예외가_발생_해야한다() {
        String input = "red,green,blue,rainbow";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        RacingCarGame racingCarGame = new RacingCarGame();

        Assertions.assertThatThrownBy(() -> {
            racingCarGame.insertRacingCars();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("이름이 5자 초과인 자동차가 존재합니다.");
    }

    @Test
    public void 사용자에게_이동_횟수_입력을_받는_기능() {
        String input = "6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.insertMoveCnt();

        int moveCnt = racingCarGame.getMoveCnt();

        Assertions.assertThat(moveCnt).isEqualTo(6);
    }

    @Test
    public void 사용자에게_이동_횟수를_입력받을때_하나의_자연수가_아니면_예외가_발생_해야한다() {
        String input = "6,9";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        RacingCarGame racingCarGame = new RacingCarGame();

        Assertions.assertThatThrownBy(() -> {
            racingCarGame.insertMoveCnt();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("하나의 자연수를 입력하십시오.");
        ;
    }

    @Test
    public void 모든_자동차의_위치를_출력하는_기능() {
        String input = "red,green,blue";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.insertRacingCars();
        racingCarGame.getCars().get(0).moveForward();
        racingCarGame.getCars().get(0).moveForward();
        racingCarGame.getCars().get(1).moveForward();

        racingCarGame.printCarsLocation();

        Assertions.assertThat(out.toString()).isEqualTo("red : --\ngreen : -\nblue : \n");
    }

    @Test
    public void 최종_우승자를_출력하는_기능() {
        String input = "red,green,blue";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.insertRacingCars();
        racingCarGame.getCars().get(0).moveForward();
        racingCarGame.getCars().get(1).moveForward();

        racingCarGame.printWinner();

        Assertions.assertThat(out.toString()).isEqualTo("최종 우승자 : red, green\n");
    }
}