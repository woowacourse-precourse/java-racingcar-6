package racingcar;

import camp.nextstep.edu.missionutils.Console;
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

        // TODO 5. for문을 사용해 n회 게임 반복


        // TODO 6. 최종 우승자 출력
    }
}
