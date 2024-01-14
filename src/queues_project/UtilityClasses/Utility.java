package queues_project.UtilityClasses;

public class Utility {
    public static double generateExponentialRandomVariable(double rate) {
        // Generate an exponential random variable using the inverse transform method
        return -Math.log(Math.random()) / rate;
    }

    public Utility() {
    }

    public static boolean isNumber(String str) {


        str = " " + str + " ";
        int counter = 0, len = str.length() - 2;

        for (int i = 1; i < str.length() - 1; i++) {

            char c = str.charAt(i);


            if (c >= '0' && c <= '9' || c == '-')
                counter++;


            else if (c == '.' && (str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9' || str.charAt(i - 1) >= '0' && str.charAt(i - 1) <= '9'))
                counter++;

            else if (c == '/' && (str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9' && str.charAt(i - 1) >= '0' && str.charAt(i - 1) <= '9'))
                counter++;


            else break;

        }

        return (counter == len);

    }


    public static double convertToNumber(String str) {

        //find there is a / or not....
        int indexOfBslash = str.indexOf('/');

        if (indexOfBslash == -1) {
            double result = Double.valueOf(str);
            return Double.valueOf(String.format("%.16f", result));

        } else {
            String div1 = str.substring(0, (indexOfBslash));
            String div2 = str.substring(indexOfBslash + 1);

            double div11 = Double.valueOf(div1);
            double div22 = Double.valueOf(div2);

            double result = div11 / div22;
            return Double.valueOf(String.format("%.16f", result));
        }
    }

    public static int System_Type(int c, int k) {
        if (c == 1 && k == -1) return 1;
        else if (c == 1 && k >= 1) return 2;
        else if (c > 1 && k == -1) return 3;
        else if (c > 1 && k >= 1) return 4;
        else return 5;
    }

    public static boolean checkNumbersOrNot(String s1) {
        return isNumber(s1);
    }

    public static boolean isEmpty(String s1, String s2, String s3, String s4) {
        if (s1 == null || s3 == null || s3 == null || s4 == null) return false;
        return true;
    }

}
