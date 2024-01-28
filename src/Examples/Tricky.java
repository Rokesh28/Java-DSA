package Examples;

public class Tricky {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Tricky tr = new Tricky();
		Point pnt1 = tr.new Point(0,0);
		Point pnt2 = tr.new Point(0,0);
		System.out.println("X: " + pnt1.x + " Y: " +pnt1.y);
		System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
		System.out.println(" ");
		tricky(pnt1,pnt2);
		System.out.println("pnt1 and pnt2 are:");
		System.out.println("X: " + pnt1.x + " Y:" + pnt1.y);
		System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);

	}
	
	public static void tricky(Point arg1, Point arg2)
	{
	arg1.x = 100;
	arg1.y = 100;
	Point temp = arg1;
	arg1 = arg2;
	arg2 = temp;
	}
	
	public class Point {
		int x;
		int y;
		
		public Point(int xi, int yi)
		{
			x = xi;
			y = yi;
					
		}
	}
	

}


