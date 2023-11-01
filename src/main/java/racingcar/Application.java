package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {
        // TODO: 자동차 이름 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] cars = Console.readLine().split(",");

        int carsNum = cars.length;

        // TODO: StringBuilder 초기화
        StringBuilder[] forwardCount = new StringBuilder[carsNum];
        for (int l = 0; l < carsNum; l++) {
            forwardCount[l] = new StringBuilder();
        }

        int[] forwardCountInt = new int[carsNum];

        // TODO: 시도할 회수 입력 받기
        System.out.println("시도할 회수는 몇회인가요?");
        int gameCount = Integer.parseInt(Console.readLine());

        // TODO: 전진 및 멈춤 로직
        for (int i = 0; i < gameCount; i++) {

            // TODO: 경주차 개수에 따른 랜덤 정수 생성
            int[] randomNumArray = new int[carsNum];

            for (int j = 0; j < carsNum; j++) {
                int randomNum = Randoms.pickNumberInRange(0, 9);
                randomNumArray[j] = randomNum;
            }

            // TODO: 랜덤값이 4 이상이면 전진
            for (int k = 0; k < carsNum; k++) {
                if (randomNumArray[k] >= 4) {
                    forwardCount[k].append("-");
                    forwardCountInt[k]++;
                }
            }
        }

        // TODO: 전진 "-" 개수 비교
        int maxCount = 0;
        List<String> maxCountCars = new ArrayList<>();

        for (int i = 0; i < forwardCountInt.length; i++) {
            if (forwardCountInt[i] > maxCount) {
                maxCount = forwardCountInt[i];
                maxCountCars.clear();
                maxCountCars.add(cars[i]);
            }
            else if (forwardCountInt[i] == maxCount) {
                maxCountCars.add(cars[i]);
            }
        }

        // TODO: 실행 결과
        System.out.println("실행 결과");
        for (int f = 0; f < carsNum; f++) {
            System.out.print(cars[f]);
            System.out.print(" : ");
            System.out.println(forwardCount[f]);
        }

        // TODO: 우승자 출력
        if (!maxCountCars.isEmpty()) {
            System.out.print("최종 우승자 : ");
            for (int i = 0; i < maxCountCars.size(); i++) {
                System.out.print(maxCountCars.get(i));
                if (i < maxCountCars.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
}
