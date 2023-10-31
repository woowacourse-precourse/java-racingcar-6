package service;

import model.Car;
import model.Race;
import model.RacingCar;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {
    RacingCar racingCar1;
    RacingCar racingCar2;
    RacingCar racingCar3;
    ArrayList<Car> carArrayList = new ArrayList<>();
    Race race;
    int max;


    @BeforeEach
    public void createTestModel(){
        racingCar1 = new RacingCar("racingcar1");
        racingCar2 = new RacingCar("racingcar2");
        racingCar3 = new RacingCar("racingcar3");
        carArrayList.add(racingCar1);
        carArrayList.add(racingCar2);
        carArrayList.add(racingCar3);

        race = new Race(5, carArrayList);

        for(int i = 0;i < race.getLaps();i++){
            race.startDrive();
        }
        max = Math.max(Math.max(racingCar1.getPosition(), racingCar2.getPosition()),racingCar2.getPosition());
    }

    @Test
    void findMax() {
        assertThat(RacingService.findMax(race.getCarArrayList())).isEqualTo(max);
    }

    @Test
    void findWinner() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RacingService.findWinner(race.getCarArrayList(), max))
                .contains(racingCar1.getName())
                .contains(racingCar2.getName())
                .contains(racingCar3.getName());
    }
}