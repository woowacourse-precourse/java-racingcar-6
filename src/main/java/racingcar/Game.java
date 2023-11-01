package racingcar;

import static racingcar.utils.ValidationRegex.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.utils.constant.Message;

public class Game { // 게임 진행 클래스

    private static int maxScore = -1;
    private static int gameRepeatNumber = 0;
    private static ArrayList<String> winnerList = new ArrayList<>();// 최종 우승자 저장을 위한 리스트
    private final List<Car> carList = new ArrayList<>();


    public void start() {
        inputCarNames();
        inputRepeatNumber();
        repeatGame();
        pickWinner();
    }

    public void inputCarNames() {
        System.out.println(Message.START_MESSAGE);
        String inputStr = Console.readLine();
        String[] splitStr = inputStr.split(",");
        minCarCountExceptionCheck(splitStr);
        saveCarNames(splitStr);
    }

    public void saveCarNames(String[] splitStr) {
        for (String str : splitStr) {
            minNameLengthExceptionCheck(str.strip());
            carList.add(new Car(str.strip()));
        }
    }

    public void inputRepeatNumber() {
        System.out.println(Message.REPEAT_NUMBER);
        String inputRepeatNumber = Console.readLine();
        repeatNumberExceptionCheck(inputRepeatNumber);
        gameRepeatNumber = Integer.parseInt(inputRepeatNumber);
    }

    public void repeatGame() {
        for (int i = 0; i < gameRepeatNumber; i++) {
            setRandomNumberToCars();
        }
    }

    public void setRandomNumberToCars() {
        for (Car car : carList) {
            car.setRandomScore();
            car.printInfo();
        }
        System.out.println();
    }

    public void pickWinner() {
        for (int i = 0; i < carList.size(); i++) {
            int carScore = carList.get(i).getScore();
            String carName = carList.get(i).getName();
            calculateMaxScore(carScore, carName);
        }
        printWinner();
    }

    public void printWinner() {
        String printString = String.join(",", winnerList);
        System.out.printf("최종 우승자 : %s", printString);

    }

    public void calculateMaxScore(int score, String name) {
        if (maxScore < score) {
            maxScore = score;
            winnerList.clear();
            winnerList.add(name);
        } else if (maxScore == score) {
            winnerList.add(name);
        }
    }

    /**
     * 예외 처리
     */
    public void minNameLengthExceptionCheck(String str) {
        if (str.length() > 5 || str.length() == 0) {
            throw new IllegalArgumentException(Message.MAX_CAR_NAME_ERROR);
        }
    }


    public void minCarCountExceptionCheck(String[] stringArr) {
        if (stringArr.length < 2) { // 자동차 개수가 최소 2개 이상이여야 게임 진행이 가능하다고 가정
            throw new IllegalArgumentException(Message.MIN_CAR_NUMBER_ERROR);
        }
    }

    public void repeatNumberExceptionCheck(String target) {
        if (!isRepeatNumber(target)) {
            throw new IllegalArgumentException(Message.MIN_REPEAT_ERROR);
        }
    }

}
