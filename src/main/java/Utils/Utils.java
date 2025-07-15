package Utils;

public class Utils {
    public final static String RESOURCE_PATH_SPRITES = "./Resoruces/Sprites";
    public final static String RESOURCE_PATH_ROOT = "./Resource";


    public static StringBuffer getMem() {

        String mem = "FreeMem: " + getMB(Runtime.getRuntime().freeMemory()) + "MB" + " MaxMem: " + getMB(Runtime.getRuntime().maxMemory()) + "MB" + " TotalMem: " + getMB(Runtime.getRuntime().totalMemory()) + "MB";
        return new StringBuffer(mem);
    }

    private static String getMB(long mem) {
        return String.valueOf((mem / 1024) / 1024);
    }
}
