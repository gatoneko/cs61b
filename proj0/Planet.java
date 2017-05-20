public class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	double gConst = 6.67e-11;


	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		this(p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, 
			p.imgFileName);
	}

	public void update(double dt, double fX, double fY){
		xxVel = calcVelocityX(dt, fX);
		yyVel = calcVelocityY(dt, fY);
		xxPos = calcPositionX(dt, fX);
		yyPos = calcPositionY(dt, fY);
	}

	public double calcPositionX(double dt, double fX){
		double result = xxPos + dt * xxVel;
		return result;
	}

	public double calcPositionY(double dt, double fY){
		double result = yyPos + dt * yyVel;
		return result;
	}

	public double calcVelocityX(double dt, double fX){
		double result = xxVel + dt * calcAccelerationX(fX);
		return result;
	}

	public double calcVelocityY(double dt, double fY){
		double result = yyVel + dt * calcAccelerationY(fY);
		return result;
	}

	public double calcAccelerationX(double fX){
		double result = fX / mass;
		return result;
	}

	public double calcAccelerationY(double fY){
		double result = fY / mass;
		return result;
	}	


	/**
	* todo: add documentation
	*/
	public double calcDistance(Planet p){
		double xDist = calcDistanceX(p);
		double yDist = calcDistanceY(p);
		xDist = xDist * xDist;
		yDist = yDist * yDist;
		double result = Math.sqrt(xDist + yDist);
		return result;
	}

	public double calcDistanceX(Planet p){
		double result = p.xxPos - xxPos;
		return result;
	}

	public double calcDistanceY(Planet p){
		double result = p.yyPos - yyPos;
		return result;
	}

	/**
	* todo: add documentation
	*/
	public double calcForceExertedBy(Planet p){
		double dist = calcDistance(p);
		double result = (gConst * mass * p.mass) / (dist * dist);
		return result;
	}

	public double calcForceExertedByX(Planet p){
		double dist = calcDistanceX(p);
		double result = calcForceExertedBy(p) * dist / calcDistance(p);
		return result;
	}

	public double calcForceExertedByY(Planet p){
		double dist = calcDistanceY(p);
		double result = calcForceExertedBy(p) * dist / calcDistance(p);
		return result;
	}

	public double calcNetForceExertedByX(Planet[] ps){
		double result = 0;
		for (int i = 0; i < ps.length; i++){
			double individualForceX = 0;
			individualForceX = calcForceExertedByX(ps[i]);

			if (this.equals(ps[i])){
				individualForceX = 0;
			}
			result += individualForceX;
		}
		return result;
	}

	public double calcNetForceExertedByY(Planet[] ps){
		double result = 0;
		for (int i = 0; i < ps.length; i++){
			double individualForceY = 0;
			individualForceY = calcForceExertedByY(ps[i]);

			if (this.equals(ps[i])){
				individualForceY = 0;
			}
			result += individualForceY;
		}
		return result;	
	}

	public String toString(){ 
		return "name: " + imgFileName + "\n" + "xxPos = " + xxPos +
		" yyPos = " + yyPos +
		" xxVel = " + xxVel +
		" yyVel = " + yyVel;
	}

	public void draw(){
		StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
	}
}
