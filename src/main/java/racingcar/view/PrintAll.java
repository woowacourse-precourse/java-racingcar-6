package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class PrintAll {

    public void inputCarPrint(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void inputTryNumberPrint(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void outputResultPrint(){
        System.out.println("실행 결과");
    }

    public void printProgress(List<Car> CarList){
        //for문으로 리스트 전체 출력 =>service에서 출력?
        for(Car car : CarList){
            System.out.print(car + " : ");
            printBar(car);
        }
        System.out.println(" ");
    }
    public void printBar(Car car){
        for (int i=0;i<car.getProgressbar(); i++){
            System.out.print("-");
        }
    }

    public void outputFinalPrint(String winner){
        System.out.print("최종 우승자 : ");
        System.out.println(winner);
    }
}
