package racingcar.Model.Car;
public class IdInteger implements Id<Integer>{
    private Integer id;

    public IdInteger(int id) {
        this.id = id;
    }
    @Override
    public Integer idRange() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Integer generateId(Integer value) {
        return null;
    }

}
