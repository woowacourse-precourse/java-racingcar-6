package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        Application T = new Application();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingCar = Console.readLine();
        List<String> racingCarName = T.listConversion(racingCar);

        System.out.println("시도할 회수는 몇회인가요?");
        String gameNumString = Console.readLine();

        if (!isValidNum(gameNumString)) {
            throw new IllegalArgumentException("올바른 회수 입력이 아닙니다.");
        }
        System.out.println();
        System.out.println("실행 결과");

        int gameNum = Integer.valueOf(gameNumString);
        List<String>[] makeDash = T.forward(racingCarName, gameNum);
        T.printRacing(racingCarName, gameNum, makeDash);
    }

    public static List<String> listConversion(String racingCar) throws IllegalArgumentException {
        List<String> racer = new ArrayList<String>();
        String[] splitStr = racingCar.split(",");

        for (int i = 0; i < splitStr.length; i++) {
            racer.add(splitStr[i]);

            if (!isValidName(splitStr[i])) {
                throw new IllegalArgumentException("올바른 자동차 이름이 아닙니다.");
            }
        }

        return racer;
    }

    public static int randomNum() {
        int randomNum = Randoms.pickNumberInRange(0, 9);

        return randomNum;
    }

    public static String judgeForward() {
        int judgeRandomNum = randomNum();

        if (judgeRandomNum >= 4) {
            return "-";
        } else {
            return "";
        }
    }

    public static List<String>[] forward(List<String> racingCarName, int gameNum) {
        List<String>[] forwardNum = new ArrayList[racingCarName.size()];
        String dashSum = "";

        for (int i = 0; i < racingCarName.size(); i++) {
            forwardNum[i] = new ArrayList<>();
        }

        for (int i = 0; i < racingCarName.size(); i++) {
            dashSum = "";
            for (int j = 0; j < gameNum; j++) {
                dashSum += judgeForward();
                forwardNum[i].add(dashSum);
            }
        }
        return forwardNum;
    }

    public static void printRacing(List<String> racingCarName, int gameNum, List<String>[] makeDash) {
        for (int i = 0; i < gameNum; i++) {
            for (int j = 0; j < racingCarName.size(); j++) {
                System.out.println(racingCarName.get(j) + " : " + makeDash[j].get(i));
            }
            System.out.println();
        }
        printWinner(racingCarName, gameNum, makeDash);
    }

    public static void printWinner(List<String> racingCarName, int gameNum, List<String>[] makeDash) {
        int max = Integer.MIN_VALUE;
        List<String> winCarName = new ArrayList<>();

        for (int i = 0; i < racingCarName.size(); i++) {
            if (makeDash[i].get(gameNum - 1).length() > max) {
                max = makeDash[i].get(gameNum - 1).length();
            }
        }

        for (int i = 0; i < racingCarName.size(); i++) {
            if (max == makeDash[i].get(gameNum - 1).length()) {
                winCarName.add(String.valueOf(racingCarName.get(i)));
            }
        }

        String result = String.join(", ", winCarName);
        System.out.println("최종 우승자 : " + result);
    }

    public static boolean isValidName(String splitStr) {
        if (splitStr.length() > 5) {
            return false;
        }

        return true;
    }

    public static boolean isValidNum(String gameNumString) {
        for (int i = 0; i < gameNumString.length(); i++) {
            if (!Character.isDigit(gameNumString.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
