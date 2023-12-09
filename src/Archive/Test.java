package Archive;

import java.awt.*;
import java.awt.event.*;

class GraphingCalculator extends Frame
{
	public static void main(String[] args)
	{
		new GraphingCalculator();
	}

	GraphingCalculator()
	{
		super("Graphing Calculator");

		// Terminate when window is closed
		addWindowListener
		(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
		setSize(410, 410);
		add("Center", new CvGraphingCalculator());
		setVisible(true);
	}

	class CvGraphingCalculator extends Canvas
	{   
        @Override
		public void paint(Graphics g) {
			Dimension d;
			int maxX, maxY;

			// get the size of the canvas
			d = getSize();

			maxX = d.width - 1;
			maxY = d.height - 1;
			
			this.drawPlane(g, maxX, maxY);
			this.paintLine(g, maxX, maxY, 10, 100);
		}

		public void paintLine(Graphics g, int maxX, int maxY, int scale, int resolution) {
			float x, y;
			g.translate(maxX / 2, maxY / 2);
			g.setColor(Color.RED);

			for (x = -(maxX / 2); x < maxX / 2; x += (float) .01 / resolution) {
				y = (float) - (x*x*x*x + 3*x -5);
				g.drawLine(Math.round(x * scale), Math.round(y * scale), Math.round(x * scale), Math.round(y * scale));
			}
		}

		public void drawPlane(Graphics g, int maxX, int maxY) {
			int midX = maxX / 2;
			int midY = maxY / 2;

			g.setColor(Color.BLACK);
			g.drawLine(0, midY, maxX, midY);
			g.drawLine(midX, 0, midX, maxY);
		}
	}
}