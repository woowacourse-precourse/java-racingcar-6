package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class PrinterTest {
    private ByteArrayOutputStream outputStreamCaptor=new ByteArrayOutputStream();
    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
    void 현재_경기_상황을_출력한다(){
        List<Racer> racerList = new ArrayList<>();
        for (int i =1;i<=3;i++){
            Racer racer = new Racer("test"+i);
            while (racer.getCurrentPos()!=i){
                racer.continueRace();
            }
            racerList.add(racer);
        }
        String expectedPrint = """
                test1 : -
                test2 : --
                test3 : ---""";

        Printer.printRaceResultInProgressWithRacerList(racerList);
        Assertions.assertEquals(expectedPrint,outputStreamCaptor.toString().trim());
    }

}
