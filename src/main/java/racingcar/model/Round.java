package racingcar.model;

import racingcar.DTO.CarDTO;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
    private static final int INITIAL_ROUND = 0;
    private static int currentRoundCount = INITIAL_ROUND;

    public void startRound(List<Car> cars) {
        cars.forEach(Car::startEngine);
    }

    public void endRound() {
        currentRoundCount++;
    }

    public List<CarDTO> generateResult(List<Car> cars) {
        List<CarDTO> roundResult = cars.stream()
                .map(car -> new CarDTO(car.getName(), car.getPosition()))
                .collect(Collectors.toList());

        return roundResult;
    }

    public static List<CarDTO> calculateFurthestCarInfo(List<List<CarDTO>> EachRoundResult) {
        // 가장 마지막 라운드의 결과 추출
        List<CarDTO> lastRoundResult = EachRoundResult.get(EachRoundResult.size() - 1);

        // 가장 멀리 이동한 위치 계산
        int maxPosition = lastRoundResult.stream()
                .mapToInt(CarDTO::getPosition)
                .max()
                .orElse(0);

        // 가정 멀리 이동한 위치에 있는 모든 자동차 정보 반환
        return lastRoundResult.stream()
                .filter(carDTO -> carDTO.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public static int getCurrentRoundCount() {
        return currentRoundCount;
    }

    public static void resetCurrentRoundCount() {
        currentRoundCount = INITIAL_ROUND;
    }
}
