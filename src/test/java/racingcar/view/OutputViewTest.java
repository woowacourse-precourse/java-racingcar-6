package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.service.RaceService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    List<Car> cars = new ArrayList<>();
    @BeforeEach
    void init(){
        cars.add(new Car("tom"));
        cars.add(new Car("jerry"));
        cars.add(new Car("patty"));
    }

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }
    @Test
    void 현재_상황을_출력할때_모든_차_이름은_출력되야한다() {
        Race race = new Race(cars, 3);
        RaceService raceService = new RaceService(race.getRaceRound());
        raceService.moveCarByLogic(race);
        OutputView.showCurrentMove(race);
        Assertions.assertThat(output.toString()).contains("tom", "jerry", "patty", ":");
    }

    @Test
    void 우승자_출력시_주어진_차이름_중_하나는_적어도_포함이_되야한다() {
        Race race = new Race(cars, 3);
        RaceService raceService = new RaceService(race.getRaceRound());
        raceService.moveCarByLogic(race);
        raceService.moveCarByLogic(race);
        raceService.moveCarByLogic(race);
        OutputView.printWinner(RaceService.findWinner(race));

        Assertions.assertThat(output.toString()).containsAnyOf("tom", "jerry", "patty");
    }
}