package racingcar.service.output;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.output.CarOutputDto;
import racingcar.dto.output.CarsOutputDto;
import racingcar.util.message.Printer;

public class OutputView implements Output{
    private final static int ZERO = 0;
    @Override
    public void showPlaying(CarsOutputDto carsOutputDto) {
        showCarNameAndPosition(carsOutputDto);
    }

    @Override
    public void showResult(CarsOutputDto carsOutputDto) {
        printingWinners(comparingResult(carsOutputDto.cars(), carsOutputDto.cars().getCarList().get(0).getCarPosition()));
    }

    private static void printingWinners(ResultList resultList) {
        Printer.finalWinner();
        printingNames(resultList);
    }

    private static void printingNames(ResultList resultList) {
        for(int i = ZERO; i < resultList.getResults().size(); i++){
            printingOneWinner(resultList, i);
        }
    }

    private static void printingOneWinner(ResultList resultList, int i) {
        Printer.nowWinner(resultList.getResults().get(i));
        checkNumberOfPrintingNames(resultList, i);
    }

    private static void checkNumberOfPrintingNames(ResultList resultList, int i) {
        if (isNotFinished(resultList, i)){
            Printer.comma();
        }
    }

    private static boolean isNotFinished(ResultList resultList, int i) {
        return i < resultList.getResults().size() - 1;
    }

    private static ResultList comparingResult(Cars cars, int max) {
        ResultList resultList = new ResultList();
        resultListIterate(cars, max, resultList);
        return resultList;
    }

    private static void resultListIterate(Cars cars, int max, ResultList resultList) {
        for(Car car : cars.getCarList()){
            max = comparingWithMax(max, resultList, car);
        }
    }

    private static int comparingWithMax(int max, ResultList resultList, Car car) {
        if(isBiggerThenCurrantMax(max, car)){
            max = foundMax(resultList, car);
        }else if(isSameWithCurrentMax(max, car)){
            foundSame(resultList, car);
        }
        return max;
    }

    private static boolean isSameWithCurrentMax(int max, Car car) {
        return car.getCarPosition() == max;
    }

    private static boolean isBiggerThenCurrantMax(int max, Car car) {
        return car.getCarPosition() > max;
    }

    private static void foundSame(ResultList resultList, Car car) {
        resultList.getResults().add(
                car.getCarName()
        );
    }

    private static int foundMax(ResultList resultList, Car car) {
        int max = car.getCarPosition();
        resultList.getResults().clear();
        resultList.getResults().add(car.getCarName());
        return max;
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
        printPosition(carOutputDto);
        Printer.switchLine();
    }


    private static void printPosition(CarOutputDto carOutputDto) {
        for(int i = ZERO; i< carOutputDto.car().getCarPosition();i++){
            Printer.positionDash();
        }
    }

    private static void printName(CarOutputDto carOutputDto) {
        Printer.carName(carOutputDto.car().getCarName());
    }
}
