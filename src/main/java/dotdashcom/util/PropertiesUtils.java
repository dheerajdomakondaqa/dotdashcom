package dotdashcom.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

import dotdashcom.base.AppConstant;

public class PropertiesUtils {
	private static Properties globalProp = null;
	private static Properties envProp = null;
	static Logger logger = Logger.getLogger(PropertiesUtils.class.getName());
	public static Properties loadProperties(String filePath) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(filePath)));		
		}catch(Exception e) {
			logger.info(e.toString());
			return null;
		}
		return prop;
	}
	
	
	public static String getConfigProperties(String prop) {
		if(globalProp == null) {
			globalProp = loadProperties(AppConstant.getBasePath()+"/config/config.properties");
		}
		return globalProp.getProperty(prop);
	}
	
	public static String getEnvProperties(String prop) {
		if(envProp == null) {
			envProp = loadProperties(AppConstant.getBasePath()+"/config/"+getConfigProperties("env")+".properties");
		}
		return envProp.getProperty(prop);
	}
	
	
	
	
}
