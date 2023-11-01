package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RacingCarGame {

    /**
     * 기능 3. 자동차 전진 기능
     * 차 이름과 이동 횟수가 담긴 Map과 라운드 실행 횟수를 받아서
     * 라운드 횟수 만큼 경주를 실행해서 이동 횟수를 업데이트 한다.
     * 모든 라운드가 끝난 뒤 업데이트 된 Map을 반환한다.
     *
     * @param carNameAndMovementCountMap 차 이름과 이동 횟수가 담긴 Map
     * @param numberOfRounds 라운드 실행 횟수
     * @return 업데이트 된 carNameAndMovementCountMap
     */
    public static Map<String, Integer> executeAllRounds(Map<String, Integer> carNameAndMovementCountMap, int numberOfRounds) {
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfRounds; i++) {
            executeMovement(carNameAndMovementCountMap);
        }
        return carNameAndMovementCountMap;
    }

    private static void executeMovement(Map<String, Integer> carNameAndMovementCountMap) {
        carNameAndMovementCountMap.forEach((carName, movementCount) -> {
            if (Randoms.pickNumberInRange(0, 9) > 3) {
                carNameAndMovementCountMap.put(carName, ++movementCount);
            }
            printResultAfterMovement(carName, movementCount);
        });
        System.out.println();
    }

    private static void printResultAfterMovement(String carName, Integer movementCount) {
        System.out.print(carName + " : ");

        for (int j = 0; j < movementCount; j++) {
            System.out.print("-");
        }
        System.out.println();
    }


    /**
     * 기능 4. 게임 완료 후 우승자 선출 기능
     * 차 이름과 이동 횟수가 담긴 Map 을 받아서
     * 이동 횟수가 가장 많은 차 이름의 리스트를 반환한다.
     *
     * @param carNameAndMovementCountMap 차 이름, 이동 횟수 맵
     * @return 우승자 이름 리스트
     */
    public static List<String> selectFinalWinner(Map<String, Integer> carNameAndMovementCountMap) {
        List<String> winnerList = new ArrayList<>();

        Integer maxMovementValue = carNameAndMovementCountMap.values()
                .stream()
                .max(Comparator.comparingInt(Integer::intValue))
                .orElseThrow();

        carNameAndMovementCountMap.forEach((carName, movementCount) -> {
            if (Objects.equals(movementCount, maxMovementValue)) {
                winnerList.add(carName);
            }
        });

        printWinnerList(winnerList);
        return winnerList;
    }

    private static void printWinnerList(List<String> winnerList) {
        String result = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + result);
    }

}
