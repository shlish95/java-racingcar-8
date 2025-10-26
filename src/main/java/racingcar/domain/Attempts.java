package racingcar.domain;

public class Attempts {

    private final int value;

    public Attempts(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("시도 횟수를 입력해 주세요.");
        }

        final int n;
        try {
            n = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        if (n <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        this.value = n;
    }

    public int value() {
        return value;
    }
}
