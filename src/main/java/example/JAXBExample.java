package example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBExample {

    private static final String PATH_TO_XML_FILE = "C:\\Users\\rsuller\\file.xml";

    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setId(100);
        customer.setName("test");
        customer.setAge(29);

        try {

            File file = new File(PATH_TO_XML_FILE);
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(customer, file);
            jaxbMarshaller.marshal(customer, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


        // Read the document
        try {

            File file = new File(PATH_TO_XML_FILE);
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            customer = (Customer) jaxbUnmarshaller.unmarshal(file);
            System.out.println(customer.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}