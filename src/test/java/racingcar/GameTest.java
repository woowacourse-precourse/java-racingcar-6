package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    Car car1 = new Car("car1");
    Car car2 = new Car("car2");

    @Test
    void 우승자가_1명일때_테스트() {
        game.players.add(car1);
        game.players.add(car2);

        car1.state = "----";
        car2.state = "--";
        String expected = "최종 우승자 : car1";
        String result = "최종 우승자 : "+game.printWinners();

        assertEquals(expected,result);
    }

    @Test
    void 공동_우승자_테스트() {
        game.players.add(car1);
        game.players.add(car2);

        car1.state = "--";
        car2.state = "--";
        String expected = "최종 우승자 : car1,car2";
        String result = "최종 우승자 : "+game.printWinners();

        assertEquals(expected,result);
    }

}


