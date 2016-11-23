package zyr.learn.mvc.model;

/**
 * Created by zhouweitao on 2016/11/20.
 */
public class UserException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }
}
