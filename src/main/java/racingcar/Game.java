package racingcar;

import static racingcar.utils.ValidationRegex.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.model.Car;
import racingcar.utils.constant.Message;

public class Game { // 게임 진행 클래스

    private static int maxScore = 0;
    private static int gameRepeatNumber = 0;

    private static ArrayList<String> winnerList = new ArrayList<>();// 최종 우승자 저장을 위한 리스트


    private List<Car> carList = new ArrayList<>();


    public void start() {
        System.out.println(Message.START_MESSAGE);
        String inputStr = Console.readLine(); // 자동차 이름들을 입력받는다.
        String[] splitStr = inputStr.split(","); // 입력 받은 문자열을 , 를 기준으로 분리해서 배열에 저장한다.
        minCarCountCheck(splitStr); // 입력 값에 대한 예외 처리

        for (String str : splitStr) {
            minNameLengthCheck(str.strip());
            carList.add(new Car(str.strip()));
        }

        System.out.println(Message.REPEAT_NUMBER);

        String inputRepeatNumber = Console.readLine();
        repeatNumberCheck(inputRepeatNumber);
        gameRepeatNumber = Integer.parseInt(inputRepeatNumber);

        setRandomNumberToCars();

        pickWinner();

    }


    public void setRandomNumberToCars() {
        for (int i = 0; i < gameRepeatNumber; i++) {
            for (Car car : carList) {
                car.setRandomScore();
                car.printInfo();
            }
            System.out.println();
        }
    }


    public void pickWinner() {

        for (int i = 0; i < carList.size(); i++) {
            int carScore = carList.get(i).getScore();
            String carName = carList.get(i).getName();
            calculateMaxScore(carScore, carName);
        }

        String printString = String.join(",", winnerList);
        System.out.printf("최종 우승자 : %s", printString);

    }

    public void calculateMaxScore(int score, String name) {
        if (maxScore < score) {
            maxScore = score;
            winnerList.add(name);
            winnerList.remove(0);
        } else if (maxScore == score) {
            winnerList.add(name);
        }

    }

    public void minNameLengthCheck(String str) {

        if (str.length() > 5 || str.length() == 0) {
            throw new IllegalArgumentException(Message.MAX_CAR_NAME_ERROR);
        }

    }


    public void minCarCountCheck(String[] stringArr) {

        if (stringArr.length < 2) { // 자동차 개수가 최소 2개 이상이여야 게임 진행이 가능하다고 가정
            throw new IllegalArgumentException(Message.MIN_CAR_NUMBER_ERROR);
        }

    }

    public void repeatNumberCheck(String target) { //
        if(!isRepeatNumber(target)){
            throw new IllegalArgumentException("반복 횟수는 적어도 1번 이상이어야 합니다.");
        }


    }


}
