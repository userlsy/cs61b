public class Planet {
	private static final double G = 6.67e-11;

	public double xxPos;  // Its current x position
	public double yyPos;  // Its current y position
	public double xxVel;  // Its current velocity(速度) in the x direction.
	public double yyVel;  // Its current velocity in the y direction.
	public double mass;  // Its mass(质量).
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
		double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	// 计算 当前 行星和 p 行星之间的距离
	public double calcDistance(Planet p) {
		double dx = p.xxPos - this.xxPos ;
		double dy = p.yyPos - this.yyPos;
		double r = Math.sqrt(dx * dx + dy * dy);

		return r;
	}

	// 计算 p 行星对 当前 行星的作用力
	public double calcForceExertedBy(Planet p) {
		double r = this.calcDistance(p);

		return G * this.mass * p.mass / (r * r);
	}

	// 计算 p 行星在 x 方向上对 当前 行星的作用力
	public double calcForceExertedByX(Planet p) {
		double r = this.calcDistance(p);
		double dx = p.xxPos - this.xxPos;
		double F = this.calcForceExertedBy(p);

		return F * dx / r;
	}

	// 计算 p 行星在 y 方向上对 当前 行星的作用力
	public double calcForceExertedByY(Planet p) {
		double r = this.calcDistance(p);
		double dy = p.yyPos - this.yyPos;
		double F = this.calcForceExertedBy(p);

		return F * dy / r;
	}

	// 计算 多个 行星在 x 方向上对 当前 行星的作用力之和
	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double F = 0;

		for(Planet p : allPlanets) {
			if(this.equals(p)) continue;

			F += this.calcForceExertedByX(p);
		}

		return F;
	}

	// 计算 多个 行星在 y 方向上对 当前 行星的作用力之和
	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double F = 0;

		for(Planet p : allPlanets) {
			if(this.equals(p)) continue;

			F += this.calcForceExertedByY(p);
		}

		return F;
	}

	// 在 x 方向上力 fX 和 y 方向上力 fY 的作用下,dt时间内 该行星的速度和坐标变化
	public void update(double dt, double fX, double fY) {
		double aX = fX / this.mass;
		double aY = fY / this.mass;

		this.xxVel = this.xxVel + dt * aX;
		this.yyVel = this.yyVel + dt * aY;

		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}

	// 让行星可以在适当的位置绘制自己
	public void draw() {
		// double radi = NBody.readRadius(filename);

        // StdDraw.setScale(-1 * radi , radi);
		// StdDraw.setXscale(-500, radius );
        // StdDraw.setYscale(-500, radius );

		// NOTE!!!!!
        String imageToDraw = "images/"+this.imgFileName;  
        StdDraw.picture(this.xxPos, this.yyPos, imageToDraw);

        StdDraw.show();
	}

}	
