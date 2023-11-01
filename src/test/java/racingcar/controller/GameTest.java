package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class GameTest {

    Game game;
    ArrayList<Car> cars;
    ByteArrayOutputStream outputStreamCaptor;
    @BeforeEach
    public void constructGame() {
        cars = new ArrayList<Car>();
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void afterEach() {
        cars.clear();
        outputStreamCaptor.reset();
    }

    @Test
    public void testGameInit() {
        game = new Game();
        System.setIn(new ByteArrayInputStream("tobi,ksh\n2\n".getBytes()));
        game.init();
        assertThat(outputStreamCaptor.toString())
                .isEqualTo("경주할 자동차 이름을 입력하세요.\n시도할 회수는 몇회인가요?\n\n");
        try {
            System.in.reset();
        } catch (Exception e) {
            System.out.println();
        }
    }

    @Test
    public void testGameRun() {
        cars.add(new Car("tobi", 0));
        cars.add(new Car("ksh", 0));
        game = new Game(cars, 2);
        game.run((low, up) -> 1);
        assertThat(outputStreamCaptor.toString())
                .isEqualTo("실행 결과\ntobi : \nksh : \n\ntobi : \nksh : \n\n\n");
    }

    @Test
    public void testGameResult() {
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("tobi", 2));
        cars.add(new Car("ksh", 1));
        game = new Game(cars, 2);
        game.result();
        assertThat(outputStreamCaptor.toString())
                .isEqualTo("최종 우승자 : tobi\n");
    }

    @Test
    public void testGameDuplicateResult() {
        cars.add(new Car("tobi", 2));
        cars.add(new Car("ksh", 2));
        game = new Game(cars, 2);
        game.result();
        assertThat(outputStreamCaptor.toString())
                .isEqualTo("최종 우승자 : tobi, ksh\n");
    }
}
