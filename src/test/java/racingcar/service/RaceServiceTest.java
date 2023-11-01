package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

import java.util.ArrayList;
import java.util.List;


class RaceServiceTest {

    List<Car> cars = new ArrayList<>();
    @BeforeEach
    void init(){
        cars.add(new Car("tom"));
        cars.add(new Car("jerry"));
        cars.add(new Car("patty"));
    }
    
    @Test
    void Race객체가_주어졌을_때_안에_있는_Car의_advanceNum이_랜덤으로_1씩증가(){

        Race race = new Race(cars, 3);
        RaceService raceService = new RaceService(race.getRaceRound());
        raceService.moveCarByLogic(race);
        for (Car car : cars) {
            Assertions.assertThat(car.advanceNum).isBetween(0,1);
        }
    }

    @Test
    void 남은_라운드_갯수는_1줄어든다(){
        Race race = new Race(cars, 3);
        RaceService raceService = new RaceService(race.getRaceRound());
        raceService.moveCarByLogic(race);
        Assertions.assertThat(RaceService.remainRound).isEqualTo(2);
    }

    @Test
    void 우승한_차를_찾아내준다(){
        Race race = new Race(cars, 3);
        RaceService raceService = new RaceService(race.getRaceRound());
        raceService.moveCarByLogic(race);
        raceService.moveCarByLogic(race);
        raceService.moveCarByLogic(race);

        List<String> winner = RaceService.findWinner(race);
        Assertions.assertThat(winner.size()).isBetween(1,3);
        for (String championCarName : winner) {
            System.out.println(championCarName);
        }

    }
}