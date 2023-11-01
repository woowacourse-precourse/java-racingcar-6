package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {
        String[] carName = inputCars();
        int tryCount = tryCnt();
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            isMove(carName);
        }

        printResult(carName);
    }

    public static String[] inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표로 구분해 주세요");
        }
        String[] carNames = input.split(",");

        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() >= 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해 주세요");
            }
            if (!isOnlyAlphabet(carNames[i])) {
                throw new IllegalArgumentException("자동차 이름은 영어로만 이루어져야 합니다");
            }
        }
        return carNames;
    }

    public static boolean isOnlyAlphabet(String input) {
        for (int i = 0; i < input.length(); i++) {
            char carName = input.charAt(i);
            if (!(carName >= 'A' && carName <= 'Z') && !(carName >= 'a' && carName <= 'z')) {
                return false;
            }
        }
        return true;
    }

    public static int tryCnt() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static boolean isGo() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public static void isMove(String[] carName) {
        for (int i = 0; i < carName.length; i++) {
            if (isGo()) {
                System.out.print(carName[i] + " : -");
            } else {
                System.out.print(carName[i] + " : ");
            }
        }
        System.out.println();
    }

    public static int getWinner(String[] carName) {
        int biggestAdvance = 0;
        for (int i = 0; i < carName.length; i++) {
            if (biggestAdvance < carName[i].length()) {
                biggestAdvance = carName[i].length();
            }
        }
        return biggestAdvance;
    }

    public static void printResult(String[] carName) {
        int biggestAdvance = getWinner(carName);
        StringBuilder winners = new StringBuilder();

        for (int i = 0; i < carName.length; i++) {
            if (biggestAdvance == carName[i].length()) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(carName[i]);
            }
        }
        System.out.println("최종 우승자 : " + winners);
    }
}
