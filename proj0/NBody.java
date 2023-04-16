public class NBody {
	public static double readRadius(String imgFileName) {
		In in = new In(imgFileName);

		int N = in.readInt();
		double radius = in.readDouble();

		return radius;
	}

	public static Planet[] readPlanets(String imgFileName) {
		In in = new In(imgFileName);

		int N = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[N];

		for(int i = 0; i < N; i ++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFile = in.readString();

			Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFile);

			planets[i] = p;
		}

		return planets;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		In in = new In(filename);

		int N = in.readInt();
		double radius = NBody.readRadius(filename);
		Planet[] planets = NBody.readPlanets(filename);

        double time = 0;



        for( ; time < T; time += dt) {
        	double[] xForces = new double[5];
        	double[] yForces = new double[5];
        	
        	for(int i = 0; i < N; i ++) {
        		double F = 0;

        		Planet p = planets[i];
        		F = p.calcNetForceExertedByX(planets);
        		xForces[i] = F;
        	}

        	for(int i = 0; i < N; i ++) {
        		double F = 0;

        		Planet p = planets[i];
        		F = p.calcNetForceExertedByY(planets);
        		yForces[i] = F;
        	}

        	for(int i = 0; i < N; i ++) {
        		Planet p = planets[i];
        		p.update(dt, xForces[i], yForces[i]);
        	}



        	// StdDraw.setCanvasSize(700, 700);
			StdDraw.setScale(-1 * radius , radius);

        	String imageToDraw = "images/starfield.jpg";
        	StdDraw.picture(0, 0, imageToDraw, radius*2, radius*2);
        	StdDraw.show();

        	for(int i = 0; i < N; i ++) {
        		Planet p = planets[i];
        		p.draw();
        	}

        	StdDraw.show();

        	StdDraw.pause(10);
        }

        // StdDraw.enableDoubleBuffering();

        StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    	StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}

	}
}