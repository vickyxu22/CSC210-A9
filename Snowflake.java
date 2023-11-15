import java.awt.*;
import javax.swing.*;

/**
*  A simple Java Swing component that draws a fractal snowflake.
*
*  @author Nicholas R. Howe
*  @version CSC 112, 29 March 2006
*/
class Snowflake extends JComponent {
  /** The rank of the snowflake */
  protected int rank;

  /** The size of the window */
  public static final int DIM = 600;

  /**
  *  Creates a Snowflake of specified size
  *
  *  @param rank Specifies the rank of the snowflake
  */
  public Snowflake(int rank) {
    this.rank = rank;
    Dimension winsize = new Dimension(DIM,3*DIM/4);
    setPreferredSize(winsize);
    setMinimumSize(winsize);
  }

  /**
  *  Draws an edge of the given rank between the given points.
  *
  *  @param rank  The rank of the snowflake
  *  @param p1    One endpoint of the snowflake
  *  @param p4    The other endpoint of the snowflake
  *  @param g     The graphics object to draw into
  */
  private void drawEdge(int rank, Point p1, Point p5, Graphics g) {
    // the other points of the snowflake:
    int dx = (p5.x-p1.x);
    int dy = (p5.y-p1.y);


    // WRITE THE RECURSIVE CODE HERE:

  }

  /**
  *  Draws the snowflake in the graphics window
  *
  *  @param g The graphics object to draw into
  */
  public void paintComponent(Graphics g) {
    Point p1 = new Point(DIM/4,DIM/4);
    Point p2 = new Point(3*DIM/4,DIM/4);
    Point p3 = new Point(DIM/2,(int)(DIM*0.683));
    drawEdge(rank,p1,p2,g);
    drawEdge(rank,p2,p3,g);
    drawEdge(rank,p3,p1,g);
  }

  /** Create a window with a snowflake in it */
  public static void createAndShowGUI(int rank) {
    // Make sure we have nice window decorations.
    JFrame.setDefaultLookAndFeelDecorated(true);

    // Create and set up the window.
    JFrame frame = new JFrame("Fractal Snowflake");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Add components
    Snowflake snowflake = new Snowflake(rank);
    frame.getContentPane().add(snowflake);

    // Display the window.
    frame.pack();
    frame.setVisible(true);
  }

  /** Call the window creation routine on the event thread */
  public static void main(String[] args) {
    int rank;
    if (args.length > 0) {
      rank = Integer.valueOf(args[0]);
    } else {
      rank = 5;
    }
    createAndShowGUI(rank);
  }
}  // end of Snowflake