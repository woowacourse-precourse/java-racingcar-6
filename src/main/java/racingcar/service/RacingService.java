package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.List;

public class RacingService {
    // Service
    // 비즈니스 규칙, 데이터 처리, 외부 시스템과의 상호작용 등을 처리하는 데 주로 사용
    // 도메인 객체를 사용하여 비즈니스 로직을 구현
    // 필요에 따라 데이터 베이스 또는 외부 서비스와 상호 작용

    private final String FINAL_RESULT = "최종 우승자 : ";
    private final String WHITE_SPACE = "";
    private final String COMMA = ",";

    public List<String> playRound(List<Car> carList) {
        List<String> result = new ArrayList<>();

        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 10);
            car.move(randomNumber);
            result.add(car.getStatus());
        }

        return result;
    }

    public List<String> playAllRounds(List<Car> carList, int totalRound) {
        List<String> result = new ArrayList<>();

        for (int round = 0; round < totalRound; round++) {
            List<String> roundResult = playRound(carList);
            roundResult.add(WHITE_SPACE);
            result.addAll(roundResult);
        }

        return result;
    }

    public int getMaxMovingDistance(List<Car> carList) {
        int maxMovingDistance = Integer.MIN_VALUE;

        for (Car car : carList) {
            int carLocation = car.getMovingDistance();
            if (carLocation > maxMovingDistance) {
                maxMovingDistance = carLocation;
            }
        }

        return maxMovingDistance;
    }

    public List<String> generateWinnerList(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();

        int maxMovingDistance = getMaxMovingDistance(carList);

        for (Car car : carList) {
            int curLocation = car.getMovingDistance();
            if (curLocation == maxMovingDistance) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }

    public String makeFinalResult(List<Car> carList) {
        StringBuilder result = new StringBuilder();

        result.append(FINAL_RESULT);

        List<String> winnerList = generateWinnerList(carList);
        String winners = String.join(COMMA, winnerList);

        result.append(winners);

        return result.toString();
    }


}
