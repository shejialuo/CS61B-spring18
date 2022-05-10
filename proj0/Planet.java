public class Planet {
    /** Its current x position */
    public double xxPos;
    /** Its current y position */
    public double yyPos;
    /** Its current velocity in the x direction */
    public double xxVel;
    /** Its current velocity in the y direction */
    public double yyVel;
    /** Its mass */
    public double mass;
    /** The name of the file that corresponds to the
     * image that depicts the planet */
    public String imgFileName;

    /**
     *
     * @param xP  x position
     * @param yP  y position
     * @param xV  velocity in the x direction
     * @param yV  velocity in the y direction
     * @param m   mass
     * @param img name of the file
     */
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        this.xxPos = xP; this.yyPos = yP;
        this.xxVel = xV; this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    /**
     *
     * @param p planet object
     */
    public Planet(Planet p) {
        this.xxPos = p.xxPos; this.yyPos = p.yyPos;
        this.xxVel = p.xxVel; this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /**
     *
     * @param p planet object
     * @return distance between the planet and planet p
     */
    public double calcDistance(Planet p) {
        double diffXXPos = this.xxPos - p.xxPos;
        double diffYYPos = this.yyPos - p.yyPos;
        return Math.sqrt(diffXXPos * diffXXPos + diffYYPos * diffYYPos);
    }

    /**
     *
     * @param p planet object
     * @return force between the planet and planet p
     */
    public double calcForceExertedBy(Planet p) {
        double G = 6.67E-11;
        return G * this.mass * p.mass / (calcDistance(p) * calcDistance(p));
    }

    /**
     *
     * @param p planet object
     * @return force between the planet and planet p in the x direction
     */
    public double calcForceExertedByX(Planet p) {
        double xOffset = p.xxPos - this.xxPos;
        return calcForceExertedBy(p) * (xOffset / calcDistance(p));
    }

    /**
     *
     * @param p
     * @return force between the planet and planet p in the y direction
     */
    public double calcForceExertedByY(Planet p) {
        double yOffset = p.yyPos - this.yyPos;
        return calcForceExertedBy(p) * (yOffset / calcDistance(p));
    }

    /**
     *
     * @param p planet object array
     * @return force in the network in the x direction
     */
    public double calcNetForceExertedByX(Planet[] p) {
        double result = 0;
        for(Planet e: p) {
            if(this.equals(e)) {
                continue;
            }
            result += calcForceExertedByX(e);
        }
        return result;
    }

    /**
     *
     * @param p planet object array
     * @return force in the network in the x direction
     */
    public double calcNetForceExertedByY(Planet[] p) {
        double result = 0;
        for(Planet e: p) {
            if(this.equals(e)) {
                continue;
            }
            result += calcForceExertedByY(e);
        }
        return result;
    }

    /**
     *
     * @param time
     * @param xForce
     * @param yForce
     */
    public void update(double time, double xForce, double yForce) {
        double ax = xForce / this.mass;
        double ay = yForce / this.mass;

        this.xxVel = this.xxVel + time * ax;
        this.yyVel = this.yyVel + time * ay;

        this.xxPos = this.xxPos + time * this.xxVel;
        this.yyPos = this.yyPos + time * this.yyVel;
    }

    /**
     *
     */
    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
