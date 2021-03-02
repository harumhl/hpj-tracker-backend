package com.example.hpjtrackerbackend.util;

import com.example.hpjtrackerbackend.HpjException;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.ZoneId;

@NoArgsConstructor
@Data
public class Util {
    LocalDate today = LocalDate.now(ZoneId.of("America/Chicago"));

    public boolean validateForPostAndPut(int elementCount, RequestMethod requestMethod) throws HpjException {
        if (requestMethod == RequestMethod.POST && elementCount > 0) {
            throw new HpjException(HttpStatus.BAD_REQUEST, "Already exists");
        } else if (requestMethod == RequestMethod.PUT && elementCount == 0) {
            throw new HpjException(HttpStatus.BAD_REQUEST, "Does not exist");
        }
        return true;
    }

    public LocalDate getDate(String date) {
        if ("today".equals(date)) {
            return today;
        } else if (date.length() == 5) { // expecting MM-DD, assuming current year
            return LocalDate.of(today.getYear(),
                    Integer.parseInt(date.substring(0, 2)),
                    Integer.parseInt(date.substring(3, 5)));
        } else if (date.length() == 10) { // expecting YYYY-MM-DD
            return LocalDate.of(Integer.parseInt(date.substring(0, 4)),
                    Integer.parseInt(date.substring(5, 7)),
                    Integer.parseInt(date.substring(8, 10)));
        } else {
            return null;
        }
    }
}
