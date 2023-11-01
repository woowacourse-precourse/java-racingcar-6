package racingcar.Controller;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarMovingProcessTest {

    private CarMovingProcess carMovingProcess = new CarMovingProcess();

    @Test
    void makingForwardCountList() {
        List<String> testCarNameList = new ArrayList<>(List.of("car1", "car2", "car3"));


        List<Integer> actualList = carMovingProcess.makingForwardCountList(testCarNameList);
        List<Integer> expectedList = new ArrayList<>(List.of(0,0,0));

        assertEquals(expectedList,actualList);

    }


    @Test
    void makeRandomNum() {

        Integer randoms = carMovingProcess.makeRandomNum();


        int[] intArr = new int[10];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = i;
        }


        assertThat(intArr).contains(randoms);
    }


}