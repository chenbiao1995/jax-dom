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
	//查询所有name元素的值
	private static void selectAll() throws Exception {
		// TODO Auto-generated method stub
		//查询所有name元素的值
		/*
		 * 1、创建解析器工厂
		 * 2、根据解析器工厂创建解析器
		 * 3、解析xml返回document
		 * */
		
		//创建解析器工厂
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		//创建解析器
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		//解析xml返回document
		Document document = builder.parse("src/person.xml");
		//得到name元素
		NodeList list = document.getElementsByTagName("name");
		for(int i=0;i<list.getLength();i++) {
			Node name1 = list.item(i);
			//得到name元素里的值
			String s = name1.getTextContent();
			System.out.println(s);
		}	
	}
	
	//查询第一个name元素的值
	public static void selectSin() throws ParserConfigurationException, SAXException, IOException {
		/*
		 * 1、创建解析器工厂
		 * 2、根据解析器工厂创建解析器
		 * 3、解析xml 返回document
		 * 4、得到所有name元素
		 * 5、返回集合，里面方法item 下标获取具体元素
		 * 6、得到具体的值 getTextConten
		 * */
		DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderfactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		NodeList list = document.getElementsByTagName("name");
		//得到第一个元素
		Node name1 = list.item(0);
		//得到name1具体的值
		String s1 = name1.getTextContent();
		System.out.println(s1);
	}
	
	public static void addSex() throws Exception {
		/*
		 * 1、创建解析器工厂
		 * 2、根据解析器工厂创建解析器
		 * 3、解析xml 返回document
		 * 4、得到第一个p1
		 * 		--得到所有的p1 使用item方法下标得到
		 * 5、创建sex标签 createElement
		 * 6、创建文本 createTextNode
		 * 7、把文本添加到sex下面 appendChild
		 * 8、把sex添加到第一个个p1下面
		 * 9、回写xml
		 * */
		DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderfactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		//得到所有的p1
		NodeList list = document.getElementsByTagName("p1");
		//得到第一个p1
		Node p1 = list.item(0);
		//创建标签
		Element sex1 = document.createElement("sex");
		//创建文本
		Text text1 = document.createTextNode("女");
		//把文本添加到sex1下面
		sex1.appendChild(text1);
		//把sex1添加到p1下面
		p1.appendChild(sex1);
		//回写xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/person.xml"));
	}
	
	//修改第一个p1下面的sex内容
	public static void modifySex() throws Exception {
		/*
		 * 1、创建解析器工厂
		 * 2、根据解析器工厂创建解析器
		 * 3、解析xml 返回document
		 * 4、得到sex item方法
		 * 5、修改sex里面的值 setTextContent方法
		 * 6、回写xml
		 * */
		DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderfactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		Node sex1 = document.getElementsByTagName("sex").item(0);
		sex1.setTextContent("男");
		//回写xml
		TransformerFactory transfomerFactory = TransformerFactory.newInstance();
		Transformer transformer = transfomerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/person.xml"));
	}
	
	
	//删除sex节点
	public static void deleteSex() throws Exception {
		/*
		 * 1、创建解析器工厂
		 * 2、根据解析器工厂创建解析器
		 * 3、解析xml 返回document
		 * 4、得到sex item方法
		 * 5、获取sex的父节点
		 * 6、删除使用父节点 removeChild()
		 * 7、回写xml
		 * */
		DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderfactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		Node sex1 = document.getElementsByTagName("sex").item(0);
		//得到sex1的法界点
		Node p1 = sex1.getParentNode();
		//删除操作
		p1.removeChild(sex1);
		//回写xml
		TransformerFactory transfomerFactory = TransformerFactory.newInstance();
		Transformer transformer = transfomerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/person.xml"));
	}
	
	//遍历节点，把xml中所有元素名称打印出来
	public static void listElement() throws Exception {
		/*
		 * 1、创建解析器工厂
		 * 2、根据解析器工厂创建解析器
		 * 3、解析xml 返回document
		 * 4、得到根节点
		 * 5、得到根节点的子节点
		 * 6、得到根节点的子节点的子节点（递归）
		 * */
		DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderfactory.newDocumentBuilder();
		Document document = builder.parse("src/person.xml");
		//编写一个方法实现遍历的操作
		list1(document);
	}
	//递归遍历的方法
	private static void list1(Node node) {
		//判断是元素类型时候打印
		if(node.getNodeType() == node.ELEMENT_NODE) {
			System.out.println(node.getNodeName());

		}
		
		// TODO Auto-generated method stub
		//得到一层子节点
		NodeList list = node.getChildNodes();
		//遍历list
		for (int i=0;i<list.getLength();i++) {
			//得到每一个节点
			Node node1 = list.item(i);
			//继续得到node1的子节点
			list1(node1);
		}
	}
	
	
}
