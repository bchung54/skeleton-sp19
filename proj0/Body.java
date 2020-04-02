import java.lang.Math;

public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double G = 6.67e-11;

    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        return Math.sqrt(Math.pow(this.xxPos - b.xxPos, 2) + Math.pow(this.yyPos - b.yyPos, 2));
    }

    public double calcForceExertedBy(Body b) {
        return G * mass * b.mass / Math.pow(calcDistance(b), 2);
    }

    public double calcForceExertedByX(Body b) {
        return calcForceExertedBy(b) * (b.xxPos - xxPos) / calcDistance(b);
    }

    public double calcForceExertedByY(Body b) {
        return calcForceExertedBy(b) * (b.yyPos - yyPos) / calcDistance(b);
    }


// Come back for enhanced for loops


    public double calcNetForceExertedByX(Body[] bodys) {
        double netForceX = 0;
        for (int i = 0; i < bodys.length; i++) {
            if (!this.equals(bodys[i])) {
                netForceX += this.calcForceExertedByX(bodys[i]);
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Body[] bodys) {
        double netForceY = 0;
        for (int i = 0; i < bodys.length; i++) {
            if (!this.equals(bodys[i])) {
                netForceY += this.calcForceExertedByY(bodys[i]);
            }
        }
        return netForceY;
    }

    public void update(double dt, double xF, double yF) {
        double xA = xF / this.mass;
        double yA = yF / this.mass;
        this.xxVel += dt * xA;
        this.yyVel += dt * yA;
        this.xxPos += dt * xxVel;
        this.yyPos += dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}