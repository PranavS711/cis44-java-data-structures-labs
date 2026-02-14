public class Main {
    public static void main(String[] args) {
        // make two 2x3 matrices and fill them with random numbers
        Matrix a = new Matrix(2, 3);
        Matrix b = new Matrix(2, 3);
        a.populateRandom();
        b.populateRandom();

        System.out.println("Matrix A:");
        System.out.println(a);

        System.out.println("Matrix B:");
        System.out.println(b);

        // add them (same size so this should work)
        Matrix sum = a.add(b);
        System.out.println("A + B:");
        System.out.println(sum);

        // multiply example: (2x3) * (3x2) works
        Matrix c = new Matrix(3, 2);
        c.populateRandom();

        System.out.println("Matrix C:");
        System.out.println(c);

        Matrix product = a.multiply(c);
        System.out.println("A * C:");
        System.out.println(product);

        // show exception handling (bad add)
        try {
            Matrix wrongAdd = new Matrix(3, 3);
            System.out.println("Trying to add A + wrongAdd...");
            Matrix bad = a.add(wrongAdd);
            System.out.println(bad); // shouldn’t get here
        } catch (IllegalArgumentException e) {
            System.out.println("Caught add error: " + e.getMessage());
        }

        // show exception handling (bad multiply)
        try {
            Matrix wrongMult = new Matrix(4, 4);
            System.out.println("Trying to multiply A * wrongMult...");
            Matrix bad2 = a.multiply(wrongMult);
            System.out.println(bad2); // shouldn’t get here
        } catch (IllegalArgumentException e) {
            System.out.println("Caught multiply error: " + e.getMessage());
        }
    }
}

