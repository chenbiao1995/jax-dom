package cn.shantui.jaxptest;



import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Test {

	public static void main(String[] args) throws Exception {
		//selectAll();
		//selectSin();
		//addSex(); 
		//modifySex();
		//deleteSex();
		listElement();
	}
	//��ѯ����nameԪ�ص�ֵ
	private static void selectAll() throws Exception {
		// TODO Auto-generated method stub
		//��ѯ����nameԪ�ص�ֵ
		/*
		 * 1����������������
		 * 2�����ݽ�������������������
		 * 3������xml����document
		 * */
		
		//��������������
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		//����������
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		//����xml����document
		Document document = builder.parse("src/person.xml");
		//�õ�nameԪ��
		NodeList list = document.getElementsByTagName("name");
		for(int i=0;i<list.getLength();i++) {
			Node name1 = list.item(i);
			//�õ�nameԪ�����ֵ
			String s = name1.getTextContent();
			System.out.println(s);
		}	
	}
	
	//��ѯ��һ��nameԪ�ص�ֵ
	public static void selectSin() throws ParserConfigurationException, SAXException, IOException {
		/*
		 * 1����������������
		 * 2�����ݽ�������������������
		 * 3������xml ����document
		 * 4���õ�����nameԪ��
		 * 5�����ؼ��ϣ����淽��item �±��ȡ����Ԫ��
		 * 6���õ������ֵ getTextConten
		 * */
		DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderfactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		NodeList list = document.getElementsByTagName("name");
		//�õ���һ��Ԫ��
		Node name1 = list.item(0);
		//�õ�name1�����ֵ
		String s1 = name1.getTextContent();
		System.out.println(s1);
	}
	
	public static void addSex() throws Exception {
		/*
		 * 1����������������
		 * 2�����ݽ�������������������
		 * 3������xml ����document
		 * 4���õ���һ��p1
		 * 		--�õ����е�p1 ʹ��item�����±�õ�
		 * 5������sex��ǩ createElement
		 * 6�������ı� createTextNode
		 * 7�����ı���ӵ�sex���� appendChild
		 * 8����sex��ӵ���һ����p1����
		 * 9����дxml
		 * */
		DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderfactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		//�õ����е�p1
		NodeList list = document.getElementsByTagName("p1");
		//�õ���һ��p1
		Node p1 = list.item(0);
		//������ǩ
		Element sex1 = document.createElement("sex");
		//�����ı�
		Text text1 = document.createTextNode("Ů");
		//���ı���ӵ�sex1����
		sex1.appendChild(text1);
		//��sex1��ӵ�p1����
		p1.appendChild(sex1);
		//��дxml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/person.xml"));
	}
	
	//�޸ĵ�һ��p1�����sex����
	public static void modifySex() throws Exception {
		/*
		 * 1����������������
		 * 2�����ݽ�������������������
		 * 3������xml ����document
		 * 4���õ�sex item����
		 * 5���޸�sex�����ֵ setTextContent����
		 * 6����дxml
		 * */
		DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderfactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		Node sex1 = document.getElementsByTagName("sex").item(0);
		sex1.setTextContent("��");
		//��дxml
		TransformerFactory transfomerFactory = TransformerFactory.newInstance();
		Transformer transformer = transfomerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/person.xml"));
	}
	
	
	//ɾ��sex�ڵ�
	public static void deleteSex() throws Exception {
		/*
		 * 1����������������
		 * 2�����ݽ�������������������
		 * 3������xml ����document
		 * 4���õ�sex item����
		 * 5����ȡsex�ĸ��ڵ�
		 * 6��ɾ��ʹ�ø��ڵ� removeChild()
		 * 7����дxml
		 * */
		DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderfactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		Node sex1 = document.getElementsByTagName("sex").item(0);
		//�õ�sex1�ķ����
		Node p1 = sex1.getParentNode();
		//ɾ������
		p1.removeChild(sex1);
		//��дxml
		TransformerFactory transfomerFactory = TransformerFactory.newInstance();
		Transformer transformer = transfomerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/person.xml"));
	}
	
	//�����ڵ㣬��xml������Ԫ�����ƴ�ӡ����
	public static void listElement() throws Exception {
		/*
		 * 1����������������
		 * 2�����ݽ�������������������
		 * 3������xml ����document
		 * 4���õ����ڵ�
		 * 5���õ����ڵ���ӽڵ�
		 * 6���õ����ڵ���ӽڵ���ӽڵ㣨�ݹ飩
		 * */
		DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderfactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		//��дһ������ʵ�ֱ����Ĳ���
		list1(document);
	}
	//�ݹ�����ķ���
	private static void list1(Node node) {
		//�ж���Ԫ������ʱ���ӡ
		if(node.getNodeType() == node.ELEMENT_NODE) {
			System.out.println(node.getNodeName());

		}
		
		// TODO Auto-generated method stub
		//�õ�һ���ӽڵ�
		NodeList list = node.getChildNodes();
		//����list
		for (int i=0;i<list.getLength();i++) {
			//�õ�ÿһ���ڵ�
			Node node1 = list.item(i);
			//�����õ�node1���ӽڵ�
			list1(node1);
		}
	}
	
	
}
