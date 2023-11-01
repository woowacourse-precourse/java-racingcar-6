package racingcar.view;

public class OutputView {
    
    final static String resultInformation = "실행 결과";
    final static String winnerInformation = "최종 우승자";

    public void printInformation(){
        System.out.println(resultInformation);
    }

    public void printResultGame(String carNames, String gameResult){
        System.out.println(carNames + " : " + gameResult);
    }

    public void printWinner(String winner){
        System.out.println(winnerInformation + " : " +winner);
    }
}
