package racingcar.Service;

import java.util.ArrayList;
import java.util.List;
import racingcar.Dto.CarDto;
import racingcar.Model.EndGameDetector;
import racingcar.Model.InputCarNameValidator;
import racingcar.Model.InputCountValidator;
import racingcar.Model.MidPrint;
import racingcar.Model.RandomPickNumber;
import racingcar.Utils.DtoManager;

public class RacingCarService {
    private static InputCarNameValidator nameValidator = InputCarNameValidator.getInstance();
    private static InputCountValidator countValidator = InputCountValidator.getInstance();
    private static final int OVER_NUMBER = 4;
    private static DtoManager dtoManager = new DtoManager();

    public static void userInputRacingCar(String userInput) {
        List<String> validateUserInput = nameValidator.validateNameBeforeSplit(userInput);
        nameValidator.validateNameAfterSplit(validateUserInput);
        dtoManager.setRacingCarDto(validateUserInput);
    }

    public static void userInputCount(String racingCount) {
        int validateRacingCount = countValidator.validateCount(racingCount);
        dtoManager.setRacingCount(validateRacingCount);
    }

    public void initGame() {
        for (int i = 0; i < getRacingCarCount(); i++) {
            dtoManager.newRacingCar(dtoManager.getRacingCarDto().get(i), i + 1);
        }
    }

    public String getGameWinner() {
        List<String> winner = new ArrayList<>();
        for (int i = 1; i <= getRacingCarCount(); i++) {
            isWinner(getCarDtoByIndex(i), winner);
        }
        return winners(winner);
    }

    private String winners(List<String> winner) {
        return String.join(", ", winner);
    }

    private void isWinner(CarDto carDto, List<String> winner) {
        if (carDto.isWon()) {
            winner.add(carDto.getCarName());
        }
    }

    public void play() {
        // cars playing (random number)
        List<Integer> plusCars = carPlaying();
        // set cars position
        setCarPosition(plusCars);
        // set cars Won state
        isCarState(plusCars);
    }

    private List<Integer> carPlaying() {
        List<Integer> plusCars = new ArrayList<>();
        for (int i = 0; i < getRacingCarCount(); i++) {
            isPlusCar(getCarDtoList().get(i), plusCars);
        }
        return plusCars;
    }

    private void isPlusCar(CarDto carDto, List<Integer> plus) {
        if (getRandomNumber() >= OVER_NUMBER) {
            plus.add(carDto.getIndex());
        }
    }

    private void setCarPosition(List<Integer> plusCars) {
        for (int i = 0; i < plusCars.size(); i++) {
            plusPostion(plusCars.get(i));
        }
    }

    private void plusPostion(int index) {
        getCarDtoByIndex(index).plusPosition();
    }

    private void isCarState(List<Integer> plusCars) {
        for (int i = 0; i < plusCars.size(); i++) {
            isCarWin(plusCars.get(i));
        }
    }

    private void isCarWin(int index) {
        if (getPositionByIndex(index) >= getRacingCount()) {
            getCarDtoByIndex(index).setWon(true);
            setWon(true);
        }
    }

    private int getPositionByIndex(int index) {
        return getCarDtoByIndex(index).getPosition();
    }

    private int getRacingCount() {
        return dtoManager.getRacingCount();
    }

    private CarDto getCarDtoByIndex(int index) {
        return dtoManager.getCarDtoByIndex(index);
    }

    private void setWon(boolean won) {
        EndGameDetector.setWon(won);
    }

    public boolean isWon() {
        return EndGameDetector.isWon();
    }

    public List<CarDto> getCarDtoList() {
        return dtoManager.getCarDtoList();
    }

    public int getRacingCarCount() {
        return dtoManager.getRacingCarCount();
    }

    public static int getRandomNumber() {
        return RandomPickNumber.getRandomPickNumber();
    }

    public String makeMidPrint() {
        return MidPrint.make(getCarDtoList());
    }
}
