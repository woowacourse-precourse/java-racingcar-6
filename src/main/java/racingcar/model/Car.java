package racingcar.model;

import org.junit.platform.commons.util.StringUtils;

import static racingcar.type.MessageType.*;

/**
 * @Class : 자동차 클래스
 */
public class Car {

    private String name;
    private int position;

    public Car(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Car name cannot be null, empty, or only whitespace");
        }
        this.name = name;
        this.position = 0;
    }

    public void go() {
        this.position++;
    }

    public String getPositionMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(COLON.getMessage());
        sb.append(ADVANCE.getMessage().repeat(position));
        return sb.toString();
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
