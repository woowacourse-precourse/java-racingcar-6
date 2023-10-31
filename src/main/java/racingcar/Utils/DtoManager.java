package racingcar.Utils;

import java.util.ArrayList;
import java.util.List;
import racingcar.Dto.CarDto;
import racingcar.Dto.RacingCarInfoDto;

public class DtoManager {
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

    public void newRacingCar(String carName) {
        carDtoList.add(new CarDto(carName));
    }

    public int getRacingCarInstanceCount() {
        return carDtoList.size();
    }

    public CarDto getCarDto(int index) {
        return carDtoList.get(index);
    }
}
