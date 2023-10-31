package view;

import java.util.List;
import model.domain.Car;
import model.domain.Participant;

public class Output {

    public static void startResult() {

        System.out.println("\n실행 결과");

    }

    public static void roundResult(Participant participant) {

        for (Car car : participant.getParticipant()) {
            System.out.print(car.getName() + " : ");

            for (int i = 0; i < car.getGo(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void finalResult(List<String> winner) {

        System.out.println("최종 우승자 : " + String.join(", ", winner));

    }

}
