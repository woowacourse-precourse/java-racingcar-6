package racingcar;
import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {


    public static void main(String[] args) {
        inputCarInformation();
        inputTryCount();
        determineForwardMovementCount();
        printWinner();
    }

    static List<String> inputCarNameList = new ArrayList<>();
    static String inputTryNum;
    static List<Integer> forwardCountsList = new ArrayList<>();
    static String inputCarName;
    // 자동차 이름 입력 받기
    static void inputCarInformation() {
        printCarNameInputPrompt();
        getCarNamesFromUser(Console.readLine());
        changeCarNameToList();
        validateCarNames();
    }

    static void getCarNamesFromUser(String input) {
        inputCarName = input;
    }

    static void printCarNameInputPrompt() {
        System.out.printf("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)%n");
    }

    static void changeCarNameToList() {
        String[] inputCarNameArray = inputCarName.split(",");
        inputCarNameList = Arrays.asList(inputCarNameArray);
    }

    static void validateCarNames() {
        for (String checkCarNameLength : inputCarNameList) {
            // 예외처리 1 : 5글자 이하만 자동차 이름으로 입력 가능
            if (checkCarNameLength.length() > 5) {
                throw new IllegalArgumentException("5글자 이하의 이름만 입력 가능합니다.");
            }
        }
        // 예외처리 2 : 자동차 이름이 중복되지 않아야 함
        Set<String> checkDuplication = new HashSet<String>(inputCarNameList);
        if (checkDuplication.size() != inputCarNameList.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    //시도 회수 입력 받기
    static void inputTryCount() {
        printTryNumInputPrompt();
        getTryNumFromUser();
        validateTryNum();
    }

    static void printTryNumInputPrompt() {
        System.out.printf("시도할 회수는 몇회인가요?%n");
    }

    static void getTryNumFromUser() {
        inputTryNum = Console.readLine();
    }

    static void validateTryNum() {
        for (int i = 0; i < inputTryNum.length(); i++) {
            char checkInputTryNum = inputTryNum.charAt(i);
            // 예외처리 1 : 입력 값 0으로 시작 불가 (+ 시도값 0 입력 불가)
            if (inputTryNum.charAt(0) == '0') {
                throw new IllegalArgumentException("입력 값이 0으로 시작할 수 없습니다.");
            }
            // 예외처리 2 : 숫자 형식만 입력 가능
            if (checkInputTryNum < '0' || checkInputTryNum > '9') {
                throw new IllegalArgumentException("숫자형식만 입력 가능합니다.");
            }
        }
    }

    static int carNameListIndex;
    static int forwardCounts = 0;
    static String FOR_WARD_MARK = "-";

    // 전진 회수 결정하기 + 각 자동차의 결과 출력
    static void determineForwardMovementCount() {
        initializeForwardCountsList();
        System.out.printf("%n실행 결과");
        for (int i = 0; i < Integer.parseInt(inputTryNum); i++) {
            updateForwardCountsBasedOnRandom();
        }
        System.out.printf("%n");
    }

    static void initializeForwardCountsList() {
        while (forwardCountsList.size() < inputCarNameList.size()) {
            forwardCountsList.add(0); //각 플레이어의 전진 성공 회수를 저장하는 리스트 생성
        }
    }

    static void updateForwardCountsBasedOnRandom() {
        for (carNameListIndex = 0; carNameListIndex < inputCarNameList.size(); carNameListIndex++) {
            int RandomNum = Randoms.pickNumberInRange(0, 9);
            if (RandomNum >= 4) {
                forwardCounts = forwardCountsList.get(carNameListIndex) + 1;
            }
            if (RandomNum < 4) {
                forwardCounts = forwardCountsList.get(carNameListIndex);
            }
            System.out.printf("%n%s : ", inputCarNameList.get(carNameListIndex));
            displayCarProgress();
        }
        System.out.printf("%n");
    }

    static void displayCarProgress() {
        for (int k = 0; k < forwardCounts; k++) {
            System.out.printf("%s", FOR_WARD_MARK);
        }
        forwardCountsList.set(carNameListIndex, forwardCounts);
        forwardCounts = 0;
    }

    // 우승자 출력하기
    static int winnerForwardNum;
    static List<String> winnerList = new ArrayList<>();
    int winningCarCount;

    static void printWinner() {
        getWinnerForwardNum();
        getWinnerList();
        printWinnerMessage();
    }

    static void getWinnerForwardNum() {
        for (int elementForwardCountsList : forwardCountsList) {
            if (winnerForwardNum < elementForwardCountsList) {
                winnerForwardNum = elementForwardCountsList;
            }
        }
    }

    static void getWinnerList() {
        //int winningCarCount = 0;
        for (int i = 0; i < forwardCountsList.size(); i++) {
            if (forwardCountsList.get(i).equals(winnerForwardNum)) {
                winnerList.add(inputCarNameList.get(i));
            }
        }
    }

    static void printWinnerMessage() {
        String winnerListToMessage = String.join(", ", winnerList);
        String winnerMessage = "최종 우승자 : " + winnerListToMessage + "%n";
        System.out.printf(winnerMessage);
    }
}




