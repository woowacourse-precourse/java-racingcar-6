package racingcar.view;

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
        System.out.println(car.getCarName()+" : "+"-".repeat(car.getPosition()));
    }
}
