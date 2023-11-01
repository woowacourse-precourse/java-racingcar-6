package racingcar;

import racingcar.racer.Racer;
import racingcar.utils.Printer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
                racer.runRaceEachStep();
            }
            racerList.add(racer);
        }
        String expectedPrint = """
                test1 : -
                test2 : --
                test3 : ---""";

        Printer.printInProgress(racerList);
        Assertions.assertEquals(expectedPrint,outputStreamCaptor.toString().trim());
    }
    @Test
    void 단독_우승자를_출력한다(){
        List<String> winnerList = new ArrayList<>();
        winnerList.add("pobi");

        Printer.printTotalWinners(winnerList);
        String expectedResult = "최종 우승자 : pobi";

        Assertions.assertEquals(expectedResult,outputStreamCaptor.toString().trim());
    }

    @Test
    void 공동_우숭자들을_출력한다(){
        List<String> winnerList = new ArrayList<>();
        winnerList.add("pobi");
        winnerList.add("jun");

        Printer.printTotalWinners(winnerList);
        String expectedResult = "최종 우승자 : pobi, jun";

        Assertions.assertEquals(expectedResult, outputStreamCaptor.toString().trim());
    }


}
