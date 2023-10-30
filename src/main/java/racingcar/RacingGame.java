package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private String[] carNameList;
    private final List<String> answerList = new ArrayList<>();
    private Integer tryNumber;

    public void init() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();
        carNameList = inputCarName.split(",");
        for (String s : carNameList) {
            System.out.println(s);
        }
    }

    public void InputTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        tryNumber = Integer.parseInt(Console.readLine());
        // test code
        System.out.println("tryNumber = " + tryNumber);
    }

    public void SetAnswerList() {
        for (int i = 0; i < carNameList.length; i++) {
            answerList.add(i, " ");
        }
    }

    public void GamePlay() {
        System.out.println("실행 결과");
        for (int j = 0; j < tryNumber; j++) {
            for (int i = 0; i < carNameList.length; i++) {
                int randomint = Randoms.pickNumberInRange(0, 9);
                if (randomint > 4) {
                    answerList.set(i, answerList.get(i) + "-");
                }
            }

            for (int i = 0; i < carNameList.length; i++) {
                System.out.println(carNameList[i] + " : " + answerList.get(i));
            }
            System.out.println();
        }

    }

    public void CheckWinner() {
        int checkSize = 0;
        for (String s : answerList) {
            if (s.length() > checkSize) {
                checkSize = s.length();
            }
        }
        String answer = "최종 우승자 : ";
        for (int i = 0; i < answerList.size(); i++) {
            if (answerList.get(i).length() == checkSize) {
                answer += carNameList[i] + ", ";
            }
        }
        System.out.println(answer);

    }


}
