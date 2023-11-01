package racingcar.Controller;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VictoryConditionTest {

    VictoryCondition victory = new VictoryCondition();
    @Test
    void mostFarDistance() {

        List<Integer> testPointList = new ArrayList<>(List.of(1,2,3));


        int mostFar = victory.mostFarDistance(testPointList);
        int expectInt = 3;


        assertEquals(mostFar,expectInt);
    }


    @Test
    void makeWinnerList() {

        List<Integer> testPointList = new ArrayList<>(List.of(1,2,3,3));
        List<String> testCarList = new ArrayList<>(List.of("car1","car2","car3","car4"));
        int testMostFar = victory.mostFarDistance(testPointList);

        List<String> testWinList = victory.makeWinnerList(testCarList,testPointList,testMostFar);
        List<String> expectList = new ArrayList<>(List.of("car3","car4"));


        assertEquals(expectList,testWinList);
    }
}