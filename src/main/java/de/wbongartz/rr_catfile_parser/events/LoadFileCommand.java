package de.wbongartz.rr_catfile_parser.events;

import java.io.File;

/**
 * @author Wolfgang Bongartz
 *
 */
public class LoadFileCommand {

	private File _file;
	
	private LoadFileCommand() {
		super();
	}

	public LoadFileCommand(File file) {
		super();
		_file=file;
	}
	
	public File getFile()
	{
		return _file;
	}
}
