package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateInput(input);

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = 0;
        try {
            tryCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        String[] participants = input.split(",");
        validateLength(participants);

        int[] raceDistance = new int[participants.length];
        int winnerDistance = 0;
        String[] raceDistanceByHyphen = new String[participants.length];
        Arrays.fill(raceDistanceByHyphen, "");

        for (int i = 0; i < tryCount; i++) {
            raceProceed(participants, raceDistance, raceDistanceByHyphen);
            for (int k = 0; k < participants.length; k++) {
                winnerDistance = Math.max(winnerDistance, raceDistance[k]);
                System.out.println(participants[k] + " : " + raceDistanceByHyphen[k]);
            }
            System.out.println();
        }

        String winners = "";

        for (int l = 0; l < participants.length; l++) {
            if (raceDistance[l] == winnerDistance && winners.equals("")) {
                winners += participants[l];
            } else if (raceDistance[l] == winnerDistance && !winners.equals("")) {
                winners += ", ";
                winners += participants[l];
            }
        }

        System.out.println("최종 우승자 : " + winners);

    }

    public static boolean goOrStop() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public static void validateInput(String input) {
        //사용자의 입력이 "," 혹은 알파벳이 아니면 IllegalArgumentException 발생
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isAlphabetic(input.charAt(i)) && input.charAt(i) != ',') {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateLength(String[] participants) {
        //자동차 이름이 5자를 넘어가면 IllegalArgumentException 발생
        for (int i = 0; i < participants.length; i++) {
            if (participants[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void raceProceed(String[] participants, int[] raceDistance, String[] raceDistanceByHyphen) {
        for (int j = 0; j < participants.length; j++) {
            if (goOrStop()) {
                raceDistance[j] = raceDistance[j] + 1;
                raceDistanceByHyphen[j] += "-";
            }
        }
    }
}
