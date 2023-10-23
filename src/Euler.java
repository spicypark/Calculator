public class Euler {
    public interface TwoFunctionable{
        public double func(double x, double y);
    }

    public interface Functionable{
        public double func(double input);
    }

    public static double[] eulerMethod(Functionable func, int stop, double step, double start){
        double pointer = 0;
        double pointer2 = 0;
        double pointerCords[] = {0, start};
        double slope = func.func(0);
        while (pointer < stop){
            pointerCords[0] = pointerCords[0] + step;
            pointerCords[1] = slope * (pointerCords[0] - pointer) + pointer2;

            pointer = pointerCords[0];
            pointer2 = pointerCords[1];

            slope = func.func(pointer);

        }
        return pointerCords;
    }

    public static double[] eulerTwo(TwoFunctionable func, double[] start, double stop, double step){
        double pointerX = start[0];
        double pointerY = start[1];
        double slope = func.func(pointerX, pointerY);

        while (pointerX < stop){
            pointerY = slope * ((pointerX + step) - pointerX) + pointerY;
            pointerX += step;
            slope = func.func(pointerX, pointerY);

            System.out.println(pointerX + " " + pointerY + " | " + slope);
        }

        return new double[] {pointerX, pointerY};

    }

    public static void printArray(double[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
