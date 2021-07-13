import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.vertx.core.json.JsonObject;
import io.vertx.junit5.VertxExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDateTime;

@ExtendWith(VertxExtension.class)
public class LocalDateTimeMappingTest {

    @Test
    void testLocalDateTime() {
        io.vertx.core.json.jackson.DatabindCodec.mapper()
                .registerModule(new JavaTimeModule());

        LocalDateTime ldt = LocalDateTime.now();

        ThePojo pojo = new ThePojo();
        pojo.setTimestamp(ldt);

        JsonObject jo = new JsonObject()
                .put("timestamp", ldt);

        JsonObject joCopy = JsonObject.mapFrom(pojo);

        Object ts1 = jo.getValue("timestamp");
        Object ts2 = joCopy.getValue("timestamp");

        assert jo.getValue("timestamp") instanceof LocalDateTime;
        assert joCopy.getValue("timestamp") instanceof LocalDateTime; // is String
    }

}
