package logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DifferLogger {


	private Logger logger;
	public FileHandler fileHandler;
	public FileHandler fineHandler;
	public FileHandler warningHandler;
	
	public static final String LOG_FILE = "differAllLog.txt";
	public static final String FINE_FILE = "differFineLog.txt";
	public static final String WARNING_FILE = "differWarningLog.txt";
	
	//모든 로그는 여기에 찍힐 것이기 때문에, 이는 Single Tone으로 개발한다!!!!
	
	private static DifferLogger instance = new DifferLogger();
	
	DifferLogger(){
		logger = Logger.getLogger("test");//getLogger("로거 이름") 로거 이름에 따라서 그 로거의 인스턴스를 불러옴
		//싱글톤이지만 다양한 놈들을 싱글톤으로 가져올 수 있음.
		
		try {
			fileHandler = new FileHandler(LOG_FILE);
			fineHandler = new FileHandler(FINE_FILE);
			warningHandler = new FileHandler(WARNING_FILE);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SimpleFormatter fomatter = new SimpleFormatter();
		fileHandler.setFormatter(fomatter);
		fineHandler.setFormatter(fomatter);
		warningHandler.setFormatter(fomatter);
		
		logger.addHandler(fileHandler);
		logger.addHandler(fineHandler);
		logger.addHandler(warningHandler);
		
		logger.setLevel(Level.ALL);
		
		fineHandler.setLevel(Level.FINE);
		warningHandler.setLevel(Level.WARNING);		
		
	}
	
	public static DifferLogger getLogger(){
		return instance;
	}
	
	public void fine(String msg){
		logger.fine(msg);
	}
	
	public void warning(String msg){
		logger.warning(msg);
	}
	
	public void writeLog(String msg){
		logger.finest(msg);
		logger.finer(msg);
		logger.fine(msg);
		logger.config(msg);
		logger.info(msg);//Level을 수정하면 다 보인다. 단계별로 보임
		logger.warning(msg);
		logger.severe(msg);
	}

	
}
