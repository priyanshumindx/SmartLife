package SmartLife;

public class NetworkService {
    public void connectToServer(int networkChoice , int serverChoice) throws NetworkUnavailableException , ServerTimeoutException{

        System.out.println("Connecting to server.");
        if(networkChoice == 2){
            throw new NetworkUnavailableException("Internet Connection is Unavailable.");
        }

        for(int attempt=1 ; attempt <= 3 ; attempt++){

            try {
                boolean success = serverChoice ==1 || (serverChoice == 3 && attempt ==3);

                if(!success){
                    throw new ServerTimeoutException("Server Timeout.");
                }

                if(attempt == 1){
                    System.out.println("Server Connected Successfully.");
                }

                else{
                    System.out.println("Attempt " +attempt+ ": Server Connected Successfully.");
                }

                return;
            }
            catch (ServerTimeoutException e){
                System.out.println("Attempt " +attempt+ "failed: " +e.getMessage());

                if(attempt == 3){
                    throw e;
                }
            }
        }
    }

}
