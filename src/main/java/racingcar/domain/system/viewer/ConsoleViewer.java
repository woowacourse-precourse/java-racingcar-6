package racingcar.domain.system.viewer;


import java.util.List;

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
    public void print(String carName, String position) {
        print(carName + " : " + position);
    }

    @Override
    public void print(List<String> winners) {
        print(WINNER_MESSAGE_PREFIX + String.join(", ", winners));
    }
}
