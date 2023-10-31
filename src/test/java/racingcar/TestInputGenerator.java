package racingcar;

public class TestInputGenerator implements InputGenerator{

    @Override
    public String getInputNames() {
        return "hello,world,this,is,java";
    }

    @Override
    public String getInputNumber() {
        return "-100";
    }
}
