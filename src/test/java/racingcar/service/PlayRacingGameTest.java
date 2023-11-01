package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Car;

class PlayRacingGameTest extends NsTest {
    private final PlayRacingGame playRacingGame;

    public PlayRacingGameTest() {
        this.playRacingGame = new PlayRacingGame();
    }

    @DisplayName("레이싱 게임")
    @Test
    void playRacingGame() {
        //given
        int moveCount = 5;
        List<Car> cars = createCar();

        //when
        playRacingGame.play(moveCount, cars);

        String output = output();
        int pobiCount = output.split("pobi : ").length - 1;
        int woniCount = output.split("woni : ").length - 1;
        int junCount = output.split("jun : ").length - 1;

        //then

        assertThat(pobiCount).isEqualTo(moveCount);
        assertThat(woniCount).isEqualTo(moveCount);
        assertThat(junCount).isEqualTo(moveCount);
    }

    private List<Car> createCar() {
        Car pobi = Car.createCar("pobi");
        Car woni = Car.createCar("woni");
        Car jun = Car.createCar("jun");
        return List.of(pobi, woni, jun);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}