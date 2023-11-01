package racingcar;

import java.util.ArrayList;

public class RacingCarGame {
    ArrayList<RacingCar> racingCars;
    int tryIteration;

    public void setRacingCarNames(String inputText) throws IllegalArgumentException {
        if (inputText.isBlank()) {
            throw new IllegalArgumentException("빈칸은 허용되지 않습니다.");
        }
        String[] names = inputText.split(",");
        for (String name : names) {
            racingCars.add(new RacingCar(name));
        }
    }

    public void setTryIteration(String readLine) throws IllegalArgumentException {
        try {
            this.tryIteration = Integer.parseInt(readLine);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }

    RacingCarGame() {
        racingCars = new ArrayList<>();
    }

    private void tryForward() {
        for (RacingCar racingCar : racingCars) {
            racingCar.process();
            System.out.println(racingCar);
        }
    }

    public void gameStart() {
        System.out.println("실행 결과");
        for (int i = 0; i < this.tryIteration; i++) {
            tryForward();
            System.out.println();
        }
    }

    public void printWinner() {
        int maxPosition = Integer.MIN_VALUE;
        for (RacingCar racingCar : racingCars) {
            maxPosition = Math.max(maxPosition, racingCar.getPosition());
        }
        int finalMaxPosition = maxPosition;
        String[] winnerNames = racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == finalMaxPosition)
                .map(RacingCar::getCarName)
                .toArray(String[]::new);
        System.out.println("최종 우승자 : " +
                String.join(", ", winnerNames));
    }
}
