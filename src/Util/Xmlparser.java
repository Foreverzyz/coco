package Util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Xmlparser 
{
	public static  HashMap<String, String> parser(String xmlPath)
	{
		HashMap<String, String> hm =new HashMap<String, String>();
		
		try {
			
			SAXParserFactory factory=  SAXParserFactory.newInstance();
			SAXParser saxParser= factory.newSAXParser();
			File f = new File(xmlPath);
			XmlHandler xh = new XmlHandler();
			saxParser.parse(f, xh);
			hm=xh.getHashMap();
		}catch (IOException e){
			e.printStackTrace();
		}catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return hm;
	}

}
