package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RacingCarGame {

    private Integer tryNumber;
    List<RacingCar> racingCarList;

    public RacingCarGame() {
        this.tryNumber = 0;
        this.racingCarList = new ArrayList<>();
    }

    public void play() {
        requestCarNames();
        requestTryNumber();
        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            tryOnce();
        }
        printWinners();
    }

    private void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        String[] carNames = carNameInput.split(",");
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        if (isDuplicatedString(carNames)) {
            throw new IllegalArgumentException("RacingCar name duplicated error");
        }
        Arrays.stream(carNames).forEach(carName -> {
            racingCarList.add(new RacingCar(carName));
        });
    }

    private boolean isDuplicatedString(String[] strings) {
        if (strings.length == Arrays.stream(strings).distinct().count()) {
            return false;
        } else {
            return true;
        }
    }

    private void requestTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            tryNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("tryNumber format error");
        }
        if (tryNumber <= 0) {
            throw new IllegalArgumentException("tryNumber range error");
        }
    }

    private void tryOnce() {
        racingCarList.forEach(racingCar -> {
            racingCar.tryMoving();
            racingCar.printResult();
        });
        System.out.println();
    }

    private void printWinners() {
        System.out.print("최종 우승자 : ");
        Collections.sort(racingCarList);
        System.out.print(racingCarList.get(0).getName());
        for (int i = 1; i < racingCarList.size(); i++) {
            if (Objects.equals(racingCarList.get(i - 1).getMovedDistance(),
                    racingCarList.get(i).getMovedDistance())) {
                System.out.print(", " + racingCarList.get(i).getName());
            } else {
                break;
            }
        }
        System.out.println();
    }
}
