public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        in.readInt();
        return in.readDouble();
    }
    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int length = in.readInt();
        Planet[] result = new Planet[length];
        in.readDouble();
        for(int i = 0; i < length; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planet p = new Planet(xP, yP, xV, yV, m, img);
            result[i] = p;
        }
        return result;
    }
    public static void main(String args[]) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] p = readPlanets(filename);

        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.enableDoubleBuffering();

        double t = 0;
        int length = p.length;
        while(t <= T){
            double[] xForces = new double[length];
            double[] yForces = new double[length];
            for(int i = 0; i < length; i++){
                xForces[i] = p[i].calcNetForceExertedByX(p);
                yForces[i] = p[i].calcNetForceExertedByY(p);
            }
            for(int i = 0; i < length; i++){
                p[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");

            for (Planet e : p) {
                e.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }
        StdOut.printf("%d\n", length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < length; i++) {
              StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
              p[i].xxPos, p[i].yyPos, p[i].xxVel,
              p[i].yyVel, p[i].mass, p[i].imgFileName);
        }
    }
}
