package co.com.siigo.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.*;
import com.github.javafaker.Faker;

import java.util.Iterator;
import java.util.Map;

import static co.com.siigo.enums.UserFields.JOB;
import static co.com.siigo.enums.UserFields.NAME;

public class JsonRandomizer {

    private JsonRandomizer() {
    }

    private static final Faker faker = new Faker();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode randomizeJson(JsonNode originalNode) {
        if (originalNode.isObject()) {
            ObjectNode randomizedObject = objectMapper.createObjectNode();
            Iterator<Map.Entry<String, JsonNode>> fields = originalNode.fields();

            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                randomizedObject.set(entry.getKey(), randomizeValue(entry.getKey(), entry.getValue()));
            }
            return randomizedObject;

        } else if (originalNode.isArray()) {
            ArrayNode randomizedArray = objectMapper.createArrayNode();
            for (JsonNode item : originalNode) {
                randomizedArray.add(randomizeValue(null, item));
            }
            return randomizedArray;

        } else {
            return randomizeValue(null, originalNode);
        }
    }

    private static JsonNode randomizeValue(String key, JsonNode node) {
        if (node.isTextual()) {
            if (key != null) {
                if (key.toLowerCase().contains(NAME.getField())) {
                    return TextNode.valueOf(faker.name().fullName());
                } else if (key.toLowerCase().contains(JOB.getField())) {
                    return TextNode.valueOf(faker.job().title());
                }
            }
            return TextNode.valueOf(faker.lorem().word());

        } else if (node.isInt() || node.isLong()) {
            return IntNode.valueOf(faker.number().numberBetween(1, 1000));

        } else if (node.isDouble() || node.isFloat()) {
            return DoubleNode.valueOf(faker.number().randomDouble(2, 1, 1000));

        } else if (node.isBoolean()) {
            return BooleanNode.valueOf(faker.bool().bool());

        } else if (node.isObject() || node.isArray()) {
            return randomizeJson(node);

        } else {
            return node;
        }
    }
}