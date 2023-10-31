package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {

    public static boolean isMove(List<Integer> carsMovedDistance, int index) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            carsMovedDistance.set(index, carsMovedDistance.get(index) + 1);
            return true;
        }
        return false;
    }

    public static String printCarMovedDistance(List<Integer> carsMovedDistance, int index) {
        String MovedDistance = "-".repeat(carsMovedDistance.get(index));
        return MovedDistance;
    }

    public static void printWinners(List<String> cars, List<Integer> carsMovedDistance) {
        List<Integer> winners = findIndicesOfMaxDistance(carsMovedDistance);
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(cars.get(winners.get(i)));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    public static List<Integer> findIndicesOfMaxDistance(List<Integer> carsMovedDistance) {
        int maxDistance = Collections.max(carsMovedDistance);

        List<Integer> maxDistanceIndics = new ArrayList<>();
        for (int i = 0; i < carsMovedDistance.size(); i++) {
            if (carsMovedDistance.get(i).equals(maxDistance)) {
                maxDistanceIndics.add(i);
            }
        }
        return maxDistanceIndics;
    }

    public static void checkNameValidation(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("잘못된 입력입니다. 프로그램을 종료합니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = Arrays.asList(camp.nextstep.edu.missionutils.Console.readLine().split(","));
        for (int i = 0; i < cars.size(); i++) {
            checkNameValidation(cars.get(i));
        }
        List<Integer> carsMovedDistance = new ArrayList<>(Collections.nCopies(cars.size(), 0));
        System.out.println("시도할 회수는 몇회인가요?");
        int testNumber = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        System.out.println("\n실행결과");

        while (testNumber > 0) {
            for (int i = 0; i < cars.size(); i++) {
                isMove(carsMovedDistance, i);
                System.out.println(cars.get(i) + " : " + printCarMovedDistance(carsMovedDistance, i));
            }
            System.out.println();
            testNumber--;
        }
        printWinners(cars, carsMovedDistance);
    }
}