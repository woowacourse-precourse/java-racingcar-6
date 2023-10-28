package service;

import domain.RacingCar;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import util.RandomGenerator;

public class RacingCarService {

    private List<RacingCar> racingCarList;

    public void process(Set<String> carNameSet) {
        racingCarList = generateRacingCar(carNameSet);
    }

    private List<RacingCar> generateRacingCar(Set<String> carNameSet) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String carName : carNameSet) {
            racingCarList.add(new RacingCar(carName));
        }

        return racingCarList;
    }

    public void startRacing(int cycle) {
        // TODO: 메시지 View 로 전달하는 방식으로 변경하기
        System.out.println("실행 결과");
        for (int i = 0; i < cycle; i++) {
            for (RacingCar racingCar : racingCarList) {
                if (racingCar.isMoveForward(RandomGenerator.generateNumber())) {
                    racingCar.moveForward();
                }
                System.out.println(racingCar.getName() + " : " + racingCar.getLocation());
            }
            System.out.println();
        }

        // TODO: 승자 판정 로직 분리하기
        List<String> winners = new ArrayList<>();
        int maxDistance = Integer.MIN_VALUE;
        for (RacingCar racingCar : racingCarList) {
            int distance = racingCar.getLocation().length();
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(racingCar.getName());
            } else if (distance == maxDistance) {
                winners.add(racingCar.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
