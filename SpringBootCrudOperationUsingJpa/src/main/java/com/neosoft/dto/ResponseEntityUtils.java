package com.neosoft.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityUtils {

        public static ResponseEntity<ResponseDTO> get(Object object, String message) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(object, message));
        }

}
