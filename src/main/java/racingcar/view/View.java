package racingcar.view;

import java.util.List;

public class View {
    private static final int FIRST_IDX = 0;
    private static final int NUMBER_FOR_ACCESS_LAST_ELEMENT = 1;

    private void printMsg(String output) {
        System.out.println(output);
    }

    public void printEmptyLine() {
        printMsg("");
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

    public void finalWinnerMsg(List<String> cars) {
        System.out.print("최종 우승자 : ");

        for (int i = FIRST_IDX; i < cars.size(); i++) {
            String carName = cars.get(i);
            System.out.print(carName);
            isThatNotLastCar(i != cars.size() - NUMBER_FOR_ACCESS_LAST_ELEMENT);
        }
    }

    private void isThatNotLastCar(boolean result) {
        if (result) {
            System.out.print(", ");
        }
    }
}
