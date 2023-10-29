package domain;

public interface ForwardStrategy<T> {

    boolean canMove(T input);

}
