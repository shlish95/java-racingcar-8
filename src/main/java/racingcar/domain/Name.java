package racingcar.domain;

public class Name {

    private final String value;

    public Name(String value) {
        if (value == null) {
            throw new IllegalArgumentException("자동차 이름은 null일 수 없습니다.");
        }

        if (value.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }

        if (value.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }

        this.value = value;
    }

    public String value() {
        return value;
    }

}
