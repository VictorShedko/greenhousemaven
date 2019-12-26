package by.victor.greenhouse.action;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataParseAction {
    public XMLGregorianCalendar parseMonth(String s) {
        XMLGregorianCalendar xmlGregorianCalendar = null;
        GregorianCalendar calendar = new GregorianCalendar();
        Date date = null;
        try {
            date = new SimpleDateFormat("--MM").parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        try {
            xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return xmlGregorianCalendar;
    }

}
