package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;

public class GameView {
    public String readCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String readNumberOfMoves() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    private void printPositions(List<Car> cars, int index){
        for(Car car : cars){
            System.out.println(
                    car.getName() + " : " + "-".repeat(car.getPosition(index))
            );
        }
        System.out.println();
    }

    public void printResult(List<Car> cars, int numberOfMoves) {
        System.out.println("실행 결과");
        for(int i=1;i<=numberOfMoves;i++){
            printPositions(cars, i);
        }
    }

    public void printWinners(List<Car> winners){
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(",", winners.stream()
                .map(Car::getName)
                .toList()));
    }
}
