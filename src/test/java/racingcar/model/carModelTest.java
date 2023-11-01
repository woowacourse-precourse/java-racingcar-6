package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.view.messagePrinter.printWinners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.GameManager;

public class carModelTest {
    static List<String> carNames = new ArrayList<>(Arrays.asList("alice","john","paul")) ;

    @BeforeAll
    static void checkCreateCars() {
        GameManager.createCars(carNames);
        List<Car> cars = GameManager.getCars();
        assertThat(cars).hasSize(3);
    }

    @Test
    void checkMoveCars(){
        List<Car> cars = GameManager.getCars();
        for(int i=0;i<cars.size();i++){
            cars.get(i).move();
            assertThat(cars.get(i).raceStatus).isEqualTo(1);
        }
    }

    @Test
    void checkNominateWinners(){
        List<String> testWinners = new ArrayList<>();
        GameManager.testRun(carNames,5);
        List<Car> cars = GameManager.getCars();
        List<String> realWinners = printWinners(cars);
        int max = 0;
        for(int i=0;i< cars.size();i++){
            if(cars.get(i).raceStatus > max){
                max = cars.get(i).raceStatus;
            }
        }
        for(int i=0;i< cars.size();i++){
            if(cars.get(i).raceStatus >= max){
                testWinners.add(cars.get(i).carName);
            }
        }
        assertThat(testWinners).isEqualTo(realWinners);
    }





}
