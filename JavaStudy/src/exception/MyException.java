package exception;

public class MyException extends RuntimeException{
    static final long serialVersionUID = -7034897190745723939L;

    public MyException() {

    }

    public MyException(String msg) {
        super(msg);
    }
}
