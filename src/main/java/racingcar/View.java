package racingcar;

public class View {

    private void printMsg(String output) {
        System.out.println(output);
    }

    public void inputNamesMsg() {
        printMsg("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void inputRoundMsg() {
        printMsg("시도할 횟수는 몇회인가요?");
    }

    public void resultTitleMsg() {
        printMsg("실행 결과");
    }

    public void carResultMsg(String name, String process) {
        printMsg(name + " : " + process);
    }

    public void finalWinnerMsg() {
        System.out.print("최종 우승자 : ");
    }
}
