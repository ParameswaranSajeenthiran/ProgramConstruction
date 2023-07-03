public class TimeTester {

    public void test1(double [] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * Math.sqrt(Math.PI/2);
        }
    }

    public void test2(double [] array) {
        double factor = Math.sqrt(Math.PI/2);
        for (int i = 0; i < array.length; i++) {
            array[i] = i * factor;
        }
    }

    public void test3(double [] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * Math.sqrt((Math.PI+123456)/2);
        }
    }

    public void test4(double [] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * Math.sqrt((Math.PI+i)/2);
        }
    }

    public double power(double b, int e) {
        double t = 0; t += b;
        if (e < 1)
            return 1;
        else if (e == 1)
            return b;
        else
            return b * power(b,e-1);
    }

    public double power2(double b, int e) {
        double pwr = 1;
        double t = 0;
        for (int i = 0; i < e; i++)
            pwr = pwr * b;
        t += b;
        return pwr;
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int count = Integer.parseInt(args[1]);
        int testNo = Integer.parseInt(args[2]);
        double array[] = new double[size];
        TimeTester tt = new TimeTester();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            switch (testNo) {
                case 1: tt.test1(array); break; // run different tests by editing here
                case 2: tt.test2(array); break;
                case 3: tt.test3(array); break;
                case 4: tt.test4(array); break;
            }
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        if (count > 0)
            System.out.println(elapsedTime/count);

    }
}
