package co.com.siigo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserFields {

    ID("id"),
    NAME("name"),
    JOB("job");

    private final String field;
}