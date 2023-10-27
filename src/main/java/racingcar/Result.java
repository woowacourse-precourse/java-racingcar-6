package racingcar;

import java.util.List;

public class Result {

    public void print(List<Car> cars, int times, List<String> winner){

        printExecution(cars, times);
        printWinner(winner);
    }

    private void printExecution(List<Car> cars, int times){
        System.out.println("\n실행 결과");

        for(int i=0; i<times; i++){
            for (Car car : cars) {
                car.run();
                printProgress(car.getName(), car.getMove());
            }
            System.out.println(" ");
        }
    }

    private void printProgress(String name, String move){
        System.out.println(name + " : " + move);
    }

    private void printWinner(List<String> winner){
        System.out.print("최종 우승자 : ");

        for(int i=0 ; i<winner.size() ; i++){
            System.out.print(winner.get(i));
            if(i!=winner.size()-1){
                System.out.print(", ");
            }
        }

    }

}
