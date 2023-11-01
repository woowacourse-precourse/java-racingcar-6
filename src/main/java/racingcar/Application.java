package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static String[] carName;

    public static void main(String[] args) {
        int number = input();
        race(number);
    }

    public static int input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return splitName(readLine());
    }

    public static int splitName(String inputname) {
        carName = inputname.split(",");
        int Number_of_races = 0;

        for(int i = 0; i < carName.length; i++) {
            if(carName[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
        }

        if (carName.length == 0 || carName.length == 1) {
            input();
        } else {
            System.out.println("시도할 회수는 몇회인가요?");

            try {
                Number_of_races = Integer.parseInt(readLine());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력입니다");
            }
        }

        return Number_of_races;
    }

    private static void race(int number) {
        // 배열 크기를 지정합니다.
        int random;
        int[] score = new int[carName.length];

        for (int i = 0; i < score.length; i++) {
            score[i] = 0;
        }

        System.out.println("\n 실행 결과");
        for(int i = 0; i < number; i++){
            racescore(score);
            System.out.println();
        }

        result(score);
    }

    private static int[] racescore(int[] score) {
        int random;

        for (int j = 0; j < carName.length; j++) {
            random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                score[j]++;
            }
            System.out.print(carName[j] + " : ");
            for (int k = 0; k < score[j]; k++) {
                System.out.print("-");
            }
            System.out.println();
        }

        return score;
    }

    private static void result(int[] score) {
        int max = 0;
        String winner = "";

        for (int i = 0; i < score.length; i++) {
            if (max < score[i]) {
                max = score[i];
            }
        }

        for (int i = 0; i < score.length; i++) {
            if (max == score[i]) {
                winner += carName[i] + ", ";
            }
        }

        System.out.println("최종 우승자 : " + winner.substring(0, winner.length() - 2));
    }

}
