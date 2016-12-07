package test.test1;
	import java.io.File;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.StringWriter;

	import org.apache.xmlbeans.XmlException;
	import org.apache.xmlbeans.XmlObject;
	import org.apache.xmlbeans.XmlOptions;
	import org.apache.xmlbeans.impl.inst2xsd.Inst2Xsd;
	import org.apache.xmlbeans.impl.inst2xsd.Inst2XsdOptions;
	import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

	public class xmlToXSD {
	    public static void main(String[] args) {
	        try {
	        	String xml="<store><id></id></store>";

	        	xmlToXSD xmlBeans = new xmlToXSD();
	            SchemaDocument schemaDocument = xmlBeans.generateSchema(new File("C:\\jba\\workspaces\\default\\test1\\src\\main\\java\\test\\test1\\storeXML.xml"));

	            StringWriter writer = new StringWriter();
	            schemaDocument.save(writer, new XmlOptions().setSavePrettyPrint());
	            writer.close();

	            String xmlText = writer.toString();
	            System.out.println(xmlText);

	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public SchemaDocument generateSchema1(File inputFile) throws XmlException, IOException {
	        // Only 1 instance is required for now
	        XmlObject[] xmlInstances = new XmlObject[1];
	        xmlInstances[0] = XmlObject.Factory.parse(inputFile);

	        return inst2xsd(xmlInstances);
	    }

	    public SchemaDocument generateSchema(File inputFile) throws XmlException, IOException {
	        return generateSchema1(inputFile);

	    }

	   /* public SchemaDocument generateSchema(File inputFile) throws XmlException, IOException {
	    	 // Only 1 instance is required for now
	        XmlObject[] xmlInstances = new XmlObject[1];
	        xmlInstances[0] = XmlObject.Factory.parse(inputFile);

	        return inst2xsd(xmlInstances);
	    }*/

	   /* public SchemaDocument generateSchema(InputStream is) throws XmlException, IOException {
	        // Only 1 instance is required for now
	        XmlObject[] xmlInstances = new XmlObject[1];
	        xmlInstances[0] = XmlObject.Factory.parse(is);

	        return inst2xsd(xmlInstances);
	    }

	    public SchemaDocument generateSchema(String input) throws XmlException, IOException {
	        return generateSchema(input);
	    }

	    public SchemaDocument generateSchema(String input) throws XmlException, IOException {
	        // Only 1 instance is required for now
	        XmlObject[] xmlInstances = new XmlObject[1];
	        xmlInstances[0] = XmlObject.Factory.parse(input);

	        return inst2xsd(xmlInstances);
	    }*/

	    private SchemaDocument inst2xsd(XmlObject[] xmlInstances) throws IOException {
	        Inst2XsdOptions inst2XsdOptions = new Inst2XsdOptions();
	        /*if (design == null || design == XMLSchemaDesign.VENETIAN_BLIND) {
	            inst2XsdOptions.setDesign(Inst2XsdOptions.DESIGN_VENETIAN_BLIND);
	        } else if (design == XMLSchemaDesign.RUSSIAN_DOLL) {
	            inst2XsdOptions.setDesign(Inst2XsdOptions.DESIGN_RUSSIAN_DOLL);
	        } else if (design == XMLSchemaDesign.SALAMI_SLICE) {
	            inst2XsdOptions.setDesign(Inst2XsdOptions.DESIGN_SALAMI_SLICE);
	        }*/
	        inst2XsdOptions.setDesign(Inst2XsdOptions.DESIGN_VENETIAN_BLIND);
	        SchemaDocument[] schemaDocuments = Inst2Xsd.inst2xsd(xmlInstances, inst2XsdOptions);
	        if (schemaDocuments != null && schemaDocuments.length > 0) {
	            return schemaDocuments[0];
	        }

	        return null;
	    }

	}

