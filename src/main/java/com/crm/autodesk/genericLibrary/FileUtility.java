package com.crm.autodesk.genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Class which has all file utilities method
 * @author Bharath Vepanjeri
 *
 */
public class FileUtility 
{
      /**
       * It is used to get property value at the key passed as an argument
       * @param key
       * @return
       * @throws IOException
       */
	public String getPropertyKeyValue(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("./data/commondata.properties");
		   Properties pObj=new Properties();
		   pObj.load(file);
		   return pObj.getProperty(key);
	}

}
