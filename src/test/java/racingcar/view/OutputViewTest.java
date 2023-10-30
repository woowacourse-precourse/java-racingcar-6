package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.Winner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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

        RacingCar racingCar1 = new RacingCar("juni", 1, bound -> 3);
        RacingCar racingCar2 = new RacingCar("huni", 1, bound -> 4);

        List<RacingCar> racingCarList = new ArrayList<>();
        List<RacingCar> moveRacingCarList = new ArrayList<>();

        /** 이동 전 print 체크 **/
        racingCarList.add(racingCar1);
        racingCarList.add(racingCar2);

        RacingCars racingCars = new RacingCars(racingCarList);

        OutputView.printMoveRacingCar(racingCars);

        String printRacingCarString1 = "juni : -\nhuni : -\n\n";

        assertThat(output.toString()).isEqualTo(printRacingCarString1);

        /** 이동 후 print 체크 **/
        int round = 5;
        for (int i = 0; i < round; i++) {
            racingCar1.testMove();
            racingCar2.testMove();
        }
        moveRacingCarList.add(racingCar1);
        moveRacingCarList.add(racingCar2);

        output.reset();

        racingCars = new RacingCars(racingCarList);

        OutputView.printMoveRacingCar(racingCars);

        String printMoveRacingCarString = "juni : -\nhuni : ------\n\n";

        assertThat(output.toString()).isEqualTo(printMoveRacingCarString);

    }

    @Test
    void 우승자_출력_테스트() {
        String name1 = "juni";
        String name2 = "huni";
        String name3 = "jun";

        RacingCar racingCar1 = new RacingCar(name1, 4);
        RacingCar racingCar2 = new RacingCar(name2, 6);
        RacingCar racingCar3 = new RacingCar(name3, 6);

        List<RacingCar> racingCars = new ArrayList<>();

        racingCars.add(racingCar1);
        racingCars.add(racingCar2);
        racingCars.add(racingCar3);

        Winner winner = new Winner(racingCars);

        OutputView.printWinner(winner);

        String winnerString = "최종 우승자 : huni, jun";

        assertThat(output.toString()).isEqualTo(winnerString);

    }
}