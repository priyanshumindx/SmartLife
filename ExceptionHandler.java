package SmartLife;

public class ExceptionHandler {
    public static void handleException(Exception e){

        if(e instanceof UnsupportedOSException){
            System.out.println("Error: " +e.getMessage());
        }

        else if(e instanceof InsufficientStorageException){
            System.out.println("Error: " +e.getMessage());
        }

        else if(e instanceof NetworkUnavailableException){
            System.out.println("Error: "+e.getMessage());
        }
        else if(e instanceof ApplicationStartException) {
            System.out.println("Error: "+e.getMessage());
            System.out.println("Please try again later");
        }

        else{
            System.out.println("Error: An unexpected error occurred.");
        }
    }

}
