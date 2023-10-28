package racingcar.view;

public class OutputView {

    private OutputView() {
    }

    public static void printRacingStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAskCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResult(){
        System.out.println("실행 결과");
    }


}
