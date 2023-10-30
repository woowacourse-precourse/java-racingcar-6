package racingcar.view;

public class OutputView {
    public static void printExecutionResult(){
        System.out.println("실행결과");
    }

    public static void printWinner(){
        System.out.print("최종우승자 : ");
    }

    public static void printGo(){
        System.out.print("-");
    }

    public static void printCarsName(String car){
        System.out.print(car + " : ");
    }
}
