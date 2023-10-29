package racingcar.view;

import org.mockito.internal.verification.InOrderWrapper;

import java.util.ArrayList;

public class OutputView {

    public void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRoundNumMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printWinnerMessage() {
        System.out.print("최종 우승자 : ");
    }

    public void printWinnerResult(String carName) {
        System.out.print(carName+", ");
    }

    public void printLastWinnerResult(String carName) {
        System.out.print(carName);
    }


    public ArrayList<StringBuilder> makeStringBuilders(int numberOfCars) {
        ArrayList<StringBuilder> carStringBuilders = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            StringBuilder carStringBuilder = new StringBuilder();
            carStringBuilders.add(carStringBuilder);
        }
        return carStringBuilders;
    }

    public void appendDefaultString(int carIdx, String name, ArrayList<StringBuilder> carStringBuilders) {
        StringBuilder carStringBuilder = carStringBuilders.get(carIdx);
        carStringBuilder.append(name + " : ");
    }

    public void appendStringBuilder(int carIdx, String name, ArrayList<StringBuilder> carStringBuilders) {
        StringBuilder carStringBuilder = carStringBuilders.get(carIdx);
        if (carStringBuilder.isEmpty()) {
            carStringBuilder.append(name + " : ");
        }
        carStringBuilders.get(carIdx).append("-");
    }

}
