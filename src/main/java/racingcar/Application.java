package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        Map<String, String> raceTrack = inputCarNames();
        int roundNum = inputRoundNum();
        carRace(raceTrack, roundNum);
        printWinner(raceTrack);
    }

    public static Map<String, String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        String[] carNameList = carNames.split(",");
        Map<String, String> raceTrack = new HashMap<>();

        for (String carName : carNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            raceTrack.put(carName, "");
        }

        return raceTrack;
    }

    public static int inputRoundNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        int roundNum;
        try{
            roundNum = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return roundNum;
    }

    public static void carRace(Map<String, String> raceTrack, int roundNum) {
        System.out.println(" ");
        System.out.println("실행 결과");

        for (int i = 0; i < roundNum; i++) {
            for (String car : raceTrack.keySet()) {
                int createNum = Randoms.pickNumberInRange(0, 9);
                if (createNum >= 4) {
                    String currentValue = raceTrack.get(car);
                    currentValue += '-';
                    raceTrack.put(car, currentValue);
                }
                System.out.println(car + " : " + raceTrack.get(car));
            }
            System.out.println(" ");
        }
    }

    public static void printWinner(Map<String, String> raceTrack){
        int longestCarLength = 0;
        List<String> winners = new ArrayList<>();

        for (String car : raceTrack.keySet()) {
            int carLength = raceTrack.get(car).length();
            if (carLength > longestCarLength) {
                longestCarLength = carLength;
                winners.clear();
                winners.add(car);
            } else if (carLength == longestCarLength) {
                winners.add(car);
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
