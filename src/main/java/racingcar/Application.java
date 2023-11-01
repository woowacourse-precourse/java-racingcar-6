package racingcar;

import camp.nextstep.edu.missionutils.Console;
import domain.CarControl;
import domain.WinnerAnnouncement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();
        String[] carNames = input.split(",");
        List<String> players = Arrays.asList(carNames);

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        CarControl carControl = new CarControl();
        carControl.createCarLocationMap(players);
        System.out.println("시도할 회수는 몇회인가요?");

        String userInput = (Console.readLine());
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }

        int attemptsNumber = Integer.parseInt(userInput);
        WinnerAnnouncement winnerAnnouncement = new WinnerAnnouncement();
        System.out.println("실행 결과");
        for (int i = 0; i < attemptsNumber; i++) {
            carControl.updateCarLocations();
            HashMap<String, Integer> carData = carControl.getCarLocations();
            for (String car : carData.keySet()) {
                int location = carData.get(car);
                System.out.println(car + " : " + ("-".repeat(location)));
            }
            System.out.println();
        }
        HashMap<String, Integer> carData = carControl.getCarLocations();
        winnerAnnouncement.setCarData(carData);
        winnerAnnouncement.winnerDecision();
        List<String> winners = winnerAnnouncement.getWinner();
        System.out.println("최종 우승자 " + String.join(", ", winners));

    }
}
