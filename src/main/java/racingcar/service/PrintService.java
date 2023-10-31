package racingcar.service;

import racingcar.repository.CarsRepository;

public class PrintService {

    private final CarsRepository carsRepo = new CarsRepository();

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
    public void racing(int size) {
        for (int i = 0; i < size; i++) {
            name(carsRepo.getName(i));
            position(carsRepo.getGameNum(i));
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

    public void position(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
    }

    public void spaceSkip() {
        System.out.println();
    }
}