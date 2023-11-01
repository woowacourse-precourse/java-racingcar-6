package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        String[] racingCar = getCarNames();
        int attempt = getAttemptCount();

        List<String> racingCarProgress = new ArrayList<>(Collections.nCopies(racingCar.length, ""));

        System.out.println("실행 결과");
        playGame(racingCar, racingCarProgress, attempt);

        List<String> winners = findWinners(racingCar, racingCarProgress);
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }

    private static void playGame(String[] racingCar, List<String> racingCarProgress, int attempt) {
        for (int i = 0; i < attempt; i++) {
            updateCarProgress(racingCar, racingCarProgress);
            printProgress(racingCar, racingCarProgress);
        }
    }

    private static void updateCarProgress(String[] racingCar, List<String> racingCarProgress) {
        for (int j = 0; j < racingCar.length; j++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                racingCarProgress.set(j, racingCarProgress.get(j) + "-");
            }
        }
    }

    private static void printProgress(String[] racingCar, List<String> racingCarProgress) {
        for (int j = 0; j < racingCar.length; j++) {
            System.out.print(racingCar[j] + " : ");
            System.out.println(racingCarProgress.get(j));
        }
        System.out.println();
    }

    private static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        String[] racingCar = carName.split(",");
        validateCarNames(racingCar);
        return racingCar;
    }

    private static void validateCarNames(String[] racingCar) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(racingCar));
        if (uniqueNames.size() != racingCar.length || Arrays.stream(racingCar).anyMatch(name -> name.trim().isEmpty() || name.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름을 올바르게 입력해주세요.");
        }
    }

    private static int getAttemptCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        String inputNumber = Console.readLine();
        int attempt = Integer.parseInt(inputNumber);
        validateAttemptCount(attempt);
        return attempt;
    }

    private static void validateAttemptCount(int attempt) {
        if (attempt <= 0 || attempt > 200) {
            throw new IllegalArgumentException("시도 횟수는 1부터 200 사이의 양의 정수로 입력해주세요.");
        }
    }

    private static List<String> findWinners(String[] racingCar, List<String> racingCarProgress) {
        int maxProgress = Collections.max(racingCarProgress, Comparator.comparing(String::length)).length();
        List<String> winners = IntStream.range(0, racingCar.length)
                .filter(i -> racingCarProgress.get(i).length() == maxProgress)
                .mapToObj(i -> racingCar[i])
                .collect(Collectors.toList());
        return winners;
    }
}
