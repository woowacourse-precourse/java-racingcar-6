package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class Game { // 게임 진행 클래스

    private static int maxScore = 0;
    private static int gameRepeatNumber = 0;

    private static ArrayList<String> winnerList = new ArrayList<>();// 최종 우승자 저장을 위한 리스트


    private List<Car> carList = new ArrayList<>();


    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputStr = Console.readLine(); // 자동차 이름들을 입력받는다.
        String[] splitStr = inputStr.split(","); // 입력 받은 문자열을 , 를 기준으로 분리해서 배열에 저장한다.
        minCarCountCheck(splitStr); // 입력 값에 대한 예외 처리

        for (String str : splitStr) {
            minNameLengthCheck(str);
            carList.add(new Car(str.strip()));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        gameRepeatNumber = Integer.parseInt(Console.readLine());

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
        } else if (maxScore == score) {
            winnerList.add(name);
        }

    }

    public void minNameLengthCheck(String str) {
        if (str.strip().length() > 5 || str.strip().length() == 0) {
            throw new IllegalArgumentException("이름은 최소 한글자 이상 다섯글자 이하로 작성해 주세요.");
        }
    }


    public void minCarCountCheck(String[] stringArr) {

        if (stringArr.length < 2) { // 입력한 자동차 개수가 최소 2개 이상이여야 게임 진행이 가능하기 때문에
            throw new IllegalArgumentException("게임 진행을 위해 자동차 이름을 최소 2개 이상 입력해주세요.");
        }

    }


}
