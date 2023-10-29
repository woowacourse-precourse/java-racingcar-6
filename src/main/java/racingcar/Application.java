package racingcar;

import racingcar.domain.broadcast.Broadcast;
import racingcar.domain.regulation.Regulation;
import racingcar.domain.script.Script;

import java.util.HashMap;

import static racingcar.domain.reception.ReceptionDesk.registering;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Script.REGISTER.print();
        HashMap<String, Integer> lineUp = registering();
        // hi,my,name,is,hello,world

        Script.LAPS.print();
        int laps = Regulation.setLaps();

        Script.RESULT.print();
        for (int i = 0; i < laps; i++) {
            Regulation.goStop(lineUp);
            Broadcast.broadcasting(lineUp);
            System.out.println();
        }

        Script.PRIZE_CEREMONY.print();
        Broadcast.prizeCeremony(lineUp);
    }

}
