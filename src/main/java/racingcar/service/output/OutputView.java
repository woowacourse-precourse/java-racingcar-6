package racingcar.service.output;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.output.CarOutputDto;
import racingcar.dto.output.CarsOutputDto;

public class OutputView implements Output{
    @Override
    public void showPlaying(CarsOutputDto carsOutputDto) {
        showCarNameAndPosition(carsOutputDto);
    }

    @Override
    public void showResult(CarsOutputDto carsOutputDto) {
        Cars cars = carsOutputDto.cars();
        int max = cars.getCarList().get(0).getCarPosition();
        ResultList resultList = new ResultList();
        for(Car car : cars.getCarList()){
            if(car.getCarPosition()>max){
                max = car.getCarPosition();
                resultList.getResults().clear();
                resultList.getResults().add(car.getCarName());
            }else if(car.getCarPosition()==max){
                resultList.getResults().add(car.getCarName());
            }
        }
        System.out.print("최종 우승자 : ");
        for(int i = 0; i < resultList.getResults().size();i++){
            System.out.print(resultList.getResults().get(i));
            if (i < resultList.getResults().size()-1){
                System.out.print(", ");
            }
        }
        System.out.println();
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
