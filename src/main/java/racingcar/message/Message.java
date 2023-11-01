package racingcar.message;

import java.util.List;

public class Message {

    public static Message instance;

    private Message() {}

    public static Message getInstance() {
        if (instance == null)
            instance = new Message();

        return instance;
    }


    public void printPromptCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printPromptNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRaceResult() {
        System.out.println("\n실행 결과");
    }

    public void printRace(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println(" ");
    }

    public void printWinner(List<String> winners) {
        String str = "최종 우승자 : ";
        for (String winner : winners) {
            str = str.concat(winner);
            str = str.concat(",");
        }

        System.out.println(str.substring(0, str.length()-1));
    }

}
