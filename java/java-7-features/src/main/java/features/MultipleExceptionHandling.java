package features;

/**
 * @author kal
 */
public class MultipleExceptionHandling {

    static class ExceptionOne extends Exception {
    }

    static class ExceptionTwo extends Exception {
    }

    public static void main(String[] args) {
        try {
            rethrowExceptionExample();
        } catch (ExceptionOne | ExceptionTwo e) {
            /*
            catch block with | symbol to catch more than 1 exception
             */
            e.printStackTrace();
        }
    }

    public static void rethrowExceptionExample() throws ExceptionOne, ExceptionTwo {
        try {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new ExceptionOne();
            } else {
                throw new ExceptionTwo();
            }
        } catch (Exception e) {
            // re-throw
            /*
            compiler is smarter now. It knows that we are rethrowing with the possibilities of 2 types of exceptions.
            pre-java7, the method's signature throws clause will only allow Exception and the more detailed 
            exception classes are swallowed.
             */
            throw e;
        }
    }
}
