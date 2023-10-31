package game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import game.car.Car;
import game.car.CarList;

public class RacingGame {
    public GameStatus status;
    private CarList carList;
    private NumOfAttempt numOfAttempt;

    public RacingGame() {
        status = GameStatus.READY;
    }

    public void run() {
        switch (status) {
            case READY -> this.ready();
            case PROCEEDING -> this.proceed();
            case END -> this.end();
            default -> throw new IllegalStateException("Unexpected value: " + this.status);
        }
    }

    private void ready() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.carList = new CarList(Console.readLine());
        System.out.println("시도할 회수는 몇회인가요?");
        this.numOfAttempt = new NumOfAttempt(Console.readLine());
        this.status = GameStatus.PROCEEDING;
    }

    private void proceed() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < numOfAttempt.getNum(); i++) {
            this.move();
        }
        this.status = GameStatus.END;
    }

    private void move() {
        for (Car car : carList.getCarList()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.moveForward();
            }
        }
        printProgress();
        System.out.print("\n");
    }

    private void printProgress() {
        for (Car car : carList.getCarList()) {
            car.printPosition();
        }
    }

    private void end() {

    }
}
