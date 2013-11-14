package com.epam.preproduction.helpers.core;

import java.io.FileReader;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.epam.preproduction.configuration.PropertyReader;

public class XMLReader implements IReader {

	// @Override
	// public Set<String> read() {
	//
	// Set<String> cities = new HashSet<String>();
	// SAXBuilder builder = new SAXBuilder();
	//
	// try {
	//
	// FileReader readerXML = new FileReader(
	// PropertyReader.getInputXmlFileName());
	// Document document = builder.build(readerXML);
	// List<Element> tmp = document.getRootElement().getChildren();
	//
	// for (int i = 0; i < tmp.size(); i++) {
	// org.w3c.dom.Element element = tmp.get(i);
	// if (element.getName() == "city") {
	// cities.add(element.getValue());
	// System.out.println("These are my cities: "
	// + element.getContent());
	//
	// }
	// }
	// } catch (Exception e) {
	// System.out.println(e.getMessage());
	// }
	// return cities;
	// }

	public Object[][] reader(String fileName, String sheetNumber) {

		Object[][] data = null;

		SAXBuilder builder = new SAXBuilder();

		try {

			FileReader readerXML = new FileReader(
			PropertyReader.getInputXmlFileName());
			Document document = builder.build(readerXML);
			List<Element> temp = document.getRootElement().getChildren();
			for (int i = 0; i < temp.size(); i++) {
				Element element = temp.get(i);
				if (element.getName() == "catalogue") {
					data =  new Object[i][i+1];
					System.out.println(data);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	


}
