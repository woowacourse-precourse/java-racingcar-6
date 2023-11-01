package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Application {
    static HostReception host = new HostReception();
    static TreeSet<RacingCar> car;

    static int round;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        host.getParticipant();
        round = host.getRoundFromUser();

        while (round-- > 0){
            host.proceedARound();
            System.out.println();
        }

        host.announceWinner();
    }
}
