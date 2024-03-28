package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.broadcast.Broadcast;
import racingcar.domain.regulation.Regulation;
import racingcar.domain.script.Script;
import racingcar.domain.service.receptionDesk.Impl.ReceptionDeskServiceImpl;
import racingcar.domain.service.receptionDesk.ReceptionDeskService;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Script.REGISTER.print();
        final ReceptionDeskService receptionDeskService = new ReceptionDeskServiceImpl();
        HashMap<String, Integer> lineUp = receptionDeskService.registering(Console.readLine());
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
