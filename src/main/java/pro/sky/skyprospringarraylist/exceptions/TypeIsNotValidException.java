package pro.sky.skyprospringarraylist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class TypeIsNotValidException extends RuntimeException {
    public TypeIsNotValidException(){}
}
