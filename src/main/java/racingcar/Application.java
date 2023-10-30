package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
    
import java.util.HashMap;
import java.util.Map;
    
public class Application {
        public static void main(String[] args) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
            String carNameInput = Console.readLine();
            String[] carNames = carNameInput.split(",");
    
            for (String carName : carNames) {
                carName.trim();
                if (carName.length() > 5) {
                    throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
                }
            }

            System.out.println("시도할 회수는 몇회인가요?");
            int numAttempts = Integer.parseInt(Console.readLine());
            if (numAttempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }

            System.out.println("실행 결과");
    
            Map<String, Integer> carPositions = new HashMap<>();
            for (String carName : carNames) {
                carPositions.put(carName, 0);
            }
    
            for (int attempt = 0; attempt < numAttempts; attempt++) {
                for (String carName : carNames) {
                    int randomValue = Randoms.pickNumberInRange(0, 9);
                    if (randomValue >= 4) {
                        int currentPosition = carPositions.get(carName);
                        carPositions.put(carName, currentPosition + 1);
                    }
    
                    System.out.print(carName + " : ");
                    int currentPosition = carPositions.get(carName);
                    for (int i = 0; i < currentPosition; i++) {
                        System.out.print("-");
                    }
                    System.out.println();
                }
                System.out.println();
            }
    
            int maxPosition = carPositions.values().stream()
                    .mapToInt(Integer::intValue)
                    .max()
                    .orElse(0);
    
            System.out.print("최종 우승자 : ");

            boolean firstWinner = true;
            for (String carName : carNames) {
                if (carPositions.get(carName) == maxPosition) {
                    if (firstWinner) {
                        System.out.print(carName);
                        firstWinner = false;
                    } else {
                        System.out.print(", " + carName);
                    }
                }
            }
            System.out.println();
        }
    }
    
