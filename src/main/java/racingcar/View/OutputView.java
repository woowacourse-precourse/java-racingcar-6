package racingcar.View;

public class OutputView {
    private static final String racingCarName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String tryCount = "시도할 횟수는 몇회인가요?";

    public void AskCarName(){
        System.out.println(racingCarName);
    }

    public void AskTryCount(){
        System.out.println(tryCount);
    }
}
