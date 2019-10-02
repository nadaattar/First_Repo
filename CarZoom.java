
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * GUI implementation of program that draws
 * a frame with the car and slider that
 * changes the car size
 * @author Ipsita Deshmukh
 *
 */
public class CarZoom {
	public static void main(String[] args) {

		//Constants that define slider
		final int SLIDER_MIN = 0;
		final int SLIDER_MAX = 20;
		final int SLIDER_MID = 10;
		//The constant that is multiplied with slider input to produce car
		final int CARWIDTH_FACTOR = 10;

		//Define the frame, panel, labels, slider and icon
		CarIcon car		 			  = new CarIcon(SLIDER_MID * CARWIDTH_FACTOR);
		JFrame frame 				  = new JFrame("Car Zoom - MT question 2");
		JLabel carLabel 				  = new JLabel(car);
		JLabel heading 				  = new JLabel("Slide to left to increase size");
		JPanel panel 				  = new JPanel(new GridBagLayout());
		JSlider zoomVal 				  = new JSlider(SLIDER_MIN, SLIDER_MAX, SLIDER_MID);
		GridBagConstraints constraints = new GridBagConstraints();

		//Change settings of GUI components
		carLabel.setPreferredSize(new Dimension(300, 300));
		panel.setOpaque(true);
		panel.setBackground(Color.WHITE);
		zoomVal.setPaintLabels(true);
		zoomVal.setMinorTickSpacing(1);
		zoomVal.setMajorTickSpacing(5);
		zoomVal.setPaintTicks(true);
		zoomVal.setPaintTrack(true);
		heading.setFont(new java.awt.Font("Century Schoolbook L", 2, 14));

		//Add listener to the slider
		zoomVal.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				//Change the car width and repaint
				car.setIconWidth(zoomVal.getValue() * CARWIDTH_FACTOR);
				carLabel.repaint();
			}
		});

		//Change constraints and add heading to panel
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 0.5;
		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(heading, constraints);
		heading.setHorizontalAlignment(SwingConstants.CENTER);

		//Change constraints and add slider to panel
		constraints.gridy = 1;
		panel.add(zoomVal, constraints);

		//Change constraints and add car to panel
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.ipady = 20; // make this component tall
		constraints.weightx = 0.0;
		constraints.gridwidth = 3;
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel.add(carLabel, constraints);

		frame.add(panel);

		//Change frame settings and set frame to visible
		frame.pack();
		frame.setPreferredSize(new Dimension(800, 800));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
