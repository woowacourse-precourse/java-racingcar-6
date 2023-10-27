package racingcar.domain;

import java.util.List;

public class View {

    public void printAskCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAskTryRepetitionNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printProgressStatus(List<String> carNameList, List<String> carProgressStatus) {

        int carIndex = carNameList.size();
        for (int i = 0; i < carIndex; i++) {

            System.out.println(carNameList.get(carIndex) + " : " + carProgressStatus.get(carIndex));
        }
        System.out.println();
    }

    public void printWinner() {

        System.out.println("최종 우승자 : ");
    }

}
