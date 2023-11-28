package com.neosoft.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static com.neosoft.dto.msgconstatants.GeneralMsg.MSG_FAILED;
import static com.neosoft.dto.msgconstatants.GeneralMsg.MSG_SUCCESS;

@NoArgsConstructor
@Data
public class ResponseDTO<T> {

        private int status = HttpStatus.OK.value();
        private String message = MSG_SUCCESS;
        //private HttpStatus error= HttpStatus.BAD_REQUEST;
        private T data;


        public ResponseDTO(T data, String message) {
            this.data = data;
            this.message = message;

    }
}
