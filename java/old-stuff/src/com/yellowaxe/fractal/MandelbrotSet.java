package com.yellowaxe.fractal;

public class MandelbrotSet {

    private final static int MAX_ITERATION = 1000;

    public static void main(String[] args) {
        int xbegin = 0, ybegin = 0;
        int xend = 99, yend = 99;
        int numx = xend - xbegin + 1;
        int numy = yend - ybegin + 1;

        for (int py = ybegin; py <= yend; py++) {
            for (int px = xbegin; px <= xend; px++) {
                // for each pixels on the canvas

                // Scale the pixel location to be +- 2 from the origin of the
                // complex plane
                double x0 = (px * (4.0 / numx)) - 2.0;
                double y0 = (py * (4.0 / numy)) - 2.0;

                double x = x0;
                double y = y0;

                int iteration = 0;

                while (x * x + y * y <= 2 * 2 && iteration < MAX_ITERATION) {
                    double xprime = x * x - y * y + x0;

                    y = 2 * x * y + y0;

                    x = xprime;

                    iteration++;
                }

                if (iteration == MAX_ITERATION) {
                    // didn't escape, in the mandelbrot set
                    // can color based on distance from the center
                    System.out.print("*");
                } else {
                    // escaped, can color by iteration
                    System.out.print("-");
                }

                if (px == xend) {
                    System.out.println();
                }
            }
        }
    }
}
