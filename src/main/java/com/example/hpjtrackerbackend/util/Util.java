package com.example.hpjtrackerbackend.util;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
public class Util {
    LocalDate today = LocalDate.now();

    public boolean validateForPostAndPut(List<Object> list, RequestMethod requestMethod) throws Exception {
        if (requestMethod == RequestMethod.POST && !list.isEmpty()) {
            throw new Exception("Already exists");
        } else if (requestMethod == RequestMethod.PUT && list.isEmpty()) {
            throw new Exception("Does not exist");
        }
        return true;
    }
}
