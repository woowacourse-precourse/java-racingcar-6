package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = readLine().trim();

        // validate input
        String[] inputs = carNamesInput.split(",");
        List<String> carNames = validateInput(inputs);

        // repeat
        System.out.println("시도할 회수는 몇회인가요?");
        String repeatNumber = readLine();
        validateNumber(repeatNumber);

        int repeat = Integer.parseInt(readLine());
        Map<String, Integer> carsWithResult = carsListToMap(carNames);

        // run result
        System.out.println("실행 결과");
        for (int i = 0; i < repeat; i++) {
            Map<String, Integer> carsAndWins = runCars(carsWithResult);
            printWinResult(carsAndWins);
            carsWithResult = carsAndWins;
            System.out.println();
        }

        // find max value
        Integer maxValue = Collections.max(carsWithResult.values());
        List<String> winners = getWinnerList(carsWithResult, maxValue);

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }


    public static List<String> getWinnerList(Map<String, Integer> carsAndWins, Integer max) {
        List<String> winners = new ArrayList<>();
        for (String car : carsAndWins.keySet()) {
            if (max == carsAndWins.get(car)) {
                winners.add(car);
            }
        }
        return winners;
    }

    public static Map<String, Integer> carsListToMap(List<String> cars) {
        Map<String, Integer> carAndWins = new HashMap<>();
        for (String car : cars) {
            carAndWins.put(car, 0);
        }
        return carAndWins;
    }

    public static Map<String, Integer> runCars(Map<String, Integer> carsWithWins) {
        for (String car : carsWithWins.keySet()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                Integer win = carsWithWins.get(car);
                win++;
                carsWithWins.put(car, win);
            }
        }
        return carsWithWins;
    }


    public static List<String> validateInput(String[] inputs) {
        List<String> carNames = new ArrayList<>();
        for (String input : inputs) {
            String carName = input.trim();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("CarName can not exceed over 5 character");
            }
            carNames.add(carName);
        }
        return carNames;
    }

    public static void validateNumber(String repeatNumber) {
        Pattern pattern = Pattern.compile("^-?\\d+$");
        boolean matches = pattern.matcher(repeatNumber).matches();

        if (!matches) {
            throw new IllegalArgumentException("This should be only number");
        }
    }

    public static void printWinResult(Map<String, Integer> carsWithWins) {
        for (String car : carsWithWins.keySet()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < carsWithWins.get(car); i++) {
                sb.append("-");
            }
            System.out.println(car + " : " + sb);
        }
    }
}
