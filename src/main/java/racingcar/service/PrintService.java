package racingcar.service;

import racingcar.domain.Cars;

public class PrintService {

    // 공통처리
    public void questionCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void questionTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void result() {
        System.out.println("실행 결과");
    }

    // 값마다 다른것
    public void racing(int size, Cars cars) {
        for (int i = 0; i < size; i++) {
            name(cars.getName(i));
            position(cars.getGameNum(i));
            spaceSkip();
        }
        spaceSkip();
    }

    public void name(String name) {
        System.out.print(name + " : ");
    }

    public void winner(String winners) {
        System.out.print("최종 우승자 : " + winners);
    }

    private void and(int size, int i) {
        if (i != size - 1) {
            System.out.print(", ");
        }
    }

    public void position(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
    }

    public void spaceSkip() {
        System.out.println();
    }
}