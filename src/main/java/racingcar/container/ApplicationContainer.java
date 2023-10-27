package racingcar.container;

import racingcar.console.Console;
import racingcar.console.ConsoleImpl;
import racingcar.controller.RaceController;
import racingcar.controller.RaceControllerImpl;
import racingcar.domain.participant.ParticipantFactory;
import racingcar.domain.participant.ParticipantFactoryImpl;
import racingcar.domain.race.RaceFactory;
import racingcar.domain.race.RaceFactoryImpl;
import racingcar.service.RaceService;
import racingcar.service.RaceServiceImpl;
import racingcar.util.generator.RandomNumberGenerator;
import racingcar.util.generator.RandomNumberGeneratorImpl;
import racingcar.util.parser.CarNameParser;
import racingcar.util.parser.CarNameParserImpl;
import racingcar.util.validator.CarNameValidator;
import racingcar.util.validator.CarNameValidatorImpl;
import racingcar.util.validator.RaceCountValidator;
import racingcar.util.validator.RaceCountValidatorImpl;

public class ApplicationContainer {
    /* Console */
    private Console console;

    /* Controller */
    private RaceController raceController;

    /* Service */
    private RaceService raceService;

    /* Factory */
    private ParticipantFactory participantFactory;
    private RaceFactory raceFactory;

    /* Util */
    private RandomNumberGenerator randomNumberGenerator;
    private CarNameParser carNameParser;
    private CarNameValidator carNameValidator;
    private RaceCountValidator raceCountValidator;

    /* Getter */
    public Console getConsole() {
        if ( console == null ) {
            console = new ConsoleImpl();
            printLog(console.getClass().toString(), Console.class.toString());
        }
        return console;
    }

    public RaceController getRaceController() {
        if ( raceController== null ) {
            raceController = new RaceControllerImpl(getConsole(), getRaceService());
            printLog(raceController.getClass().toString(), RaceController.class.toString());
        }
        return raceController;
    }

    public RaceService getRaceService() {
        if ( raceService == null ) {
            raceService = new RaceServiceImpl(
                    getCarNameValidator(),
                    getRaceCountValidator(),
                    getCarNameParser(),
                    getParticipantFactory(),
                    getRandomNumberGenerator()
            );
            printLog(raceService.getClass().toString(), RaceService.class.toString());
        }
        return raceService;
    }

    public ParticipantFactory getParticipantFactory() {
        if ( participantFactory == null ) {
            participantFactory = new ParticipantFactoryImpl();
            printLog(participantFactory.getClass().toString(), ParticipantFactory.class.toString());
        }
        return participantFactory;
    }

    public RaceFactory getRaceFactory() {
        if ( raceFactory == null ) {
            raceFactory = new RaceFactoryImpl();
            printLog(raceFactory.getClass().toString(), RaceFactory.class.toString());
        }
        return raceFactory;
    }

    public RandomNumberGenerator getRandomNumberGenerator() {
        if ( randomNumberGenerator == null ) {
            randomNumberGenerator = new RandomNumberGeneratorImpl();
            printLog(randomNumberGenerator.getClass().toString(), RandomNumberGenerator.class.toString());
        }
        return randomNumberGenerator;
    }

    public CarNameParser getCarNameParser() {
        if ( carNameParser == null ) {
            carNameParser = new CarNameParserImpl();
            printLog(carNameParser.getClass().toString(), CarNameParser.class.toString());
        }
        return carNameParser;
    }

    public CarNameValidator getCarNameValidator() {
        if ( carNameValidator == null ) {
            carNameValidator = new CarNameValidatorImpl();
            printLog(carNameValidator.getClass().toString(), CarNameValidator.class.toString());
        }
        return carNameValidator;
    }

    public RaceCountValidator getRaceCountValidator() {
        if ( raceCountValidator == null ) {
            raceCountValidator = new RaceCountValidatorImpl();
            printLog(raceCountValidator.getClass().toString(), RaceCountValidator.class.toString());
        }
        return raceCountValidator;
    }

    /* Log */
    private void printLog(String className, String interfaceName) {
        System.out.println("the instance of " + className + " is successfully created as an implementation of " + interfaceName);
    }
}
