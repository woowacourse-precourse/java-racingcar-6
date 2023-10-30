package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // 1. 자동차 입력 받기
        // 입력받은 값을 ","로 분리해 배열에 저장
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        int numberOfCars = carNames.length;
        // 2대 이상 입력했는지 검증
        Validation.carsMoreThanTwo(carNames.length);
        // 자동차 이름이 5자 이하인지 검사
        Validation.isLongName(carNames);

        // 2. 시도 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        // 정수를 입력했는지 검증
        int n = Validation.stringToIntValidation(Console.readLine());
        // n이 양수인지 검증
        Validation.isPositive(n);

        // 3. 앞으로 간 거리("-")를 저장할 배열 생성
        String[] movedDistance = new String[numberOfCars];
        Arrays.fill(movedDistance, "");

        // 4. 한줄 띄어쓰기
        System.out.println();
        System.out.println("실행 결과");

        // 5. for문을 사용해 n회 게임 반복
        for (int i = 0; i < n; i++) {
            //1. 각 자동차마다 움직일지 멈출지 판단하는 난수 생성해서 배열에 저장
            int[] howFar = GameMethods.makeRandNum(numberOfCars);

            //2. 움직일지 말지 판단해서 movedDistance배열에 "-"로 기록
            GameMethods.goOrStop(numberOfCars, movedDistance, howFar);

            //3. 출력
            for (int j = 0; j < numberOfCars; j++) {
                System.out.println(carNames[j] + " : " + movedDistance[j]);
            }
            System.out.println();
        }


        // 6. 최종 우승자 출력
        // 가장 멀리 간 사람 명단을 ArrayList에 저장.
        ArrayList<String> winningCandidate = GameMethods.decideWinner(movedDistance, carNames);

        // 우승자 이름을 출력형식에 맞게 StringBuilder에 추가
        StringBuilder winners = GameMethods.winnerPrintForm(winningCandidate);

        // 출력
        System.out.println(winners);
    }
}
