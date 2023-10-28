package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
    // 자동차 이름 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] playerNames = (Console.readLine()).split(",");
        List<String> playerNameList = new ArrayList<>(Arrays.asList(playerNames));



        // 예외처리 1 ( 5글자 이하 )
        for (int i = 0; i < playerNames.length; i++) {
            if (playerNameList.get(i).length() > 5) {
                throw new IllegalArgumentException("5자 이하로 입력해주세요.");
            }
        }
        // 예외처리 2 ( 중복값 입력 불가 )
        for (int i = 0; i < playerNames.length; i++) {
            String duplicationTestElement = playerNameList.get(i);
            playerNameList.remove(playerNameList.get(i));
            if (playerNameList.contains(duplicationTestElement)) {
                throw new IllegalArgumentException("중복된 이름이 존재합니다.");
            }
            playerNameList.add(i, duplicationTestElement);

        }

    // 시도 회수 입력 받기
        System.out.println("시도할 회수는 몇회인가요?");
        String playerInputTryNum = Console.readLine();
        //int tryNumberErrorTest = playerInputTryNum.length(); //10
        for (int i = 0; i < playerInputTryNum.length(); i++) {
            // 시도 회수에 대한 예외처리
            if (playerInputTryNum.charAt(0) == '0')  // 맨 앞자리 수가 0일 수 없음
                throw new IllegalArgumentException("숫자만 입력 가능합니다.(0입력 또는 가장 앞 자리수에 0 입력이 불가합니다.)" + "");
            if (playerInputTryNum.charAt(i) < '0' || playerInputTryNum.charAt(i) > '9') {
                throw new IllegalArgumentException("숫자만 입력 가능합니다. (0 제외)");
            }
        }

    //전진 회수 결정하기 + 각 자동차의 결과 출력
        int toIntPlayerInputTryNum = Integer.parseInt(playerInputTryNum);
        int RandomNumber;
        char forwardMark = '-';

        List<Integer> playerForwardList = new ArrayList<>();
        System.out.printf("%n실행 결과%n");

        List<Integer> isForwardList = new ArrayList<>();
        //isForwardList에 플레이어 수만큼 추가 -  초기값 0으로 설정 해놓기
        for (int i = 0; i < playerNames.length; i++) {
            isForwardList.add(0);
        }

        for (int j = 0; j < toIntPlayerInputTryNum; j++) {
            for (int i = 0; i < playerNames.length; i++) {
                System.out.printf("%s : ", playerNameList.get(i));
                RandomNumber = Randoms.pickNumberInRange(0, 9);
                if (RandomNumber >= 4) {
                    isForwardList.set(i, isForwardList.get(i)+1);
                }
                for (int k = 0; k < isForwardList.get(i); k++) {
                    System.out.printf("%s", forwardMark);
                }
                System.out.printf("%n");
            }
                System.out.printf("%n");
            }

    // 우승자 출력하기
        int WinnerForwardNum = 0;
        int isForwardListmaxNum = 0;
        for (int i = 0; i < isForwardList.size(); i++) {
            if (isForwardList.get(i) >= isForwardListmaxNum) {
                isForwardListmaxNum = isForwardList.get(i);
            }
        }
        WinnerForwardNum = isForwardListmaxNum;
        List<Integer> winnerIndexList = new ArrayList<>();
        for (int i=0; i < isForwardList.size(); i++) {
            if (isForwardList.get(i).equals(isForwardListmaxNum)) {
                winnerIndexList.add(i);
            }
        }
        String winnerMessage ="최종 우승자 :";
        String winnerPlayer = "";
        for (int i=0; i < winnerIndexList.size(); i++) {
            if (i == winnerIndexList.size() - 1) {
                winnerPlayer = winnerPlayer + playerNameList.get(winnerIndexList.get(i));
            }
            else {
                winnerPlayer = winnerPlayer + playerNameList.get(winnerIndexList.get(i)) + ", ";
            }
        }
        System.out.printf("%s %s",winnerMessage, winnerPlayer);
    }
}





