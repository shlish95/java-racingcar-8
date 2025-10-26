package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameParser {

    private NameParser() {}

    public static List<Name> parse(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }

        List<String> tokens = Arrays.stream(str.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        if (tokens.isEmpty() || tokens.stream().anyMatch(name -> name.isEmpty())) {
            throw new IllegalArgumentException("자동차 이름에 빈 값은 허용되지 않습니다.");
        }

        return tokens.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }
}
