package Service;

import Domain.Car;
import Domain.Game;
import View.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameService {
    public Game createGame() {
        String[] carNames = getCarName();
        int tryCount = getTryCount();
        System.out.println(" ");
        Car[] cars = createCars(carNames);
        return new Game(cars, tryCount);
    }

    public void runGame(Game game) {
        game.runGame();
        System.out.println("실행 결과");
        showGameProgress(game.getGameProgress(), game.getCars());

        String winners = game.getWinners();
        View.printWinners(winners);
    }

    private void showGameProgress(List<String> gameProgress, Car[] cars) {
        int tryCount = gameProgress.size();
        for (int i = 0; i < tryCount; i++) {
            StringBuilder progress = new StringBuilder();
            for (int j = 0; j < cars.length; j++) {
                String carName = cars[j].getCarName();
                String[] results = gameProgress.get(i).split("\n");
                String result = results[j];
                View.printGameProgress(result);
            }
            System.out.println();
        }
    }

    public String[] getCarName() {
        String[] carNames;
        while (true) {
            View.inputCars();
            String input = Console.readLine();
            carNames = input.split(",");
            boolean allNamesValid = true;
            for (String name : carNames) {
                if (name.length() > 5) {
                    throw new IllegalArgumentException("모든 자동차 이름은 5자 이하이어야 합니다.");
                }
            }
            if (allNamesValid) {
                break; // 모든 이름이 5자 이하이면 입력 종료
            }
        }
        return carNames;
    }



    private int getTryCount() {
        View.inputTryCount();
        return Integer.parseInt(Console.readLine());
    }

    private Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }
}
