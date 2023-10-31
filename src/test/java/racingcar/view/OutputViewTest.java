package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.Winner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 라운드_상황별_자동차_상태_출력_테스트() {
        String name1 = "juni";
        String name2 = "huni";

        List<RacingCar> moveRacingCarList = Arrays.asList(
                new RacingCar(name1, 3, bound -> 3),
                new RacingCar(name2, 4, bound -> 4)
        );

        RacingCars racingCars = new RacingCars(moveRacingCarList);

        OutputView.printMoveRacingCar(racingCars);
        String printBeforeMove = "juni : ---\nhuni : ----\n\n";
        assertThat(output.toString()).isEqualTo(printBeforeMove);

        moveRacingCarList.stream().forEach(RacingCar::testMove);

        output.reset();

        OutputView.printMoveRacingCar(racingCars);
        String printAfterMove = "juni : ---\nhuni : -----\n\n";
        assertThat(output.toString()).isEqualTo(printAfterMove);

    }

    @Test
    void 우승자_출력_테스트() {
        String name1 = "juni";
        String name2 = "huni";
        String name3 = "jun";

        List<RacingCar> racingCars = Arrays.asList(
                new RacingCar(name1, 4),
                new RacingCar(name2, 6),
                new RacingCar(name3, 6)
        );

        Winner winner = new Winner(racingCars);

        OutputView.printWinner(winner);

        String winnerString = "최종 우승자 : huni, jun";

        assertThat(output.toString()).isEqualTo(winnerString);

    }
}