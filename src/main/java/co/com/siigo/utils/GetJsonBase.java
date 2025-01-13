package co.com.siigo.utils;

import co.com.siigo.enums.JsonBaseRequest;
import co.com.siigo.exceptions.InvalidJsonFileException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetJsonBase {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode loadJsonFromFile(JsonBaseRequest jsonBaseMessage) {
        String filePath = jsonBaseMessage.getFilePath();
        Path path;

        try {
            path = Paths.get(filePath);
            validateFile(path);

            return objectMapper.readTree(path.toFile());

        } catch (InvalidPathException e) {
            throw new InvalidJsonFileException("Invalid file path: " + filePath, e);
        } catch (IOException e) {
            throw new InvalidJsonFileException("Error reading JSON file: " + filePath, e);
        } catch (Exception e) {
            throw new InvalidJsonFileException("Error processing JSON file: " + filePath, e);
        }
    }

    private static void validateFile(Path path) {
        if (!Files.exists(path)) {
            throw new InvalidJsonFileException("File not found: " + path.toString());
        }
        if (!Files.isRegularFile(path)) {
            throw new InvalidJsonFileException("Path is not a regular file: " + path.toString());
        }
    }
}
