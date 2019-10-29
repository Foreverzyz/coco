package Util;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValidate {

	public static boolean validate(String xmlPath,String xsdPath)
	{
		boolean flag=false;
		try {
			SchemaFactory factoey =
						SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			File f = new File(xsdPath);
			Schema schema = factoey.newSchema(f);
			Validator validator = schema.newValidator();
			Source so = new StreamSource(xmlPath);
			validator.validate(so); 
			flag = true;
		} catch (SAXException e) {
			e.printStackTrace();
		}catch (IOException e) {
				e.printStackTrace();
		}
		return flag;
	}
	public static void main(String[] args) 
	{
		String base = Thread.currentThread().getContextClassLoader().getResource("").getPath().toString();
		String xmlPath =base+ "database.conf.xml";
		String xsdPath =base+  "database.conf.xsd";
		
		System.out.println(XmlValidate.validate(xmlPath, xsdPath));
		System.out.println(xsdPath);
		System.out.println(xmlPath);
	}

}
