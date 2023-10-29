package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    public List<String> inputCarName() {  // checkInput 구현시 수정 필요
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputStr = Console.readLine();
        inputStr = inputStr.replace(" ", "");
        String[] inputArr = inputStr.split(",");
        List<String> nameList = Arrays.asList(inputArr);
        checkInput(nameList);
        return nameList;
    }

    public int inputCountNum() { // checkInput 구현시 수정 필요
        System.out.println("시도할 회수는 몇회인가요?");
        String inputStr = Console.readLine();
        int count;
        try {
            count = Integer.parseInt(inputStr);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        checkInput(count);
        return count;
    }

    public int getRandomNum() {
        int ranNum = Randoms.pickNumberInRange(0, 9);
        return ranNum;
    }


    public int forwardOrStop(int ranNum) {// 전진이면 1을 반환, 정지면 0을 반환
        if (ranNum >= 4) {
            return 1;
        } else {
            return 0;
        }
    }

    public void getDistanceList(List<String> nameList,
                                List<Integer> distanceList) { // 이전까지의 이동 거리에 이번 회차 이동 거리 더하기
        System.out.println("실행 결과");
        for (int i = 0; i < nameList.size(); i++) {
            System.out.print(nameList.get(i) + " : ");
            int ranNum = getRandomNum();
            int move = forwardOrStop(ranNum);
            for (int j = 0; j < distanceList.get(i); j++) {
                System.out.print("-");
            }
            if (move == 1) {
                System.out.print("-");
                distanceList.set(i, distanceList.get(i) + 1);
            }
            System.out.println();
        }
    }

    public List<Integer> runAllCycle(List<String> nameList, int count) {
        List<Integer> distanceList = new ArrayList<>();
        for (int i = 0; i < nameList.size(); i++) { // 처음 이동 거리는 모두 0
            distanceList.add(0);
        }
        for (int j = 0; j < count; j++) {
            getDistanceList(nameList, distanceList);
            System.out.println();
        }
        return distanceList;
    }

    public int findMax(List<Integer> distanceList) {
        int max = 0;
        for (int i : distanceList) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public List<String> chooseWinner(List<String> nameList, List<Integer> distanceList) {
        List<String> winnerList = new ArrayList<>();
        int max = findMax(distanceList);
        for (int i = 0; i < distanceList.size(); i++) {
            if (distanceList.get(i) == max) {
                String winner = nameList.get(i);
                winnerList.add(winner);
            }
        }
        return winnerList;
    }

    public String getWinnerNameString(List<String> winnerList) {
        String winnerStr = "";
        for (String name : winnerList) {
            winnerStr += "," + name;
        }
        winnerStr = winnerStr.substring(1);
        return winnerStr;
    }

    public void runGame() {
        List<String> nameList = inputCarName();
        int count = inputCountNum();
        List<Integer> distanceList = runAllCycle(nameList, count);
        List<String> winnerList = chooseWinner(nameList, distanceList);
        String winnerStr = getWinnerNameString(winnerList);
        System.out.println("최종 우승자 : " + winnerStr);
    }

    public void checkInput(List<String> nameList) {
//  사람이 아닌 차량 이름이니 특수문자가 허용될수도 있다.
        for(String name : nameList){
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkInput(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
    }
}
