package racingcar.view;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.model.RacingCarGame;

public class RacingCarGameView implements RepeatingGameView {
    private final Properties messageProperties = new Properties();

    public RacingCarGameView(String messagePath) {
        try (FileInputStream file = new FileInputStream(messagePath)) {
            messageProperties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("메시지 로드 오류", e);
        }
    }

    @Override
    public void showInputRequiredMessage() {
        System.out.println(messageProperties.get("car-name-input"));
    }

    @Override
    public void showRepeatingNumberRequiredMessage() {
        System.out.println(messageProperties.get("repeating-number-input"));
    }

    @Override
    public void showProgressOf(Game game) {
        List<Car> carList = ((RacingCarGame) game).getCarList();
        StringBuilder progress = new StringBuilder();

        for (Car car : carList) {
            progress.append(car.getName())
                    .append(" : ")
                    .append(((String) messageProperties.get("progress-bar")).repeat(car.getPosition()))
                    .append("\n");
        }
    }
}
