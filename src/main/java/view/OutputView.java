package view;

public class OutputView {

    public void printStartGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printResultGame() {
        System.out.println("실행 결과");
    }

    public void printMoveResult(StringBuilder sb) {
        System.out.println(sb);
    }

}
