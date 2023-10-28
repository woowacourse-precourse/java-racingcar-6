package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.StringTokenizer;

public class Application {
    private static final int INIT_DISTANCE = 0;
    private static final int MOVING_FORWARD = 4;
    private static final String GAME_RESULT = "\n실행 결과";

    public static void main(String[] args) {
        Map<String, Integer> memberStates = new LinkedHashMap<>();

        List<String> winner = new ArrayList<>();

        memberStates = getMemberState();

        int tryCount = getTryCount();

        System.out.println(GAME_RESULT);

        gameStart(tryCount, memberStates);

        winner = getWinner(memberStates);

        printWinnerView(winner);
    }

    public static Map<String, Integer> getMemberState() {
        // HashMap의 순서를 보장하기 위해 LinkedHashMap 사용
        Map<String, Integer> memberStates = new LinkedHashMap<>();
        String memberInput = carNameInputView();
        StringTokenizer stringTokenizer = new StringTokenizer(memberInput, ",");
        while (stringTokenizer.hasMoreTokens()) {
            String name = stringTokenizer.nextToken();
            nameException(name);
            memberStates.put(name, INIT_DISTANCE);
        }

        return memberStates;
    }

    public static String carNameInputView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String memberInput = Console.readLine();
        return memberInput;
    }

    public static void nameException(String name) {
        // * 이름 예외 처리
        // 이름 5자 이하가 아닐 경우
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryInput = Console.readLine();
        int tryCount = Integer.parseInt(tryInput);

        tryCountException(tryCount);

        return tryCount;
    }

    public static void tryCountException(int tryCount) {
        // * 시도 횟수 예외 처리
        // 입력 값이 숫자가 아닌 경우
        if (Character.isDigit(tryCount)) {
            throw new IllegalArgumentException();
        }

        // 입력 값이 0 이하인 경우
        if (tryCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void gameStart(int tryCount, Map<String, Integer> memberStates) {
        // 게임 시작
        for (int i = 0; i < tryCount; i++) {
            memberStates = startEachGame(memberStates);
            printEachGameResultView(memberStates);
            System.out.println();
        }
    }

    public static Map<String, Integer> startEachGame(Map<String, Integer> memberStates) {
        // 한 차수씩 시작
        for (String name : memberStates.keySet()) {

            // 무작위 값 뽑기
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            // 전진할 경우
            if (randomNumber >= MOVING_FORWARD) {
                memberStates.replace(name, memberStates.get(name) + 1);
            }
        }
        return memberStates;
    }

    public static void printEachGameResultView(Map<String, Integer> memberStates) {
        for (String name : memberStates.keySet()) {
            // 각 차수별 실행 결과
            System.out.println(name + " : " + changeDash(memberStates.get(name)));
        }
    }

    // 이동거리를 대쉬(-)로 변경
    public static StringBuilder changeDash(int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        String dash = "-";
        for (int i = 0; i < distance; i++) {
            stringBuilder.append(dash);
        }

        return stringBuilder;
    }

    public static List<String> getWinner(Map<String, Integer> memberStates) {
        // 최종 우승자 결정

        // 최대 이동값 구하기
        int maxNumber = getMaxNumber(memberStates);
        List<String> winner = new ArrayList<>();
        for (String name : memberStates.keySet()) {
            if (memberStates.get(name) == maxNumber) {
                winner.add(name);
            }
        }

        return winner;
    }

    public static int getMaxNumber(Map<String, Integer> memberStates) {
        int maxNumber = 0;
        for (String name : memberStates.keySet()) {
            if (memberStates.get(name) > maxNumber) {
                maxNumber = memberStates.get(name);
            }
        }
        return maxNumber;
    }

    public static void printWinnerView(List<String> winner) {
        // 결과 출력
        String result = String.join(",", winner);
        System.out.println("최종 우승자 : " + result);
    }
}