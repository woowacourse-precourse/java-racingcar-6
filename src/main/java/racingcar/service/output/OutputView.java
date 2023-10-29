package racingcar.service.output;

import racingcar.domain.Car;
import racingcar.dto.output.CarOutputDto;
import racingcar.dto.output.CarsOutputDto;

public class OutputView implements Output{
    @Override
    public void show(CarsOutputDto carsOutputDto) {
        showCarNameAndPosition(carsOutputDto);
    }

    private static void showCarNameAndPosition(CarsOutputDto carsOutputDto) {
        for(Car car: carsOutputDto.cars().getCarList()){
            showOneCarNameAndPosition(car);
        }
    }

    private static void showOneCarNameAndPosition(Car car) {
        printNameAndPosition(new CarOutputDto(car));
    }

    private static void printNameAndPosition(CarOutputDto carOutputDto) {
        printName(carOutputDto);
        printPostion(carOutputDto);
        switchLine();
    }

    private static void switchLine() {
        System.out.print("\n");
    }

    private static void printPostion(CarOutputDto carOutputDto) {
        for(int i = 0; i< carOutputDto.car().getCarPosition();){
            System.out.print("-");
        }
    }

    private static void printName(CarOutputDto carOutputDto) {
        System.out.printf("%s : ", carOutputDto.car().getCarName());
    }
}
