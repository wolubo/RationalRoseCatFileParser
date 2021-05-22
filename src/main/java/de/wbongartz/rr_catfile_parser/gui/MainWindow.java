package de.wbongartz.rr_catfile_parser.gui;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import de.wbongartz.rr_catfile_parser.events.EventBase;
import de.wbongartz.rr_catfile_parser.events.LoadFileCommand;

/**
 * @author Wolfgang Bongartz
 *
 */
public class MainWindow extends JFrame implements ActionListener 
{

	private TreePanel _treePanel;
	private JMenuItem _openMenuItem;

	/**
	 * @throws HeadlessException
	 */
	public MainWindow() throws HeadlessException {
		super();
		createMainWindow();
	}

	/**
	 * @param gc
	 */
	public MainWindow(GraphicsConfiguration gc) {
		super(gc);
		createMainWindow();
	}

	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public MainWindow(String title) throws HeadlessException {
		super(title);
		createMainWindow();
	}

	/**
	 * @param title
	 * @param gc
	 */
	public MainWindow(String title, GraphicsConfiguration gc) {
		super(title, gc);
		createMainWindow();
	}

	private void createMainWindow()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_treePanel = new TreePanel();
		createMenuBar();
		setContentPane(_treePanel);
		pack();
		setVisible(true);
	}
	
	private void createMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");

		_openMenuItem = new JMenuItem("Open Rose-Model");
		_openMenuItem.addActionListener(this);
		fileMenu.add(_openMenuItem);

		menuBar.add(fileMenu);
		
		setJMenuBar(menuBar);
	}
	
	
    public void actionPerformed (ActionEvent ae)
    {
        if(ae.getSource() == this._openMenuItem)
        {
        	openFile();
        }
    }	
    
    private void openFile()
    {
    	JFileChooser fc = new JFileChooser();
    	fc.setAcceptAllFileFilterUsed(false);
    	fc.addChoosableFileFilter(new FileNameExtensionFilter("Rose Cat File", "cat", "sub"));
    	fc.addChoosableFileFilter(new FileNameExtensionFilter("Rose Model", "ptl", "mdl"));
    	int returnVal = fc.showDialog(this, "Open Rose-Model");
        
    	if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            LoadFileCommand event = new LoadFileCommand(file);
            EventBase.fire(event);
        }
    }
    
	
}
