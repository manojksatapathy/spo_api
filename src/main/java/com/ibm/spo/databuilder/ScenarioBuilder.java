package com.ibm.spo.databuilder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.ibm.spo.model.Scenario;
import com.ibm.spo.model.Scenario.StatusEnum;
import com.ibm.spo.model.User;

public class ScenarioBuilder {
	
	private static int idCounter = 0;
	private static Date dateCounter = new Date();
	private static String dateCounterString = "";
	private static int totalScenarios = 5;
	
	public static List<Scenario> getScenarios() {
		List<Scenario> scenarios = new ArrayList<Scenario>();
		for(int i=0;i<totalScenarios;i++) {
			idCounter = i;
			long ltime=dateCounter.getTime()+(i*24*60*60*1000);
			dateCounter=new Date(ltime);
			scenarios.add(WithTestValues());
		}
    	
		return scenarios;
	}
	public static Scenario WithTestValues(){
		Scenario _entity  = new Scenario();
        _entity
        	.author(new User()
        			.firstName("Bob"))
        	.name("TEST Scenario name"+idCounter)
        	.id(String.valueOf(idCounter))
        	.temporalHorizon(date())
        	.createdDate(date())
        	.lastModified(date())
        	.status(StatusEnum.READY);
        return _entity;
    }
	
	private static XMLGregorianCalendar date() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(dateCounter);
		XMLGregorianCalendar date2 = null;
	    try {
	        Date date = gc.getTime();
	        System.out.println(date);
	        DateFormat df = new SimpleDateFormat("MM-DD-YYYY hh:mm:ss");
	        System.out.println(df.format(date));
			date2
			        = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
			
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
	    return date2;
	}
	
	private static Object date1() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			// GET, string is consistent to DB2 timestamp, return
			// POST, XMLGregorianCalendar will throw ParseException, further parse to DB2 timestamp
			dateCounterString = dateCounter.toString();
			df.parse(dateCounter.toString());
			dateCounterString = dateCounterString;
		} catch (ParseException pe) {
			XMLGregorianCalendar cCreateTime = null;
			try {
				cCreateTime  = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateCounterString);
	//			System.out.println("cCreateTime=============" + cCreateTime);
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (cCreateTime != null && cCreateTime.isValid()) {
	//			System.out.println("df.format(cCreateTime.toGregorianCalendar().getTime()) : " + df.format(cCreateTime.toGregorianCalendar().getTime()));
				dateCounterString = df.format(cCreateTime.toGregorianCalendar().getTime());
			}
			return cCreateTime;
		}  
		return dateCounterString;
	}

}
