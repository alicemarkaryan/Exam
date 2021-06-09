package url_manage;

public class UrlSetter {

    private static String url;
    public static void setUrl(){
        String TEST_RUN_EMV=System.getProperty("env");
        if(TEST_RUN_EMV== null)
            throw new RuntimeException("ERROR: NO enviroment is set");
       url = switch (TEST_RUN_EMV){
            case "dev" -> "https://staff.am";
            case "staging" -> "https://stage.staff.am";
            default -> throw new RuntimeException("ERROR :Wrong environment"+TEST_RUN_EMV);
        };

    }
    public static String getUrl(){
    return url;
    }
}
