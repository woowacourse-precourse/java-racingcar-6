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
import racingcar.util.parser.NameParser;
import racingcar.util.parser.NameParserImpl;
import racingcar.util.validator.name.NameValidator;
import racingcar.util.validator.name.NameValidatorImpl;
import racingcar.util.validator.proxy.InputValidator;
import racingcar.util.validator.proxy.ValidatorDecorator;
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
    private static NameParser nameParser;
    private static NameValidator nameValidator;
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
                    getNameParser(),
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

    public static NameParser getNameParser() {
        if (nameParser == null) {
            nameParser = new NameParserImpl();
            printLog(nameParser.getClass().toString(), NameParser.class.toString());
        }
        return nameParser;
    }

    public static NameValidator getNameValidator() {
        if (nameValidator == null) {
            nameValidator = new NameValidatorImpl();
            printLog(nameValidator.getClass().toString(), NameValidator.class.toString());
        }
        return nameValidator;
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
            inputValidator = new ValidatorDecorator();
            printLog(inputValidator.getClass().toString(), InputValidator.class.toString());
        }
        return inputValidator;
    }

    /* Log */
    private static void printLog(String className, String interfaceName) {
        System.out.println(
                "the instance of [" + className + "] is successfully created as an implementation of [" + interfaceName + "]"
        );
    }
}
