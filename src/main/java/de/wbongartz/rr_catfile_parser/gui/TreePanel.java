package de.wbongartz.rr_catfile_parser.gui;

import java.util.logging.*;

import javax.swing.*;

public class TreePanel 
	extends JPanel
//	implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger( TreePanel.class.getName() );	
	
	private ModelTree _modelTree;
	
//	private JPanel contentPane;
//	private JSplitPane splitPane;
	
	

	/**
	 * Create the frame.
	 */
	public TreePanel() {
		super();

		log.info("TEST");
		
		setBounds(100, 100, 450, 300);
		
		_modelTree = new ModelTree();
		
		//splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		//splitPane.setLeftComponent(new JScrollPane(_tree));
		//splitPane.setRightComponent(panelGelb);		
		//contentPane.add(splitPane);

		add(_modelTree);

		//pack();
    	setVisible(true);
	}
	
}
