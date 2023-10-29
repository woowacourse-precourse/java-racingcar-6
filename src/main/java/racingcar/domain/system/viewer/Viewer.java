package racingcar.domain.system.viewer;


import java.util.List;

public interface Viewer {

    void print(String message);

    void print(GuideMessage message);

    void print(String carName, String position);

    void print(List<String> winners);
}
