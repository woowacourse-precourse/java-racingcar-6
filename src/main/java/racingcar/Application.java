package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        // TODO: 자동차 이름 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] cars = Console.readLine().split(",");

        // TODO: 시도할 회수 입력 받기
        System.out.println("시도할 회수는 몇회인가요?");
        int gameCount = Integer.parseInt(Console.readLine());

        // TODO: 전진 및 멈춤 로직
        for (int i = 0; i < gameCount; i++) {

            // TODO: 경주차 개수에 따른 랜덤 정수 생성
            int carsNum = cars.length;
            int[] randomNumArray = new int[carsNum];

            for (int j = 0; j < carsNum; j++) {
                int randomNum = Randoms.pickNumberInRange(0,9);
                randomNumArray[j] = randomNum;
            }
        }

        // TODO: 실행 결과 출력

        // TODO: 우승자 출력
    }
}
