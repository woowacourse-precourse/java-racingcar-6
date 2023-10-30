package racingcar;

public class IOManager {

    private static IOManager ioManager;

    private IOManager() {
    }

    public static IOManager getInstance() {
        if (ioManager == null) {
            ioManager = new IOManager();
        }
        return ioManager;
    }
}
