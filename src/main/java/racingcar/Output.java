package racingcar;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Output {

    public static void tellStartAndWantName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }


    public static void tellHowManyRoundWant() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void userCondition(HashMap mapOfUserInfo, String[] stringArrayOfUserName) {
        for (String name : stringArrayOfUserName) {
            String line = showHowMuchGo((Integer) mapOfUserInfo.get(name));
            System.out.println(name + " : " + line);
        }
    }

    public static String showHowMuchGo(int howMuchGoNum) {
        String line = "";
        for (int i = 0; i < howMuchGoNum; i++) {
            line += "-";
        }
        return line;
    }


    public static int findNumOfWinner(HashMap groupMap, String[] groupName, int getRoundNum) {
        int roundNum = getRoundNum;
        boolean judgeTrue = true;
        while (!groupMap.containsValue(roundNum)) {
            roundNum -= 1;
        }
        return roundNum;
    }


    public static String[] findWinner(HashMap groupMap, String[] groupName, int roundNum) {
        List<String> winnerList = new ArrayList<>();
        for (String name : groupName) {
            if (groupMap.get(name) == (Integer) roundNum) {
                winnerList.add(name);
            }
        }
        String[] winnerGroup = new String[winnerList.size()];
        for (int i = 0; i < winnerList.size(); i++) {
            winnerGroup[i] = winnerList.get(i);
        }
        return winnerGroup;
    }

    public static void showWinner(String[] winnerGroup) {
        System.out.print("최종 우승자 : ");
        if (winnerGroup.length == 1) {
            System.out.println(winnerGroup[0]);
        } else {
            System.out.print(winnerGroup[0]);
            for (int i = 1; i < winnerGroup.length; i++) {
                System.out.print(", " + winnerGroup[i]);
            }
        }
    }
}




