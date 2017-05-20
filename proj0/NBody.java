public class NBody {

	public static double readRadius(String filename){
		In in = new In(filename);
		String skip = in.readLine();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String filename){
		In in = new In(filename);
		int numberOfPlanets = in.readInt();
		in.readString();
		Planet[] ps = new Planet[numberOfPlanets];
		for(int i = 0; i < numberOfPlanets; i++){
			double xC = in.readDouble();
			double yC = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double mass = in.readDouble();
			String imageName = in.readString();
			ps[i] = new Planet(xC, yC, xV, yV, mass, imageName);
		}
		return ps;
	}

	public static void main (String args[]){
	
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
	

		double radius = readRadius(filename);
		Planet[] ps = readPlanets(filename);

		// for (int i = 0; i < 400; i++){
		// 	System.out.println(ps[i]);
		// }

		for (int time = 0; time < T; time++){

			double[] xForces = new double[ps.length];

			for (int i = 0; i < xForces.length ;i++ ) {
				xForces[i] = ps[i].calcNetForceExertedByX(ps);
			}

			double[] yForces = new double[ps.length];

			for (int i = 0; i < yForces.length ;i++ ) {
				yForces[i] = ps[i].calcNetForceExertedByY(ps);
			}

			for (int i = 0; i < ps.length; i++){
				ps[i].update(dt, xForces[i], yForces[i]);
				// System.out.println(ps[i] + "\n" + i);
			}

			StdDraw.setScale(radius, radius);
			StdDraw.picture(0, 0, "./images/starfield.jpg");

			for (int i = 0; i < ps.length; i++) {
				Planet p = ps[i];
				p.draw();
				System.out.println(p);
			}
			StdDraw.show();

		}




		

	}
}
