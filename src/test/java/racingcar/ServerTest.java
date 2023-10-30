package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class ServerTest {
    Server server;
    @BeforeEach
    void setUp(){
        server = new Server();
    }
    @Test
    void 해당_경주에_참여하는_레이서_명단을_접수한다(){
        server.confirmRacerList("pobi,woni");
        Assertions.assertEquals(2,server.getRacerList().size());
    }
    @Test
    void 경주를_시도하는_횟수를_접수한다(){
        server.confirmRacerCount("5");
        Assertions.assertEquals(5,server.getRacerCount());
    }
    @Test
    void 경주를_시작할_수_있다() {
        server.confirmRacerList("pobi,woni");
        server.confirmRacerCount("20");

        server.startRace();

        List<Racer> racerList = server.getRacerList();
        for (Racer racer : racerList) {
            Assertions.assertNotEquals(0,racer.getCurrentPos());
        }
    }
    @Test
    void 레이서들중_단일_우승자를_출력한다(){
        server.confirmRacerList("pobi,woni,crong");
        ByteArrayOutputStream outputStreamCaptor=new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String expectedResult = "최종 우승자 : crong";

        var racerList = server.getRacerList();
        int multipleUnit = 1;
        for ( Racer racer : racerList){
            for ( int i =0;i<multipleUnit;i++)
                racer.runRaceEachStep();
            multipleUnit *=10;
        }
        server.finishRace();

        Assertions.assertEquals(expectedResult, outputStreamCaptor.toString().trim());
    }
}
