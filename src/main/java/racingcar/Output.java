package racingcar;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Output {

    public static void tellStartAndWantName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    ;

    public static void tellGroupName(String[] groupName) {
        System.out.println(String.join(",", groupName));
    }

    public static void tellHowManyRoundWant(){
        System.out.println("시도할 회수는 몇회인가요?");

    }

    public static void tellCurrent(HashMap map, String[] groupCar) {
        for (String name : groupCar) {
            String line = showHowMuchGo((Integer) map.get(name));
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
        // 최고 전진 횟수를 찾고 이후 이 최고 전진횟수를 가진 유저를 찾는다.
        int roundNum = getRoundNum;
        boolean judgeTrue = true;
        while (!groupMap.containsValue(roundNum)) {
            roundNum -= 1;
        }
        return roundNum;
    }


    public static String[] findWinner(HashMap groupMap, String[] groupName, int roundNum) {
        //list에 몇명이 들어갈지 모름. 사이즈만큼 String 배열 만들고
        // 배열만큼 쉼표 넣어서 구분지어서 승리자 출력
        List<String> winnerList = new ArrayList<>();
        for (String name : groupName) {
            if (groupMap.get(name) == (Integer) roundNum) {
                winnerList.add(name);
            }
        }
        String[] winnerGroup = new String[winnerList.size()];
        for(int i = 0; i <winnerList.size();i++){
            winnerGroup[i] = winnerList.get(i);
        }
        return winnerGroup;
    }

    public static void showWinner(String[] winnerGroup) {
        System.out.print("최종 우승자 : "); // static final 로 상수화 꼭 시켜주는 작업해주기
        if (winnerGroup.length == 1) {
            System.out.println(winnerGroup[0]);
        } else {
            System.out.print(winnerGroup[0]);
            for(int i =1;i<winnerGroup.length;i++){
                System.out.print(", "+winnerGroup[i]);
            }
        }
    }
}




