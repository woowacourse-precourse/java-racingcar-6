package racingcar.Utils;

import java.util.ArrayList;
import java.util.List;
import racingcar.Dto.CarDto;
import racingcar.Dto.RacingCarInfoDto;

public class DtoManager {
    private static boolean won = false;
    private final RacingCarInfoDto racingCarInfoDto = new RacingCarInfoDto();
    private final List<CarDto> carDtoList = new ArrayList<>();

    public List<String> getRacingCarDto() {
        return racingCarInfoDto.getCarNames();
    }

    public void setRacingCarDto(List<String> inputCarNames) {
        racingCarInfoDto.setCarNames(inputCarNames);
    }

    public int getRacingCount() {
        return racingCarInfoDto.getRacingCount();
    }

    public void setRacingCount(int racingCount) {
        racingCarInfoDto.setRacingCount(racingCount);
    }

    public List<CarDto> getCarDtoList() {
        return carDtoList;
    }

    public int getRacingCarCount() {
        return racingCarInfoDto.getRacingCarCount();
    }

    public void newRacingCar(String carName, int index) {
        carDtoList.add(new CarDto(carName, index));
    }

    public int getRacingCarInstanceCount() {
        return carDtoList.size();
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public CarDto getCarDtoByIndex(int index) {
        return carDtoList.get(index - 1);
    }
}
