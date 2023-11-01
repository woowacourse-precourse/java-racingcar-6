package racingcar.domain.system.viewer;


import java.util.List;
import racingcar.domain.core.car.CarName;

public class ConsoleViewer implements Viewer {

    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void print(GuideMessage message) {
        print(message.getMessage());
    }

    @Override
    public void print(CarName carName, String position) {
        print(carName.getName() + " : " + position);
    }

    @Override
    public void print(List<CarName> winners) {
        List<String> winnerNames = winners.stream()
            .map(CarName::getName)
            .toList();
        print(WINNER_MESSAGE_PREFIX + String.join(", ", winnerNames));
    }
}
