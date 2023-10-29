package racingcar;

public class ExeptionProcess {

    public boolean isValidCarName(String name)
    {
        return name != null && !name.trim().isEmpty();
    }
}
