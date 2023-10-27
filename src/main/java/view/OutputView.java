package view;

public class OutputView {

    private static final String carNamesMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String tryNumberMessage = "시도할 회수는 몇회인가요?";

    public void enterCarNamesMessage() {
        System.out.println(carNamesMessage);
    }

    public void enterTryNumberMessage() {
        System.out.println(tryNumberMessage);
    }
}
