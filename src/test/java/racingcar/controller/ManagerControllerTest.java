package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.manager.controller.ManagerController;
import racingcar.manager.model.Car;
import racingcar.manager.model.Manager;

public class ManagerControllerTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private final ManagerController managerController = new ManagerController();
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams(){
        System.setOut(System.out);
        output.reset();
    }

    private boolean isRandomNumberInBound(int randomNumber){
        return randomNumber >= 0 && randomNumber <= 9;
    }

    @Test
    void 난수_생성_범위_테스트(){
        int randomNumber = managerController.createRandomNumber();
        assertThat(isRandomNumberInBound(randomNumber)).isTrue();
    }

    @Test
    void 레이싱_실행_테스트(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi",0));
        cars.add(new Car("woni",0));

        assertRandomNumberInRangeTest(
                ()->{
                    managerController.executeRacing(cars,2);
                    assertThat(output.toString()).contains("pobi : ","woni : ","\n","-","--");
                },
                MOVING_FORWARD, STOP,MOVING_FORWARD,MOVING_FORWARD
        );
    }

    @Test
    void 레이싱_1회_실행_후_차량_움직임_테스트(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi",0));
        cars.add(new Car("woni",0));

        assertRandomNumberInRangeTest(
                ()->{
                    managerController.executeOneTry(cars);
                    int firstCarMoveCount = cars.get(0).getMoveCount();
                    int secondCarMoveCount = cars.get(1).getMoveCount();
                    assertThat(firstCarMoveCount).isEqualTo(0);
                    assertThat(secondCarMoveCount).isEqualTo(1);
                },
                STOP,MOVING_FORWARD
        );
    }

    @Test
    void 레이싱_실행_후_차량_움직임_출력_테스트(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi",4));
        cars.add(new Car("woni",5));

        managerController.printTryResult(cars);
        assertThat(output.toString()).contains("pobi : ","woni : ","----","-----");
    }

    @Test
    void 우승_차량_판단_테스트(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi",4));
        cars.add(new Car("woni",5));
        cars.add(new Car("jun",5));

        Manager judgeWinnerCar = managerController.judgeWinnerCar(cars);
        List<String> winnerCars = judgeWinnerCar.getWinnerCars();

        assertThat(winnerCars).contains("woni","jun");
    }

    @Test
    void 우승_차량_출력_테스트(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi",4));
        cars.add(new Car("woni",5));
        cars.add(new Car("jun",5));

        Manager judgeWinnerCar = managerController.judgeWinnerCar(cars);
        managerController.finalWinner(judgeWinnerCar);

        assertThat(output.toString()).isEqualTo("최종 우승자 : woni, jun");

    }
}
