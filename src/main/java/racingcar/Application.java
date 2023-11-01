package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] carNames = inputCarNames(); //사용자로부터 입력받기
        int tryCount = inputTryCount();

        // 경주 게임 실행
        RacingGameResult result = playGame(carNames, tryCount);

        // 결과 출력
        printResult(result);
    }

    private static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");//,로 구분

        // 자동차 이름 유효성 검사
        //carName을 순회하면서 각 자동차 이름의 길이가 5를 초과하는 경우(5이상의 이름을 가진 자동차가 있다면) 예외발생 종료
        //향상된 for 문 사용
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }

    private static int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine(); //사용자 입력

        // 입력값 유효성 검사
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static RacingGameResult playGame(String[] carNames, int tryCount) {
        RacingGameResult result = new RacingGameResult(carNames);

        for (int i = 0; i < tryCount; i++) {
            result.moveCars();
            System.out.println(result.getRoundResult());
        }
        return result;
    }

    private static void printResult(RacingGameResult result) {
        System.out.println("최종 우승자 : " + result.getWinners());
    }
}

class RacingGameResult {
    private final String[] carNames;
    private final int[] positions;
    private final int maxPosition;

    public RacingGameResult(String[] carNames) {
        this.carNames = carNames;
        this.positions = new int[carNames.length];
        this.maxPosition = carNames.length - 1;
    }

    //랜덤값 추출은 picNumber을 활용하여 추출 한다.
    //0에서 9까지의 정수 중 한개의 정수 반환 -> Randoms.pickNumberInRange(0,9);
    public void moveCars() {
        for (int i = 0; i < carNames.length; i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                positions[i]++;
            }
        }
    }

    public String getRoundResult() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < carNames.length; i++) {
            result.append(carNames[i]).append(" : ");
            for (int j = 0; j <= maxPosition; j++) {
                result.append(positions[i] > j ? "-" : "");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public String getWinners() {
        int maxPosition = 0;
        for (int position : positions) {
            maxPosition = Math.max(maxPosition, position);
        }

        StringBuilder winners = new StringBuilder();
        for (int i = 0; i < carNames.length; i++) {
            if (positions[i] == maxPosition) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(carNames[i]);
            }
        }

        return winners.toString();
    }
}
