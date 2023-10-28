package racingcontroller;

import racingmodel.MainModel;

public class ValidationCallMan {
    private ValidationCallMan() {
    }

    public static void callexExceptionCheckForCar(MainModel model) throws IllegalArgumentException
    {
        if (!model.saveName(InputMan.inputCarName())) {
            throw new IllegalArgumentException();
        }
    }

    public static void callExceptionCheckForTimes(MainModel model, String times) throws IllegalArgumentException
    {
        if(!model.exceptionCheck(times))
        {
            throw new IllegalArgumentException();
        }
    }
}
