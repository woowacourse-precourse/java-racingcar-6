package racingcar;

public class CarFactory {
    private static int productionQuantity;

    public static MyCar[] production(String[] carName) {

        productionQuantity = carName.length;
        MyCar[] objects = new MyCar[productionQuantity];

        for (int i = 0; i < productionQuantity; i++) {
            objects[i] = new MyCar(i, carName[i]);
        }
        return objects;
    }

    public static int getProductionQuantity() {
        return productionQuantity;
    }

}