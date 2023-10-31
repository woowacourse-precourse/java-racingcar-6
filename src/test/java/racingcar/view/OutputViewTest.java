package racingcar.view;

import org.junit.jupiter.api.*;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends OutputSetting{
    public static OutputView outputView;
    public static List<Car> cars;
    public static List<String> names;
    @BeforeAll
    public static void initializer(){
        outputView = new OutputView();
        cars = new ArrayList<>();
        names = new ArrayList<>(Arrays.asList("pobi","woni","jun"));
        for(String name : names){
            Car car = new Car(name);
            for(int i = 0;i < 5;i++){
                car.move();
            }
            cars.add(car);
        }
    }

    @BeforeEach
    public void setSystemOut(){
        systemOut();
    }

    @AfterEach
    public void unSetSystemOut(){
        printResult();
    }
    @Test
    @DisplayName("자동차_위치_출력_테스트")
    void printCarsPosition() {
        // given
        // when
        outputView.printCarsPosition(cars);
        String printCarPositionResult = getOutput();
        // then
        assertThat(printCarPositionResult).contains("pobi : ", "woni : ", "jun : ");
    }

    @Test
    @DisplayName("최종_우승자_출력_테스트")
    void printWinner() {
        // given
        // when
        outputView.printWinner(cars);
        String printCarPositionResult = getOutput();
        // then
        assertThat(printCarPositionResult).contains("최종 우승자 : ");
    }
}