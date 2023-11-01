package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultMessage {

    public static void printTitle(){
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRacingScore(List<Car> carList){
        for (Car car : carList){
            System.out.print(car.getName()+" : ");
            printScoreBar(car);
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinnerList(List<String> winnerList){
        System.out.print("최종 우승자 : ");
        if(whetherSoloWinner(winnerList)){
            printSoloWinner(winnerList);
        }
        if(!whetherSoloWinner(winnerList)){
            printMultipleWinner(winnerList);
        }
    }

    public static void printExceptionCase(String exceptionMessage){
        System.out.println(exceptionMessage);
    }

    private static void printScoreBar(Car car){
        for (int count=0; count < car.getLocation();count++){
            System.out.print("-");
        }
    }

    private static void printSoloWinner(List<String> winnerList){
        System.out.print(winnerList.get(0));
        System.out.println();
    }

    private static void printMultipleWinner(List<String> winnerList){
        for(int count=0;count<winnerList.size()-1;count++){
            System.out.print(winnerList.get(count));
            System.out.print(", ");
        }
        System.out.print(winnerList.get(winnerList.size()-1));
        System.out.println();
    }

    private static boolean whetherSoloWinner(List<String> winnerList){
        return winnerList.size()==1;
    }
    //TODO : exception
}
