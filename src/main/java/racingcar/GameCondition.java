package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameCondition {
    public static int times = 0;
    public GameCondition(){}

    public static int movedTimes(){
        System.out.println(PrintMessage.QUESTION_CHANCE);
        times = Integer.parseInt(Console.readLine());
        return times;
    }

    public boolean forwardCar() {
        int forwardNumber = Randoms.pickNumberInRange(0, 9);
        if (forwardNumber >= 4) {
            return true;
        }
        return false;
    }

    public String movingPlayer() {
        Player player = new Player();
        List<String> memberList = player.memberList();
        String individualPlayers = "";
        for (String member : memberList) {
            individualPlayers = member;
        }
        return individualPlayers;
    }

    public String movedResultStick(){

        return null;
    }
}
