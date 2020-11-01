public class SetUp {
    public static String chrome = "src\\test\\resources\\chromedriver.exe";
    public static String firefox = "src\\test\\resources\\geckodriver.exe";
    /**
     * Platform = 0, so we use chrome, otherwise we use firefox
     */
    public static int Platform = 0;

    public static String getChrome() {
        return chrome;
    }

    public static void setChrome(String chrome) {
        SetUp.chrome = chrome;
    }

    public static int getPlatform() {
        return Platform;
    }

    public static String getFirefox() {
        return firefox;
    }

    public static void setFirefox(String firefox) {
        SetUp.firefox = firefox;
    }

    public static void setPlatform(int platform) {
        Platform = platform;
    }
}


