package org.finclutech.dashboard.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class CustomLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    private static final List<DateTimeFormatter> FORMATS = Arrays.asList(
            DateTimeFormatter.ISO_DATE_TIME,
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss a"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
    );

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String dateStr = p.getText().trim().replace(" PM", "PM").replace(" AM", "AM");

        for (DateTimeFormatter format : FORMATS) {
            try {
                return LocalDateTime.parse(dateStr, format);
            } catch (Exception e) {
            }
        }

        try {
            return LocalDateTime.parse(dateStr.replaceAll("(?i)\\s?(AM|PM)$", ""), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        } catch (Exception e) {
            throw new JsonProcessingException("Unparseable date: \"" + dateStr + "\". Supported formats: " + FORMATS + " or faulty AM/PM usage detected.") {};
        }
    }
}
