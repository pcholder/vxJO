import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;

public class vxJOLaunch {


    public static void main(String[] args) {

        io.vertx.core.json.jackson.DatabindCodec.mapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        LocalDateTime ldt = LocalDateTime.now();

        ThePojo pojo = new ThePojo();
        pojo.setTimestamp(ldt);

        JsonObject jo = new JsonObject()
                .put("timestamp", ldt);

        JsonObject joCopy = JsonObject.mapFrom(pojo);

        Object timeObjectFromJson = jo.getValue("timestamp");
        Object timeObjectFromPojo = joCopy.getValue("timestamp");

        System.out.println("[");
        System.out.println("Object from json: " + timeObjectFromJson.getClass().getCanonicalName());
        System.out.println("Object from pojo: " + timeObjectFromPojo.getClass().getCanonicalName());
        System.out.println("]");
    }
}
