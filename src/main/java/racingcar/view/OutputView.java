package racingcar.view;

public class OutputView {
    private final String inputCarsMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String inputTimesMessage = "시도할 회수는 몇회인가요?";
    private final String resultMessage = "실행 결과";
    private final String winnerMessage = "최종 우승자 : ";

    public void printInputCars(){
        System.out.println(inputCarsMessage);
    }

    public void printInputTimes(){
        System.out.println(inputTimesMessage);
    }

    public void printResult(){
        System.out.println(resultMessage);
    }

    public void printProcess(String currentStatus){
        System.out.println(currentStatus);
    }

    public void printWinner(String winners){
        System.out.print(winnerMessage+winners);
    }

}
