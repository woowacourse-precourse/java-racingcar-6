package racingcar.view;

public class OutputView {
    public static void printOutputMessage(){
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printWinner(String winner){
        System.out.println("최종 우승자 : " + winner);
    }

    public static void printResult(String carName ,Integer carNum){
        System.out.print(carName);
        System.out.print(" : ");
        System.out.println("-".repeat(carNum));
    }
}
