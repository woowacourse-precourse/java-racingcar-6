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
//        car = new Car(cars);
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
    void 자동차_게임_시작_테스트() {

        String input = "pobi,jun,king,wuk";
        List<String> carNameList = game.splitCarName(input);
        LinkedHashMap<String, Integer> carLocations;
//        car.createLocationMap(carNameList);

//        carLocations = car.moveForward(carNameList);

        for (int i = 0; i < carNameList.size(); i++) {
//            System.out.println(carNameList.get(i) + " " + carLocations.get(carNameList.get(i)));
        }

    }

    @Test
    void 우승자_검사_테스트(){

        LinkedHashMap<String, Integer> locations = new LinkedHashMap<>();
        List<String> carNameList = new ArrayList<>();
        carNameList.add("pobi");
        carNameList.add("jun");
        carNameList.add("king");
        carNameList.add("rook");
        locations.put("pobi", 1);
        locations.put("jun", 3);
        locations.put("king", 3);
        locations.put("rook", 2);

        List<String> winners = new ArrayList<>();

        winners = game.judgeWinner(carNameList,locations);
        Assertions.assertTrue(winners.get(0).equals("jun"));
        Assertions.assertTrue(winners.get(1).equals("king"));


    }





}
