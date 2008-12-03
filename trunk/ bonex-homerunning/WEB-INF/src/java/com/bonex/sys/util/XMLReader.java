package com.bonex.sys.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLReader {

	private Document doc;

	private File xmlFile;

	/**
	 * @return the node
	 */
	public Node getNode(String nodeName) {
		return getNode(nodeName, 0);
	}

	public Node getNode(String nodeName, int index) {
		Node node = null;
		try {
			node = doc.getElementsByTagName(nodeName).item(index);
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return node;
	}

	public List<String> getNodesByName(String nodeName) {
		List<String> resultList = new ArrayList<String>();
		NodeList nl = doc.getElementsByTagName(nodeName);
		int length = nl.getLength();
		for (int i=0;i<length;++i) {
			resultList.add(nl.item(i).getTextContent());
		}
		return resultList;
	}
	public String getNodeContent(String nodeName) {
		return getNodeContent(nodeName, 0);
	}

	public String getNodeContent(String nodeName, int index) {
		String nodeContent = null;
		try {
			nodeContent = getNode(nodeName, index).getTextContent();
		} catch (DOMException e) {
			e.printStackTrace();
		}
		return nodeContent;
	}

	/**
	 * @return the dbPath
	 */
	public String getDBPath() {
		return getNodeContent(Constants.XML_DB_PATH);
	}

	/**
	 * @return the dbAccessFilename
	 */
	public String getDBAccessFilename() {
		return getNodeContent(Constants.XML_DB_ACCESS_FILENAME);
	}

	/**
	 * @return the dbUsername
	 */
	public String getDBUsername() {
		return getNodeContent(Constants.XML_DB_USERNAME);
	}

	/**
	 * @return the dbPassword
	 */
	public String getDBPassword() {
		return getNodeContent(Constants.XML_DB_PASSWORD);
	}

	public XMLReader(String filePath) {
		try {
			xmlFile = new File(filePath);
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse(xmlFile);
			// normalize text redivsentation
			doc.getDocumentElement().normalize();

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	public String getSQLFile(String sqlName) {
		NodeList nl=doc.getElementsByTagName("name");
		int length = nl.getLength();
		for(int i=0;i<length;++i){
			Node thisNode = nl.item(i);
			String thisName=thisNode.getTextContent();
			if (thisName!=null&&sqlName.equals(thisName)){
				return (String)thisNode.getParentNode().getChildNodes().item(3).getTextContent();
			}
		}
		return null;
	}

}
