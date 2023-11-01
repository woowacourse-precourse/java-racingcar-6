package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {
    List<Car> racingCars;
    int moveCount;

    public RacingCarGame() {
        List<String> names = readCarNames();
        this.racingCars = makeCars(names);

        this.moveCount = readMoveCount();
    }

    // 기능 1) RacingCarGame을 플레이한다.
    public void play() {
        writeAllMoves();

        writeWinners();
    }

    // 기능 4) 입력받은 자동차 이름 목록을 이용하여 자동차 목록을 만든다.
    private List<Car> makeCars(List<String> names) {
        return names.stream()
                .map(name -> new Car(name.trim()))
                .collect(Collectors.toList());
    }

    // 기능 2) 5자 이하의 자동차 이름 n개를 쉼표(,)를 기준으로 구분하여 입력 받는다.
    private List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return Arrays.stream(Console.readLine().split(",")).toList();
    }

    // 기능 5) 몇 번의 이동을 할 것인지 입력 받는다.
    private int readMoveCount() {
        System.out.println("시도할 횟수는 몇회인가요?");

        return Integer.parseInt(Console.readLine());
    }

    // 기능 7) 0에서 9 사이의 무작위 값이 4 이상인 경우에는 자동차가 전진하고 그렇지 않으면 멈춘다.
    private void moveOrStop(Car car) {
        if(makeRandomNumber() >= 4) {
            car.move();
        }

        writeCarTrace(car);
    }

    // 기능 6) 0에서 9 사이의 임의의 숫자를 뽑는다.
    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    // 기능 10) 자동차의 이동 자취를 출력한다.
    private void writeCarTrace(Car car) {
        String trace = getCarTrace(car);

        System.out.println(car.getName() + " : " + trace);
    }

    // 기능 9) 자동차의 이동 자취를 구한다.
    private String getCarTrace(Car car) {
        return IntStream.range(0, car.getDistance())
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

    // 기능 12) 사용자가 입력한 이동 횟수만큼 각 자동차의 이름과 이동 결과를 출력한다.
    private void writeAllMoves() {
        System.out.println();
        System.out.println("실행 결과");

        IntStream.range(0, this.moveCount).forEach(i -> writeEachMove());
    }

    // 기능 11) 모든 자동차에 대하여 1회 이동 혹은 정지시킨 결과를 출력한다.
    private void writeEachMove() {
        this.racingCars.forEach(this::moveOrStop);

        System.out.println();
    }

    // 기능 15) 자동차 경주 게임이 끝나면 우승자를 출력한다.
    private void writeWinners() {
        String winners = getWinners();

        System.out.println("최종 우승자 : " + winners);
    }

    // 기능 13) 자동차들의 이동 거리 최대값을 구한다.
    private int getMaxDistance() {
        return this.racingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    // 기능 14) 우승자 목록을 구한다.
    private String getWinners() {
        int maxDistance = getMaxDistance();

        return this.racingCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
