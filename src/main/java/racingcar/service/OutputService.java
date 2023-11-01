package racingcar.service;

import racingcar.repository.CarInfo;
import racingcar.repository.RacingGameRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OutputService {
    private RacingGameRepository racingGameRepository;

    public OutputService(RacingGameRepository racingGameRepository) {
        this.racingGameRepository = racingGameRepository;
    }

    public void printSingleResult() {
        List<CarInfo> cars = racingGameRepository.getCar();
        for (CarInfo car : cars) {
            System.out.printf(car.getName() + " : ");
            System.out.println(repeatChar('-', car.getDistance()));
        }
        System.out.println();
    }

    public String repeatChar(char ch, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public void printRacingGameResult() {
        List<CarInfo> carInfos = racingGameRepository.getCar();
        List<String> raceWinners = getRaceWinners(carInfos);

        String result = raceWinners.stream()
                        .collect(Collectors.joining(", "));
        System.out.println("최종 우승자" + " : " + result);
    }

    private List<String> getRaceWinners(List<CarInfo> carInfos) {
        int maxDistance = carInfos.stream()
                .mapToInt(CarInfo::getDistance)
                .max()
                .orElse(0);

        List<String> raceWinners = carInfos.stream()
                .filter(carInfo -> carInfo.getDistance() == maxDistance)
                .map(CarInfo::getName)
                .collect(Collectors.toList());
        return raceWinners;
    }

}
