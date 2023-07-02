package progremmerbeginner.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JsonArrayTest {
    @Test
    void testJsonArray() throws JsonProcessingException {

        List<String> hobbies = List.of(
                "coding","podcast","sport"
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(hobbies);

        System.out.println(json);
    }

    @Test
    void readJsonArray() throws JsonProcessingException {
        String json = """
                ["coding","podcast","sport"]
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        List<String> hobbies = objectMapper.readValue(json, new TypeReference<List<String>>() {
        });

        Assertions.assertEquals(List.of("coding","podcast","sport"),hobbies);
    }
}
