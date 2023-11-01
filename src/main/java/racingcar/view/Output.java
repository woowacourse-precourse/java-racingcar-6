package racingcar.view;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Output {
    public void startGame(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void inputRepetitions(){
        System.out.println("시도할 회수는 몇회인가요?");
    }
    public void makeResult(String[] playerList){
        System.out.print("최종 우승자 : ");
        String result = Arrays.stream(playerList)
                .collect(Collectors.joining(","));
        System.out.println(result);
    }

    public void showCurrentSituation(List<Car> carList){
        for(Car car: carList){
            showCurrentCarSituation(car);
        }
        System.out.println();
    }

    private void showCurrentCarSituation(Car car){
        System.out.print(car.getName()+" : ");
        for(int i = 0; i<car.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
