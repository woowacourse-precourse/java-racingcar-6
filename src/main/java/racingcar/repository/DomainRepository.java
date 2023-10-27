package racingcar.repository;

public class DomainRepository<T> {

    private T domain;

    public void save(final T domain) {
        this.domain = domain;
    }

    public T find() {
        return this.domain;
    }
}
