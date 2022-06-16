package pro.sky.skyprospringarraylist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MyArrayIndexOutOfBoundsException extends RuntimeException {
    public MyArrayIndexOutOfBoundsException() {}
}