package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import com.sun.jdi.IntegerValue;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarGame {
    int gameCount = 0;
    ArrayList<RacingCar> racingCars = new ArrayList<>();
    ArrayList<RacingCar> winners = new ArrayList<>();
    public ArrayList<RacingCar> getRacingCars() {
        return racingCars;
    }
    public ArrayList<RacingCar> getWinners() {
        return winners;
    }
    public int getGameCount() {
        return gameCount;
    }

    void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        setRacingCars(readLine());

        System.out.println("시도할 회수는 몇회인가요?");
        setGameCount(readLine());
        for (int i = 0; i < gameCount; i++) {
            playGame();
            printResult();
        }
        computeWinners(racingCars);
        printWinners(winners);
    }

    void setRacingCars(String items) {
        if (items.length() == 0) {
            throw new IllegalArgumentException();
        }
        for (String item : items.split(",| ")) {
            if (item.length() == 0) {
                continue;
            }
            if (item.length() > 5) {
                throw new IllegalArgumentException();
            }
            racingCars.add(new RacingCar(item));
        }
    }

    void setGameCount(String item) {
        try {
            gameCount = Integer.parseInt(item);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (gameCount < 0) {
            gameCount = 0;
            throw new IllegalArgumentException();
        }
    }

    void playGame() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    void printResult() {
        for (RacingCar racingCar : racingCars) {
            System.out.println(printRacingCarScore(racingCar));;
        }
    }

    String printRacingCarScore(RacingCar racingCar) {
        StringBuffer racingCarScore = new StringBuffer();
        racingCarScore.append(racingCar.getName());
        racingCarScore.append(" : ");
        for (int i = 0; i < racingCar.getScore(); i++) {
            racingCarScore.append("-");
        }
        return racingCarScore.toString();
    }

    void computeWinners(ArrayList<RacingCar> racingCars) {
        int maxScore = Integer.MIN_VALUE;
        for (RacingCar racingCar : racingCars) {
            int racingCarScore = racingCar.getScore();
            if (racingCarScore > maxScore) {
                maxScore = racingCarScore;
                winners.clear();
                winners.add(racingCar);
            } else if (racingCarScore == maxScore) {
                winners.add(racingCar);
            }
        }
    }

    void printWinners(ArrayList<RacingCar> winners) {
        StringBuffer result = new StringBuffer();
        result.append("최종 우승자 : ");
        for (RacingCar winner : winners) {
            result.append(winner.getName() + ", ");
        }
        System.out.println(result.substring(0, result.length() - 2));
    }
}