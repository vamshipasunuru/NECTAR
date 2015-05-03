/**
 * 
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author kalyan
 *
 */
public class ExtensiveComboBox extends JComboBox
				implements Command {

	protected Mediator mediator = null;
	
	/**
	 * This constructor takes the action listener and list of labels and add
	 * these to this instance
	 * 
	 * @param listener :
	 *            action listener
	 * @param list :
	 *            list of labels
	 */
	public ExtensiveComboBox(ActionListener listener, String[] algoList)
	{
		super(algoList);
		initGUI(listener);
	}
	
	/**
	 * Initializes the GUI and registers with mediator object
	 * 
	 * @param listener :
	 *            Action Listener
	 */	
	private void initGUI(ActionListener listener) 
	{
		// gets the mediator object
		this.mediator = Mediator.Instance();
		// registers with mediator object
		mediator.registerExtensiveComboBox(this);
		
		// sets the GUI 
		this.setForeground(Color.BLUE);
		this.addActionListener(listener);
		return;
	}

	
	/* (non-Javadoc)
	 * @see gui.Command#execute()
	 */
	/**
	 * It implements the command interface such that it handles
	 * its event itself. (See Command Pattern)
	 */
	public void execute() {
		
		String algorithmName = (String)this.getSelectedItem();
		mediator.setExtensiveAlgorithm(algorithmName);
		//System.out.println(algorithmName + " has selected");
		return;
	}

}
