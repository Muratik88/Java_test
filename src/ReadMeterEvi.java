import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadMeterEvi {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        List<Evidence> evidenceList = new ArrayList<>();
        Evidence evidence = null;
        int i = 0;
        File file = new File("C:\\Users\\Muratn\\Desktop\\Books\\1.xml");

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader streamReader = factory.createXMLStreamReader(new FileReader(file));

        while (streamReader.hasNext()){
            streamReader.next();

            if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT){
                if (streamReader.getLocalName().equalsIgnoreCase("mval2")){
                    evidence = new Evidence();

                    if(streamReader.getAttributeCount() > 0) {
                        String id = streamReader.getAttributeValue(null,"id");
                        evidence.setcTime(id);
                    }
                }

                if (streamReader.getLocalName().equalsIgnoreCase("serialno")){
                    evidence.setSerialNo(streamReader.getElementText());
                }

                if (streamReader.getLocalName().equalsIgnoreCase("value")){
                    evidence.setmValue(streamReader.getElementText());
                }

                if (streamReader.getLocalName().equalsIgnoreCase("time")){
                    evidence.setcTime(streamReader.getElementText());
                }

                if (streamReader.getLocalName().equalsIgnoreCase("devtype")){
                    evidence.setDevType(streamReader.getElementText());
                }
            }

            if (streamReader.getEventType() == XMLStreamReader.END_ELEMENT){
                if (streamReader.getLocalName().equalsIgnoreCase("mval2")){
                    i = i + 1;
                    evidenceList.add(evidence);
                    System.out.println("№ сч.:" + evidence.getSerialNo() + ", Показан. " + evidence.getmValue() + ", Кол-во: "+i);
                }
            }
        }

        DbConnect dbConnect = new DbConnect();


        for (Evidence item:evidenceList){
            Evidence evidence1 = new Evidence(item.getSerialNo(), item.getmValue(), item.getDevType(), item.getcTime());
            dbConnect.addEvidence(evidence1);
            System.out.println(item.getSerialNo());
        }
        System.out.println("Процесс окончен");

    }
}
