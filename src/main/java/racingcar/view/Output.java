package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class Output {
    public static void printRequestCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }
    public static void printRequestAttemptsNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
    }
    public static void printExecutionResultMessage(){
        System.out.println("실행 결과");
    }
    public static void printRaceResult(Car car) {
        StringBuilder result= new StringBuilder();
        result.append(car.getCarName()).append(" : ").append("-".repeat(car.getPosition()));
        System.out.println(result);
    }

    public static String winner(List<Car> cars){
        int maxPosition=cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition()==maxPosition)
                .map(Car::getCarName)
                .collect(Collectors.joining(", ","최종 우승자 : ",""));
    }
}
