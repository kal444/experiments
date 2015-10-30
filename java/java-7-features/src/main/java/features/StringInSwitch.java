package features;

import java.util.Arrays;
import java.util.List;

/**
 * @author kal
 */
public class StringInSwitch {
    public static void main(String[] args) {
        final List<String> strings = Arrays.asList("ONE", "HUH", "TWO", "THREE");
        for (String string : strings) {
            switch (string) {
                case "ONE":
                    System.out.println(string);
                    break;
                case "TWO":
                    System.out.println(string);
                    break;
                case "THREE":
                    System.out.println(string);
                    break;
                default:
                    System.out.println(string);
            }
        }
    }
}
