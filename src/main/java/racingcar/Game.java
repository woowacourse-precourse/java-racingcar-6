package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> playingCar = new ArrayList<>();
    private int playTime = 0;

    private int winnerPosition = 0;

    public void startGame() {
        String input;
        String inputPlayTime;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = Console.readLine();

        List<String> parsedInput = parsingInput(input);
        System.out.println("시도할 회수는 몇회인가요?");
        inputPlayTime = Console.readLine();
        validateInput(inputPlayTime);
        setPlayingCar(parsedInput);

        runGame();
    }

    public void runGame() {
        System.out.println("\r\n실행결과");
        for (int playingNow = 0; playingNow < playTime; playingNow++) {
            stepProgress();
            printPosition();
        }
        printResult();
    }

    public void stepProgress() {
        for (Car car : playingCar) {
            int randomValue = generateRandomValue();
            if (randomValue > 3) {
                car.move();
                if (car.getPosition() > winnerPosition) {
                    winnerPosition = car.getPosition();
                }
            }
        }
    }

    public void printResult() {
        String result = "최종 우승자 : ";
        for (Car car : playingCar) {
            if (car.getPosition() == winnerPosition) {
                result += (car.getCarName() + ", ");
            }
        }
        result = result.substring(0, result.length() - 2);
        System.out.println(result);
    }

    public void printPosition() {
        for (Car car : playingCar) {
            System.out.println(car);
        }
        System.out.println();
    }


    public List<String> parsingInput(String input) {
        String deleteSpaceInput = input.replace(" ", "");
        List<String> parsedInput = List.of(deleteSpaceInput.split(","));
        validateInput(parsedInput);
        return parsedInput;
    }

    public void validateInput(List<String> parsedInput) {
        for( String data : parsedInput){
            if(data.length() > 5){
                throw new IllegalArgumentException(" player 이름이 5글자가 넘음 ");
            }
        }
    }

    public void validateInput(String inputPlaytime) {
        int integerPlayTime;
        try {
            integerPlayTime = Integer.parseInt(inputPlaytime);
        } catch (Error e) {
            throw new IllegalArgumentException(" playTime 입력값이 숫자가아님 ");
        }
        setPlayTime(integerPlayTime);
    }

    public void setPlayTime(int inputPlayTime) {
        this.playTime = inputPlayTime;
    }

    public void setPlayingCar(List<String> parsedInput) {
        for (String name : parsedInput) {
            playingCar.add(new Car(name));
        }
    }

    public int generateRandomValue() {
        return Randoms.pickNumberInRange(1, 9);
    }

}
