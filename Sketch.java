import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Sketch{

	public static void main(String[] args) {
		JFrame frame = new DrawThings();

		frame.setVisible(true);
	}
}

class DrawThings extends JFrame{

	private ArrayList<Point> SavedDrawing = new ArrayList<Point>();
	private JButton Clear = new JButton("Clear");
	private JPanel Bottom = new JPanel();

	public DrawThings(){
        setTitle("Java Sketcher");
        setSize(600, 600);
        
		Container contentPane = getContentPane();
		
		DrawArea doodle = new DrawArea();
		contentPane.add(doodle, BorderLayout.CENTER);
		
		Bottom.add(Clear);
		Bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		contentPane.add(Bottom, BorderLayout.SOUTH);
		Clear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent evt) {
				SavedDrawing.clear();	
				repaint();
			}
		});
				
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });
	}

	class DrawArea extends JPanel{
		public DrawArea(){
			this.addMouseListener(new MouseAdapter(){
				@Override
	        	public void mousePressed(MouseEvent evt){
	        		SavedDrawing.add(evt.getPoint());
	        	}
				@Override
	        	public void mouseReleased(MouseEvent evt){
	        		SavedDrawing.add(evt.getPoint());
	        		SavedDrawing.add(null);
	        		repaint();
	        	}
			});
			this.addMouseMotionListener(new MouseAdapter(){
				@Override
	        	public void mouseDragged(MouseEvent evt){
	        		SavedDrawing.add(evt.getPoint());
	        		repaint();
	        	}
			});
			
		}
		@Override
		public void paintComponent (Graphics g){
			//super.paintComponent(g);
			setBackground(Color.WHITE);
			
			Graphics2D graph = (Graphics2D) g;
			graph.setStroke(new BasicStroke(2));
			
			for (int i = 0; i < (SavedDrawing.size() - 1); i++) {
				if (SavedDrawing.get(i) != null && SavedDrawing.get(i + 1) != null) {
					graph.drawLine(SavedDrawing.get(i).x, SavedDrawing.get(i).y, SavedDrawing.get(i + 1).x,SavedDrawing.get(i + 1).y);
				}
			}
		}
	}

}

