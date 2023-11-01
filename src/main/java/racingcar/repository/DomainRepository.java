package racingcar.repository;

import racingcar.constant.ErrorMessage;

import java.util.Optional;

public class DomainRepository<T> {

    private T domain;

    public void save(final T domain) {
        this.domain = domain;
    }

    public T get() {
        return Optional.ofNullable(this.domain)
                .orElseThrow(
                        () -> new IllegalStateException(ErrorMessage.NOT_INITIALIZED.toValue()));
    }
}
