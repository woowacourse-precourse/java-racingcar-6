package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.*;

import static racingcar.CarMotionController.findWinners;
import static racingcar.InputProcessor.carNameInputProcess;
import static racingcar.InputProcessor.tryCountInputProcess;
import static racingcar.CarMotionController.carMotion;

public class Application {
    public static void main(String[] args) {
        try {
            // TODO: 프로그램 구현
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            ArrayList<String> carNames = carNameInputProcess(Console.readLine());

            System.out.println("시도할 회수는 몇회인가요?");
            int tryCount = tryCountInputProcess(Console.readLine());

            // verify console input
            // System.out.println("carNames : " + carNames);
            // System.out.println("tryCount : " + tryCount);

            // carNames : [pobi, woni, jun]
            // tryCount : 5

            String[] carMovements = new String[carNames.size()];

            System.out.println("\n실행 결과");

            calculateMovement(tryCount, carNames, carMovements);

            Map<String, Integer> carHashMap = new HashMap<String, Integer>();

            for (int i = 0; i < carNames.size(); i++) {
                carHashMap.put(carNames.get(i), carMovements[i].length());
            }

            List<String> finalWinners = findWinners(carHashMap);

            // formatting
            String winnersFormatted = String.join(", ", finalWinners);

            System.out.println("최종 우승자 : " + winnersFormatted);

        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    private static void addMovement(String[] carMovements, int index, String carMovement) {
        if (carMovements[index] == null) {
            carMovements[index] = carMovement;
        } else {
            carMovements[index] += carMovement;
        }
    }

    private static void  calculateMovement(int tryCount, ArrayList<String> carNames, String[] carMovements) {
        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < carNames.size(); j++) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                String carMovement = carMotion(randomNumber);
                addMovement(carMovements, j, carMovement);

                System.out.println(carNames.get(j) + " : " + carMovements[j]);
            }
            System.out.println();
        }
    }
}
