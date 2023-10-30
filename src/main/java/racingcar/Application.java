package racingcar;

import camp.nextstep.edu.missionutils.Console;

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

        // TODO 2. 시도 횟수 입력

        // TODO 3. 앞으로 간 거리("-")를 저장할 배열 생성

        // TODO 4. 한줄 띄어쓰기

        // TODO 5. for문을 사용해 n회 게임 반복

        // TODO 6. 최종 우승자 출력
    }
}
