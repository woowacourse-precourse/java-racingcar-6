package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class RacingGameView {

    // 4. 자동차 이름을 입력해달라는 문구를 출력하는 기능
    public void showCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    // 3. 최종 우승자(들)을 출력하는 기능
    public void printFinalWinners(List<Car> winnerList) {
        String winners = "최종 우승자 : ";
        List<String> winnerNames = new ArrayList<String>();

        for(Car car : winnerList){
            winnerNames.add(car.getName());
        }
        winners+= String.join(", ", winnerNames);
        System.out.println(winners);
    }

    // 5. 시도할 회수를 입력해달라는 문구를 출력하는 기능
    public void showTrialNumberInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    // "실행 결과"를 출력하는 메서드
    public void printResultMessage(){
        System.out.println("\n실행 결과");
    }

    // 자동차들의 현재 전진 횟수를 "-" 개수로 출력하는 메서드
    public void printCarsLocation(List<Car> cars){
        for(Car car: cars){
            System.out.printf("%s : ", car.getName());
            System.out.println("-".repeat(car.getForwardCount()));
        }
        System.out.println();
    }
}
