package racingcar;

public class Printer {
    public static void GameResultPrinter(RaceParticipants raceParticipants) {
//        System.out.println("실행 결과");
        for (Car car : raceParticipants.getParticipantList()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
