package m23_DongVanXuong_22679121;

import java.io.File;
import java.io.IOException;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ManageProduct {
    private static String filename = "fileXML\\product.xml";
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private org.w3c.dom.Document document;

    public ManageProduct() {
        try {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse(new File(filename));
            document.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product p) {
        Element root = document.getDocumentElement();
        Element pNode = document.createElement("product");
        root.appendChild(pNode);
        pNode.setAttribute("id", p.getProduct_id());

        Element nameNode = document.createElement("name");
        nameNode.setTextContent(p.getName());
        pNode.appendChild(nameNode);

        Element manufactureNode = document.createElement("manufacture");
        manufactureNode.setTextContent(p.getManufacture());
        pNode.appendChild(manufactureNode);

        Element descriptionNode = document.createElement("description");
        descriptionNode.setTextContent(p.getDescription());
        pNode.appendChild(descriptionNode);

        Element supplierNode = document.createElement("supplier");
        pNode.appendChild(supplierNode);

        Element supplierNameNode = document.createElement("name");
        supplierNameNode.setTextContent(p.getSupplier().getName());
        supplierNode.appendChild(supplierNameNode);

        Element countryNode = document.createElement("country");
        countryNode.setTextContent(p.getSupplier().getCountry());
        supplierNode.appendChild(countryNode);

        Element websiteNode = document.createElement("website");
        websiteNode.setTextContent(p.getSupplier().getWebsite());
        supplierNode.appendChild(websiteNode);

        Element priceNode = document.createElement("price");
        priceNode.setTextContent(Double.toString(p.getPrice()));
        pNode.appendChild(priceNode);
    }

    public void deleteProduct(String pid) {
        Element root = document.getDocumentElement();
        NodeList pList = root.getElementsByTagName("product");
        for (int i = 0; i < pList.getLength(); i++) {
            Element pNode = (Element) pList.item(i);
            String productID = pNode.getAttribute("id");
            if (productID.equalsIgnoreCase(pid)) {
                pNode.getParentNode().removeChild(pNode);
                break;
            }
        }
    }

    public void updatePrice(String pid, double newPrice) {
        Element root = document.getDocumentElement();
        NodeList pList = root.getElementsByTagName("product");
        for (int i = 0; i < pList.getLength(); i++) {
            Element pNode = (Element) pList.item(i);
            String productID = pNode.getAttribute("id");
            if (productID.equalsIgnoreCase(pid)) {
                Node priceNode = pNode.getElementsByTagName("price").item(0);
                priceNode.setTextContent(Double.toString(newPrice));
                break;
            }
        }
    }

    public void writeXMLFile() {
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(new File(filename)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void printAll() {
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(System.out));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
