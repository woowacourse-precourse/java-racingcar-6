package racingcar.model.service;

import static racingcar.messages.ViewMessage.INPUT_SEPARATOR;

import racingcar.dto.Car;
import racingcar.model.dao.CarDao;
import racingcar.model.dao.CarDaoImpl;
import racingcar.validator.InputValidator;

public class CarServiceImpl implements CarService {
    private static CarService instance = new CarServiceImpl();
    private InputValidator validator = InputValidator.getInstance();
    private CarDao carDao = CarDaoImpl.getInstance();

    private CarServiceImpl() {}
    public static CarService getInstance() {
        return instance;
    }

    @Override
    public void registerCarLineUp(String carNames) {
        validator.validateNameDuplication(carNames);
        validator.validateNameLengthRange(carNames);

        String[] names = carNames.split(INPUT_SEPARATOR);
        for (String name : names) {
            carDao.insertCar(new Car(name.strip()));
        }
    }

    @Override
    public void registerTryCount(String tryCount) {
        validator.validateInteger(tryCount);
        int tryNumber = Integer.parseInt(tryCount);
        validator.validatePositiveNumber(tryNumber);

        carDao.insertTryCount(tryNumber);
    }
}
