package codegen.test.mapper;

import java.time.ZonedDateTime;

public class MyMappers {

    public static String serialize(ZonedDateTime date) {
        return date.toString();
    }

    public static ZonedDateTime deserialize(String s) {
        return ZonedDateTime.parse(s);
    }
}