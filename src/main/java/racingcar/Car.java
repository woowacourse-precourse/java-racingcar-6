package racingcar;

import static racingcar.Constants.*;

import java.security.SecureRandom;

public class Car {
    private String name;
    private String forward;

    public Car(String name) {
        this.name = name;
        this.forward = EMPTY_STRING;
        if (name.isBlank()) {
            this.name = makeRandomName();
        }
    }

    public String getName() {
        return this.name;
    }

    public String getForward() {
        return this.forward;
    }

    public Integer getForwardNumber() {
        return this.forward.length();
    }

    public void addForward() {
        this.forward += FORWARD_SIGH;
    }

    private static String makeRandomName() {
        String characters = UPPER_CASE;
        StringBuilder sb = new StringBuilder(RANDOM_NAME_LENGTH);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < RANDOM_NAME_LENGTH; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
