package racingcar.view;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
}
