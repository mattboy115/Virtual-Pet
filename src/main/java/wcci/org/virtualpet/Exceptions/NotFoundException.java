package wcci.org.virtualpet.Exceptions;

public class NotFoundException extends Exception {
    public NotFoundException(Long id) {
        super("Pet not found. Pet has been adopted or is no longer in the shelter.");
    }
}
