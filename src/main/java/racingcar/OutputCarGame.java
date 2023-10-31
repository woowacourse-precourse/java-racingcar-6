package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class OutputCarGame {
    CarsManage carsManage = new CarsManage();
    public void play(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carsManage.inputCars();
        System.out.println("시도할 회수는 몇회인가요?");
        int n = Integer.parseInt(Console.readLine());

        System.out.println("\n실행결과");
        straightCars(n);

    }

    public void straightCars (int n){
        for (int i = 0; i < n; i++) {
            carsManage.addStraight();
            roundResult();
            System.out.println();
        }
        printWinner();
    }

    public void roundResult(){
        for (Car car: carsManage.cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getStraight(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void printWinner(){
        List<String> winner = carsManage.chooseWinner();

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++) {
            System.out.print(winner.get(i));
            if(i + 1<winner.size()){
                System.out.print(", ");
            }
        }
    }
}
