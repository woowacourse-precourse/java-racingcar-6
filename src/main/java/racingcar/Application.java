package racingcar;
import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력 받기
        System.out.printf("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)%n");
        String inputCarName = Console.readLine();
        String[] inputCarNameArray = inputCarName.split(",");
        List<String> inputCarNameList = new ArrayList<>();
        inputCarNameList = Arrays.asList(inputCarNameArray);
        for (String checkCarNameLength : inputCarNameList) {
            //예외처리 1 : 5글자 이하만 자동차 이름으로 입력 가능
            if (checkCarNameLength.length() > 5) {
                throw new IllegalArgumentException("5글자 이하의 이름만 입력 가능합니다.");
            }
        }
        // 예외처리 2 : 자동차 이름이 중복되지 않아야 함
        Set<String> checkDuplication = new HashSet<String>(inputCarNameList);
        if (checkDuplication.size() != inputCarNameList.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }

        //시도 회수 입력 받기a
        System.out.printf("시도할 회수는 몇회인가요?%n");
        String inputTryNum = Console.readLine();
        for (int i=0; i < inputTryNum.length(); i++) {
            char checkInputTryNum = inputTryNum.charAt(i);
            if (inputTryNum.charAt(0) == '0') {
                throw new IllegalArgumentException("값이 0으로 시작할 수 없습니다.");
            }
            if (checkInputTryNum < '0' || checkInputTryNum > '9') {
                throw new IllegalArgumentException("숫자형식만 입력 가능합니다.");
            }
        }


        // 전진 회수 결정하기 ( 차마다 다름 )
        int forwardCounts = 0;
        String forwardMark = "-";
        List<Integer> forwardCountsList = new ArrayList<>();

        while (forwardCountsList.size() < inputCarNameList.size()) {
            forwardCountsList.add(0);
        }
        System.out.printf("%n실행 결과");
        for (int i=0; i < Integer.parseInt(inputTryNum); i++) {
            for (int j=0; j < inputCarNameList.size(); j++) {
                int RandomNum = Randoms.pickNumberInRange(0, 9);
                if (RandomNum >= 4) {
                    forwardCounts = forwardCountsList.get(j) + 1;
                }
                if (RandomNum < 4) {
                    forwardCounts = forwardCountsList.get(j);
                }
                System.out.printf("%n%s : ", inputCarNameList.get(j));
                for (int k = 0; k < forwardCounts; k++) {
                    System.out.printf("%s", forwardMark);
                }
                forwardCountsList.set(j, forwardCounts);
                forwardCounts = 0;
                for (int k = 0; k < inputCarNameList.size(); k++) {
                }
            }
            System.out.printf("%n");
        }

        // 우승자 출력하기
        int winnerForwardNum = 0;
        for (int elementForwardCountsList : forwardCountsList) {
            if (winnerForwardNum < elementForwardCountsList) {
                winnerForwardNum = elementForwardCountsList;
            }
        }
        int winningCarCount = 0;
        List<String> winnerList = new ArrayList<>();
        for (int i=0; i < forwardCountsList.size(); i++) {
            if (forwardCountsList.get(i).equals(winnerForwardNum)) {
                winnerList.add(inputCarNameList.get(i));
            }
        }
        String winnerListToMessage = String.join(", ", winnerList);
        String winnerMessage = "%n최종 우승자 : " + winnerListToMessage + "%n";
        System.out.printf(winnerMessage);
    }
}
