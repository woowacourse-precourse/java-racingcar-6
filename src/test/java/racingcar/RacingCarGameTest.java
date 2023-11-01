package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.RacingcarGame;

import java.util.LinkedList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarGameTest {
    RacingcarGame racingcarGame;

    @Test
    public void setRacingCarTest(){
        racingcarGame = new RacingcarGame();
        racingcarGame.setRacingCar("pobi,woni,jun");
        for(int i=0; i<racingcarGame.carList.size(); i++){
            System.out.println(racingcarGame.carList.get(i).name);
        }
    }

    @Test
    public void printDashTest(){
        racingcarGame = new RacingcarGame();
        System.out.println();
        racingcarGame.printDash(3);
        System.out.println();
        System.out.println();
    }

    @Test
    public void printGameResultTest(){
        List<Car> carList = new LinkedList<>();
        Car A = new Car("a");
        A.distance = 1;
        Car B = new Car("b");
        B.distance = 3;
        Car C = new Car("c");
        C.distance = 5;

        carList.add(A);
        carList.add(B);
        carList.add(C);
        racingcarGame = new RacingcarGame(carList,0,  5);
        System.out.println();
        racingcarGame.printGameResult();
        System.out.println();
        System.out.println();
    }

    @Test
    public void doGameTest(){
        List<Car> carList = new LinkedList<>();
        Car A = new Car("a");
        Car B = new Car("b");
        Car C = new Car("c");

        carList.add(A);
        carList.add(B);
        carList.add(C);
        racingcarGame = new RacingcarGame(carList,5, -1);
        System.out.println();
        racingcarGame.doGame(0);
        System.out.println();
        System.out.println();
    }

    @Test
    public void printWinnerTest(){
        List<Car> carList = new LinkedList<>();
        Car A = new Car("a");
        A.distance = 3;
        Car B = new Car("b");
        B.distance = 3;
        Car C = new Car("c");
        C.distance = 3;

        carList.add(A);
        carList.add(B);
        carList.add(C);
        racingcarGame = new RacingcarGame(carList,0, 3);
        System.out.println();
        racingcarGame.printWinner();
        System.out.println();
        System.out.println();
    }
}
