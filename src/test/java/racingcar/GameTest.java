package racingcar;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

public class GameTest {

    Car car;
    Game game;
    LinkedHashMap<String, Integer> cars;


    @BeforeEach
    void setUp() {
        car = new Car(cars);
        game = new Game();
    }


    @Test
    void 자동차_이름_분리_테스트() {

        String input = "pobi,jun,king,pobi,pobi";
        String[] inputs = input.split(",");
        List<String> carNameList = game.splitCarName(input);

        for (int i = 0; i < carNameList.size(); i++) {
            Assertions.assertTrue(carNameList.get(i).length() <= 5);
        }
        Assertions.assertTrue(carNameList.size() == inputs.length);

    }

    @Test
    void 자동차_게임_시작() {

        String input = "pobi,jun,king,wuk";
        List<String> carNameList = game.splitCarName(input);
        LinkedHashMap<String,Integer> carLocations;
        car.createLocationMap(carNameList);

        //carNameList를 moveForward에 전달하면 car 객체 내부에서 모든 차를 운전하는걸로
        //이렇게 되면 car 객체 내에서 createCarNumber를 해야함..

        carLocations = car.moveForward(carNameList);

        for(int i = 0 ; i < carNameList.size(); i++){
            System.out.println(carNameList.get(i)+" " +carLocations.get(carNameList.get(i)));
        }







        //car에서 locations 가지기
        //game에서 locations 가지기

        //게임시작
        // carMap 갯수만큼 순회하면서 랜덤 숫자 생성하고 car에 move 신호 주기

    }


}
