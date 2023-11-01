package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.view.RacingOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoopsTest {

    Loops loops = new Loops();
    RacingOutput racingOutput = new RacingOutput();

    @Test
    void carRacing() {

        List<Integer> testListInt = new ArrayList<>(List.of(1));
        List<String> testListStr = new ArrayList<>(List.of("1"));
        String expectedCarMove = "-";
        String expeftedForm = " : ";


        racingOutput.carRacing(testListInt,testListStr);

        ByteArrayOutputStream testSout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSout));

        for (int i = 0; i < testListStr.size(); i++) {

            System.out.print(testListStr.get(i));
            System.out.print(expeftedForm);
            System.out.print(expectedCarMove);

        }

        String expectOutput = "1 : -" ;
        String output = testSout.toString();
        assertEquals(expectOutput,output);
    }

    @Test
    void racingLoops() {

        int testUserSetCount = 1;
        List<Integer> testListInt = new ArrayList<>(List.of(1));
        List<String> testListStr = new ArrayList<>(List.of("1"));


        loops.loops();

        ByteArrayOutputStream testSout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSout));

        for (int i = 0; i < testUserSetCount; i++) {

            racingOutput.carRacing(testListInt,testListStr);
        }

        String expectOutput = "1 : -";
        String output = testSout.toString();


        assertEquals(expectOutput.trim(),output.trim());

    }
}