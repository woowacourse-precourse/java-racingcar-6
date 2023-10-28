package racingcar.container;

import racingcar.console.Console;
import racingcar.console.ConsoleImpl;
import racingcar.controller.RaceController;
import racingcar.controller.RaceControllerImpl;
import racingcar.domain.participant.ParticipantFactory;
import racingcar.domain.participant.ParticipantFactoryImpl;
import racingcar.service.RaceService;
import racingcar.service.RaceServiceImpl;
import racingcar.util.generator.RandomNumberGenerator;
import racingcar.util.generator.RandomNumberGeneratorImpl;
import racingcar.util.parser.CarNameParser;
import racingcar.util.parser.CarNameParserImpl;
import racingcar.util.validator.carName.CarNameValidator;
import racingcar.util.validator.carName.CarNameValidatorImpl;
import racingcar.util.validator.proxy.InputValidator;
import racingcar.util.validator.proxy.ValidatorProxy;
import racingcar.util.validator.raceCount.RaceCountValidator;
import racingcar.util.validator.raceCount.RaceCountValidatorImpl;

public class ApplicationContainer {
    /* Console */
    private static Console console;

    /* Controller */
    private static RaceController raceController;

    /* Service */
    private static RaceService raceService;

    /* Factory */
    private static ParticipantFactory participantFactory;

    /* Util */
    private static RandomNumberGenerator randomNumberGenerator;
    private static CarNameParser carNameParser;
    private static CarNameValidator carNameValidator;
    private static RaceCountValidator raceCountValidator;
    private static InputValidator inputValidator;

    /* Getter */
    public static Console getConsole() {
        if (console == null) {
            console = new ConsoleImpl();
            printLog(console.getClass().toString(), Console.class.toString());
        }
        return console;
    }

    public static RaceController getRaceController() {
        if (raceController == null) {
            raceController = new RaceControllerImpl(getConsole(), getRaceService());
            printLog(raceController.getClass().toString(), RaceController.class.toString());
        }
        return raceController;
    }

    public static RaceService getRaceService() {
        if (raceService == null) {
            raceService = new RaceServiceImpl(
                    getInputValidator(),
                    getCarNameParser(),
                    getParticipantFactory(),
                    getRandomNumberGenerator()
            );
            printLog(raceService.getClass().toString(), RaceService.class.toString());
        }
        return raceService;
    }

    public static ParticipantFactory getParticipantFactory() {
        if (participantFactory == null) {
            participantFactory = new ParticipantFactoryImpl();
            printLog(participantFactory.getClass().toString(), ParticipantFactory.class.toString());
        }
        return participantFactory;
    }

    public static RandomNumberGenerator getRandomNumberGenerator() {
        if (randomNumberGenerator == null) {
            randomNumberGenerator = new RandomNumberGeneratorImpl();
            printLog(randomNumberGenerator.getClass().toString(), RandomNumberGenerator.class.toString());
        }
        return randomNumberGenerator;
    }

    public static CarNameParser getCarNameParser() {
        if (carNameParser == null) {
            carNameParser = new CarNameParserImpl();
            printLog(carNameParser.getClass().toString(), CarNameParser.class.toString());
        }
        return carNameParser;
    }

    public static CarNameValidator getCarNameValidator() {
        if (carNameValidator == null) {
            carNameValidator = new CarNameValidatorImpl();
            printLog(carNameValidator.getClass().toString(), CarNameValidator.class.toString());
        }
        return carNameValidator;
    }

    public static RaceCountValidator getRaceCountValidator() {
        if (raceCountValidator == null) {
            raceCountValidator = new RaceCountValidatorImpl();
            printLog(raceCountValidator.getClass().toString(), RaceCountValidator.class.toString());
        }
        return raceCountValidator;
    }

    public static InputValidator getInputValidator() {
        if (inputValidator == null) {
            inputValidator = new ValidatorProxy(getCarNameValidator(), getRaceCountValidator());
            printLog(inputValidator.getClass().toString(), InputValidator.class.toString());
        }
        return inputValidator;
    }

    /* Log */
    private static void printLog(String className, String interfaceName) {
        System.out.println(
                "the instance of " + className + " is successfully created as an implementation of " + interfaceName
        );
    }
}
