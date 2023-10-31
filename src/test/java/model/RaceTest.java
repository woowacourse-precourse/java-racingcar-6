package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;

class RaceTest {
    RacingCar racingCar1;
    RacingCar racingCar2;
    RacingCar racingCar3;
    ArrayList<Car> carArrayList = new ArrayList<>();
    Race race;

    @BeforeEach
    public void createTestModel(){
        racingCar1 = new RacingCar("racingcar1");
        racingCar2 = new RacingCar("racingcar2");
        racingCar3 = new RacingCar("racingcar3");
        carArrayList.add(racingCar1);
        carArrayList.add(racingCar2);
        carArrayList.add(racingCar3);

        race = new Race(5, carArrayList);

    }

    @Test
    void getCarArrayList() {
        assertThat(race.getCarArrayList())
                .contains(racingCar1)
                .contains(racingCar2)
                .contains(racingCar3);
    }

    @Test
    void getLaps() {
        assertThat(race.getLaps()).isEqualTo(5);
    }


    @Test
    void checkWinner() {
        racingCar1.position = 2;
        racingCar2.position = 3;
        racingCar3.position = 4;

        assertThat(race.CheckWinner().toString()).isEqualTo("racingcar3");
    }
}