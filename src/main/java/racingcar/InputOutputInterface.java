package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputOutputInterface {

    public static void checkCarName(List<String> input) {
        for (String s : input) {
            if (s.isEmpty() || s.length() > 5) {
                throw new IllegalArgumentException("올바르지 않은 입력입니다.");
            }
        }
    }

    public static List<String> listenCarName() {
        String inputString = Console.readLine();
        List<String> stringList = Arrays.asList(inputString.split(","));
        checkCarName(stringList);
        return stringList;
    }

    public static void checkMovingCount(String input) {
        // 입력이 0일 경우에도 Exception 발생
        if (!input.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    public static int listenMovingCount() {
        String inputMovingCount = Console.readLine();
        checkMovingCount(inputMovingCount);
        return Integer.parseInt(inputMovingCount);
    }

    public static void printRacingCarInfo(RacingCar racingCar) {
        System.out.print(racingCar.getName() + " : ");
        for (int i = 0; i < racingCar.getLocation(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public static void printWinner(List<RacingCar> racingCarList) {
        System.out.print("최종 우승자 : ");
        System.out.print(racingCarList.get(0).getName());
        if (racingCarList.size() > 1) {
            for (int i = 1; i < racingCarList.size(); i++) {
                System.out.println(", " + racingCarList.get(i).getName());
            }
        }
        System.out.println();
    }
}
