package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {
    public void printCarsPosition(List<Car> cars){
        String distanceMark = "-";
        for(Car car : cars){
            String name = car.getName();
            String position = distanceMark.repeat(car.getPosition());
            System.out.println(name + " : " + position);
        }
        System.out.println(); // 게임 진행상황 출력 후 줄바꿈
    }

    public void printWinner(List<Car> cars){
        List<Integer> positions = new ArrayList<>();
        List<String> winnersList = new ArrayList<>();
        String winnersString; // 우승자 명을 저장할 변수
        Integer maxPosition; // 가장 먼 위치 값을 저장할 변수
        for(Car car : cars){
            positions.add(car.getPosition());
        }
        maxPosition = Collections.max(positions);
        System.out.print("최종 우승자 : ");
        for(Car car : cars){
            Integer eachCarPosition = car.getPosition();
            String eachCarName = car.getName();
            if(eachCarPosition.equals(maxPosition)){
                winnersList.add(eachCarName);
            }
        }
        winnersString = String.join(", ", winnersList);
        System.out.println(winnersString);
    }
}
