public class NBody {

    public static double readRadius(String filepath) {
        In in = new In(filepath);
        int numPlanets = in.readInt();
        double radiusUni = in.readDouble();
        return radiusUni;
    }

    //Enhanced for loops apply here

    public static Body[] readBodies(String filepath) {
        In in = new In(filepath);
        int numPlanets = in.readInt();
        double radiusUni = in.readDouble();
        Body[] bodys = new Body[numPlanets];
        for (int i = 0; i < numPlanets; i++) {
            bodys[i] = new Body(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return bodys;
    }

    public static void main(String[] args) {
        
        double T = 0;
        double dt = 0;

        try {
            // Parse the string argument into an integer value.
            T = Double.parseDouble(args[0]);
            dt = Double.parseDouble(args[1]);
        }
        catch (NumberFormatException nfe) {
            // The first two arguments aren't a valid integer.  Print
            // an error message, then exit with an error code.
            System.out.println("The first two arguments must be an integer.");
            System.exit(1);
        }

        String filename = args[2];
        
        Body[] bodies = NBody.readBodies(filename);
        double radius = NBody.readRadius(filename);
        
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (int i = 0; i < bodies.length; i++) {
            bodies[i].draw();
        }
        StdDraw.enableDoubleBuffering();

        for (double time = 0; time <= T; time += dt) {
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];

            for (int i = 0; i < bodies.length; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }

            for (int i = 0; i < bodies.length; i++) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i = 0; i < bodies.length; i++) {
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(5);
        }
    }
}