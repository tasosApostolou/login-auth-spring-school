package gr.aueb.cf.springauthsession1.service.exceptions;

import java.io.Serial;

public class StudentAlreadyExistsException extends Exception{
    @Serial
    private static final long serialVersionUID = 2L;

    public StudentAlreadyExistsException(Class<?> entityClass, String username) {
        super("Entity " + entityClass.getSimpleName() + " with username " + username + " already exists.");
    }
}
