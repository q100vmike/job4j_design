package serialization.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import serialization.json.Film;
import serialization.json.Person;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

public class SerializeToXml {
    public static void main(String[] args) throws Exception {
        Film film = new Film("Alien", true, List.of("Action", "Horror"), 1979,
                new Person("Sigourney Weaver", 30));

        JAXBContext context = JAXBContext.newInstance(Film.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(film, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Film result = (Film) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
