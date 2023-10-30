package util;

import service.CarMoveService;
import service.CarRacingWinnerService;
import service.UserInputCarMoveCountFactory;
import service.UserInputCarNameFactory;

public class BeanFactory {

    private static CarMoveService carMoveService;
    private static CarRacingWinnerService carRacingWinnerService;
    private static UserInputCarNameFactory userInputCarNameFactory;
    private static UserInputCarMoveCountFactory userInputCarMoveCountFactory;

    public static CarMoveService getInstanceCarMoveService(){
        if(carMoveService==null) carMoveService = new CarMoveService();
        return carMoveService;
    }

    public static CarRacingWinnerService getInstanceCarRacingWinnerService(){
        if(carRacingWinnerService==null) carRacingWinnerService = new CarRacingWinnerService();
        return carRacingWinnerService;
    }

    public static UserInputCarMoveCountFactory getInstanceUserInputCarMoveCountFactory(){
        if(userInputCarMoveCountFactory==null) userInputCarMoveCountFactory = new UserInputCarMoveCountFactory();
        return userInputCarMoveCountFactory;
    }

    public static UserInputCarNameFactory getInstanceUserInputCarNameFactory(){
        if(userInputCarNameFactory==null) userInputCarNameFactory = new UserInputCarNameFactory();
        return userInputCarNameFactory;
    }
}
