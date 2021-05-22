package de.wbongartz.rr_catfile_parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

import javax.swing.JFrame;

import de.wbongartz.rr_catfile_parser.events.EventBase;
import de.wbongartz.rr_catfile_parser.events.LoadFileCommand;
import de.wbongartz.rr_catfile_parser.events.NewModelEvent;
import de.wbongartz.rr_catfile_parser.parser.RoseParser;
import de.wbongartz.rr_catfile_parser.utils.ConfigManager;
import de.wbongartz.rr_catfile_parser.gui.MainWindow;



/**
 * @author Wolfgang Bongartz
 *
 */
public class MainProgram {

	private static MainProgram _mainProgram;
	
	private ConfigManager _configManager;
	private Logger _log = Logger.getLogger( MainProgram.class.getName() );

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		javax.swing.SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						try {
							_mainProgram = new MainProgram();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
    
	private MainProgram()
	{
		_configManager = new ConfigManager("HKEY_CURRENT_USER\\Software\\Rational Software\\rose\\Virtual Path Map");
		@SuppressWarnings("unused")
		JFrame mainWindow = new MainWindow();
		EventBase.addListener(LoadFileCommand.class, this, "receiveLoadFileCommand");
	}
	
    private void startParser(File file2parse)
    {
    	_log.info("Load: " + file2parse.getPath());
        System.out.println("Parse " + file2parse.getPath() + ".");
    	long start_time = System.nanoTime();
        try
        {
          RoseParser parser = new RoseParser(file2parse, _configManager);
          parser.run();
      	  long stop_time = System.nanoTime();
          _log.info("Loading finished: " + file2parse.getPath());
          float elapsed_time = (stop_time - start_time) / 1000000000L;
          _log.info("Done. Time=" + elapsed_time + " seconds");
          
          _log.info("\nThreads:");
          for(Thread t: RoseParser.myThreads)
          {
        	  if(t!=null)
        		  _log.info(t.getState() + " : " + t.getName());
        	  else
        		  _log.info("THREAD IS NULL!");
          }

          Object node = parser.getModelNode();
          
          NewModelEvent event = new NewModelEvent(node);
          EventBase.fire(event);
          
          //splitPane.setLeftComponent(new JScrollPane(_tree));
        }
        catch(FileNotFoundException ex)
        {
        	_log.severe(ex.getMessage());
        } 
        catch(Exception ex)
        {
        	_log.severe(ex.getMessage());
        } 
    }

	public void receiveLoadFileCommand(LoadFileCommand event) {
		File file = event.getFile();
        startParser(file);
	}
}
