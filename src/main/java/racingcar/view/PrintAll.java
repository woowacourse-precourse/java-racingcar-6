package racingcar.view;

import racingcar.domain.Car;

import java.awt.*;
import java.util.List;

public class PrintAll {

    public void inputCarPrint() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void inputTryNumberPrint() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void outputResultPrint() {
        System.out.println("실행 결과");
    }

    public void printProgress(List<Car> CarList) {

        for (Car car : CarList) {
            System.out.print(car.getName() + " : ");
            printBar(car);
        }
        System.out.println(" ");
    }

    public void printBar(Car car) {
        for (int i = 0; i < car.getProgressbar(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void outputFinalPrint(List<String> nameList) {
        System.out.print("최종 우승자 : ");
        if (nameList.size() == 1) {
            System.out.print(nameList.get(0));
            System.out.println();
        } else {
            multiWinner(nameList);
        }

    }

    public void multiWinner(List<String> nameList) {
        for (int i=0;i< nameList.size()-1;i++){
            System.out.print(nameList.get(i));
            System.out.print(", ");
        }
        System.out.print(nameList.get(nameList.size()-1));
        //for (String name : nameList) {
        //    System.out.print(name);
            //if (nameList.get(-1) != name) {
            //    System.out.print(", ");
            //}
        }
    }

