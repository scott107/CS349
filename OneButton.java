import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OneButton{

    public static void main(String[] args) {
        JFrame outerframe = new JFrame("Click the Button");

        JButton noclick = new JButton("click me");
 
        noclick.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseEntered(MouseEvent evt){
        		noclick.setEnabled(false);
        	}
        	@Override
        	public void mouseExited(MouseEvent evt){
        		noclick.setEnabled(true);
        	}
        	@Override
        	public void mouseClicked(MouseEvent evt){
        		if (noclick.isEnabled()){
        			System.out.println("Plans for world button domination....Failed.");}
        		else
        			System.out.println("Valient effort, but you're too slow.");
        	}
        });

        Container contentPane = outerframe.getContentPane();
        contentPane.add(noclick, BorderLayout.SOUTH);

        outerframe.pack();
        outerframe.setSize(600, 600);
        outerframe.setVisible(true);

    }
}