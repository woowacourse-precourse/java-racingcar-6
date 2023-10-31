package racingcar;

import java.util.List;

public class Print {

    public void printInitName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInitCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult(Car[] cars){
        System.out.println("실행 결과");
        for (Car car : cars) {
            printResultCar(car);
            System.out.println();
        }
    }

    public void printResultCar(Car car){
        System.out.print(car.getName() + " : ");
        for(int i=0; i<car.getPos(); i++){
            System.out.print("-");
        }
    }

    public void printVictoryCar(List<String> carList){
        System.out.print("최종 우승자 : ");
        for (String input : carList) {
            System.out.print(input + ", ");
        }
        System.out.println("\b\b");
    }

}
