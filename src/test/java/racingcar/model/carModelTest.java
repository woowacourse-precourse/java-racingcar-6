package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.GameManager;

public class carModelTest {

    @Test
    void createCars() {
        List<String> carNames = new ArrayList<>(Arrays.asList("alice","john","paul")) ;
        GameManager.createCars(carNames);
        List<Car> cars = GameManager.getCars();
        System.out.print(cars);
        assertThat(cars).hasSize(3);
    }

    @Test
    void moveCars(){
        List<Car> cars = GameManager.getCars();
        for(int i=0;i<cars.size();i++){
            cars.get(i).move();
            assertThat(cars.get(i).raceStatus).isEqualTo(1);
        }
    }

    @Test
    void nominateWinners(){

    }





}
