package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private CarsList list;
    private List<Car> carsList = new ArrayList<>();
    private List<String> winnerList = new ArrayList<>();
    private int raceCount = 0;

    GameController() {
        list = new CarsList();
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    public List<String> getWinnerList() {
        return winnerList;
    }

    public void play() {
        setRace();
        playRace();
        endRace();
    }

    private void setRace() {
        TextView.PrintInputCarNameMessage();
        carsList = list.getCarsList(InputSystem.inputCars());
        TextView.PrintInputRaceCountMessage();
        raceCount = InputSystem.inputRaceCount();
    }

    private void playRace() {
        TextView.PrintInRaceMessage();

        for (int i = 0; i < raceCount; i++) {
            for (int j = 0; j < carsList.size(); j++) {
                carsList.get(j).move(RandomNumber.createRandomNumber());
                printInRace(j);
            }

            System.out.println();
        }
    }

    public void printInRace(int index) {
        var text = carsList.get(index).getName() + " : " + calculateMoveText(carsList.get(index).getMoveCount());
        System.out.println(text);
    }

    public String calculateMoveText(int max) {
        return GameConstants.CAR_MOVE_TEXT.repeat(Math.max(0, max));
    }

    private void endRace() {
        var maxCount = -1;
        var winnerTexts = "";
        maxCount = calculateMaxMoveCount(maxCount);

        addWinnerList(maxCount);

        printResult(createWinnerText(winnerTexts));
    }

    public int calculateMaxMoveCount(int maxCount) {
        for (Car car : carsList) {
            if (car.getMoveCount() > maxCount) {
                maxCount = car.getMoveCount();
            }
        }

        return maxCount;
    }

    public void addWinnerList(int maxCount) {
        for (Car car : carsList) {
            if (car.getMoveCount() == maxCount) {
                winnerList.add(car.getName());
            }
        }
    }

    public void printResult(String text) {
        TextView.PrintRaceResultMessage();
        System.out.println(text);
    }

    public String createWinnerText(String text) {
        StringBuilder textBuilder = new StringBuilder(winnerList.get(0));
        for (int i = 1; i < winnerList.size(); i++) {
            textBuilder.append(GameConstants.STRING_SPLIT_TEXT).append(winnerList.get(i));
        }
        text = textBuilder.toString();

        return text;
    }
}
