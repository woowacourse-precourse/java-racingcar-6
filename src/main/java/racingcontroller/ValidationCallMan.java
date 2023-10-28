package racingcontroller;

import racingmodel.MainModel;

class ValidationCallMan {
    private ValidationCallMan() {
    }

    static void callexExceptionCheckForCar(MainModel model) throws IllegalArgumentException
    {
        if (!model.saveName(InputMan.inputCarName())) {
            throw new IllegalArgumentException();
        }
    }

    static void callExceptionCheckForTimes(MainModel model, String times) throws IllegalArgumentException
    {
        if(!model.exceptionCheck(times))
        {
            throw new IllegalArgumentException();
        }
    }
}
