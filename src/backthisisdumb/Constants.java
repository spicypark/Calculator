package backthisisdumb;

public class Constants {
    public static class Version {
        public static final String UID = "v3.0.0";
        public static final int VX = 179;
        public static final int VY = 330;
    }

    public static class Graphing {
        public static final int X_CENTER = 194;
        public static final int Y_CENTER = 171;
        public static final int X_MAX = 389;
        public static final int Y_MAX = 343;
        public static final double X_SCALE = 0.1;
        public static final double Y_SCALE = 10;
    }
    
    public static class Conversion {
        public static final double[][] LENGTH_CONVERSION_TABLE = {
            {1, 0.393701, 0.01, 0.0328084, 0.00001, 0.00000621371},//CM
            {2.54, 1, 0.0254, 0.0833333, 0.0000254, 0.0000157828},//IN
            {100, 39.3701, 1, 3.28084, 0.001, 0.000621371},//M
            {30.48, 12, 0.3048, 1, 0.0003048, 0.000189394},//FT
            {100000, 39370.1, 1000, 3280.84, 1, 0.621371},//KM
            {160934, 63360, 1609.34, 5280, 1.60934, 1},//MI
        };
        public static final double[][] MASS_CONVERSION_TABLE = {
            {1, 2.20462, 1000, 35.274},//KG
            {0.453592, 1, 453.592, 16},//LB
            {0.001, 0.00220462, 1, 0.035274},//G
            {0.0283495, 0.0625, 28.3495, 1},//OZ
        };
        public static final double[][] VOLUME_CONVERSION_TABLE = {
            {1, 0.264172},//L
            {3.78541, 1},//G
        };
    }
}