package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import racingcar.controller.RacingController;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.Round;

import java.util.ArrayList;


public class LogicTest {
    RacingController racingController = new RacingController();
    ArrayList<Car> carsList = new ArrayList<>();
    private Car car1;
    private Car car2;
    private Round round;

    @BeforeEach
    public void 자동차_저장() {
        round = new Round();
        car1 = new Car("포비",0);
        car2 = new Car("수현",1);
        carsList.add(car1); carsList.add(car2);
    }
}
