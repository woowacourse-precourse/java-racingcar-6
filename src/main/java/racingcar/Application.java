package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static String carString;
    private static int tryNum;
    private static int size;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        init();     // 자동차 이름 입력, 시도할 횟수 입력

        String[] carArray = changeToCarArr();       // 자동차 이름 분리 저장할 배열
        String[] raceResultArr = new String[carArray.length];        // 자동차 경주 실행 결과 저장할 배열

        carRace(carArray, raceResultArr);       // 자동차 경주 실행 결과 저장 및 출력

        whoIsWinner(carArray, raceResultArr);       // 우승자 출력
    }

    public static void init() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carString = Console.readLine();
        if (!checkCarLength(carString)) {
            throw new IllegalArgumentException();
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        String tryString = Console.readLine();
        tryNum = Integer.parseInt(tryString);
        System.out.println();
    }

    public static boolean checkCarLength(String carString) {
        String[] carSplit = carString.split(",");
        for (String c : carSplit) {
            if (c.length() > 5) {
                return false;
            }
        }

        return true;
    }

    public static String[] changeToCarArr() {
        return carString.split(",");
    }

    public static void carRace(String[] carArray, String[] raceResultArr) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryNum; i++) {
            saveResult(raceResultArr);
            printResult(carArray, raceResultArr);
            System.out.println();
        }
    }

    public static void printResult(String[] carArray, String[] raceResultArr) {
        for (int j = 0; j < raceResultArr.length; j++) {
            if (raceResultArr[j] == null) {
                raceResultArr[j] = "";
            }
            System.out.println(carArray[j] + " : " + raceResultArr[j]);
        }
    }

    public static void saveResult(String[] raceResultArr) {
        for (int i = 0; i < raceResultArr.length; i++) {
            int car = Randoms.pickNumberInRange(0, 9);

            if (!checkForward(car)) {
                continue;
            }

            if (raceResultArr[i] == null) {
                raceResultArr[i] = "-";
            } else {
                raceResultArr[i] += "-";
            }
        }
    }

    public static boolean checkForward(int car) {
        if (car < 4) {
            return false;
        }
        return true;
    }

    public static void whoIsWinner(String[] carArray, String[] raceResultArr) {
        System.out.print("최종 우승자 : ");
        List<String> winnerList = new ArrayList<>();

        checkMaxSize(raceResultArr);

        saveWinner(carArray, raceResultArr, winnerList);

        printWinner(winnerList);
    }

    public static void saveWinner(String[] carArray, String[] raceResultArr, List<String> winnerList) {
        for (int i = 0; i < raceResultArr.length; i++) {
            if (raceResultArr[i].length() == size) {
                winnerList.add(carArray[i]);
            }
        }
    }

    public static void printWinner(List<String> winnerList) {
        if (winnerList.size() > 1) {
            moreThanOneWinner(winnerList);
        }
        System.out.println(winnerList.get(0));
    }

    public static void moreThanOneWinner(List<String> winnerList) {
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i));
            if (i != winnerList.size()) {
                System.out.print(", ");
            }
        }
    }

    public static void checkMaxSize(String[] raceResultArr) {
        size = -1;
        for (int i = 0; i < raceResultArr.length; i++) {
            if (raceResultArr[i].length() > size) {
                size = raceResultArr[i].length();
            }
        }
    }
}
