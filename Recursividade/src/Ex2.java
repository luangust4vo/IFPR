public class Ex2 {
    public static void main(String[] args) {
        double[] array = {1, 2, 3, 4, 5};
        System.out.println(sum(array, array.length));
    }

    public static double sum(double[] array, int index) {
        if (index <= 0) return 0;

        return sum(array, index - 1) + array[index - 1];
    }
}
