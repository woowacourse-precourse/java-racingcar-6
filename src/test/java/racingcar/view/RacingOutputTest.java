package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingOutputTest {
    RacingOutput racingOutput = new RacingOutput();


    @Test
    void racingCarName() {

        List<String> testCarList = new ArrayList<>(List.of("car1","car2"));
        int testCarOrder = 1;


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        racingOutput.racingCarName(testCarList,testCarOrder);

        String output = outputStream.toString();
        String expectedString = "car2 : ";


        assertEquals(expectedString,output);

    }


    @Test
    void carMovingView() {

        List<Integer> testFowardList = new ArrayList<>(List.of(3));
        List<String> testCarList = new ArrayList<>(List.of("car1"));


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        racingOutput.carMovingView(testFowardList,testCarList);

        String output = outputStream.toString();
        String expectedString = "car1 : ---";


        assertEquals(expectedString.trim(),output.trim());

    }


}