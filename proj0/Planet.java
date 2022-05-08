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

    }

    /**
     *
     * @param p
     * @return force between the planet and planet p in the y direction
     */
    public double calcForceExertedByY(Planet p) {

    }
}
