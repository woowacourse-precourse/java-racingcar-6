package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RacingCarGame {

    HashMap<String, Integer> cars = new LinkedHashMap<>();
    List<String> winners = new ArrayList<>();
    private static final int MOVE_50_PERCENT = 4;
    static long count;


    public void inputUserCarName() {
        String userInput = Console.readLine();
        validateInputNotEmpty(userInput);

        String[] carNames = userInput.split(",");
        validateCarNames(carNames);

        for (String carName : carNames) {
            cars.put(carName, 0);
        }

    }

    private static void validateInputNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
    }

    private void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("차의 이름은 5글자 이하이어야 합니다.");
            }
        }
    }

    public long inputStartCount() {
        String userCount = Console.readLine();
        validateInputNotEmpty(userCount);
        validateNotLong(userCount);

        return Long.parseLong(userCount);
    }

    private void validateNotLong(String userCount) {
        try {
            Long.parseLong(userCount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 입력되어야 합니다.");
        }

    }

    public void play(long userCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < userCount; i++) {
            moveCars();
            printCarStatus();
        }
    }

    private void printCarStatus() {
        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void moveCars() {
        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            if (canMove()) {
                updateCarPosition(entry);
            }
        }
    }

    private void updateCarPosition(Map.Entry<String, Integer> entry) {
        int update = cars.getOrDefault(entry.getKey(), entry.getValue() + 1) + 1;
        cars.put(entry.getKey(), update);
        count = Math.max(count, update);
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_50_PERCENT;
    }

    public void resultPrint() {
        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            if (entry.getValue() >= count) {
                winners.add(entry.getKey());
            }
        }

        String result = String.join(",", winners);
        System.out.println("최종 우승자 : " + result);

    }
}