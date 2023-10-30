package racingcar;

public class Output {
    private String enterNameOfCar = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private String enterTryTime = "시도할 회수는 몇회인가요?";
    private String executionResult = "실행결과";
    public void printEnterNameOfCar(){
        System.out.println(enterNameOfCar);
    }

    public void printEnterTryTime(){
        System.out.println(enterTryTime);
    }

    public void printExecutionResult(){
        System.out.println(executionResult);
    }
}
