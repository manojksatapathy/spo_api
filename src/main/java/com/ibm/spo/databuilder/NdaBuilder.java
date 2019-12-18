package com.ibm.spo.databuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.ibm.spo.model.NDA;
import com.ibm.spo.model.Scenario;
import com.ibm.spo.model.User;
import com.ibm.spo.model.Scenario.StatusEnum;

public class NdaBuilder {
	private static int idCounter = 0;
	private static Date dateCounter = new Date();
	private static int totalNDAs = 5;
	
	public static List<NDA> getNdas() {
		List<NDA> ndas = new ArrayList<NDA>();
		for(int i=0;i<totalNDAs;i++) {
			idCounter = i;
			long ltime=dateCounter.getTime()+(i*24*60*60*1000);
			dateCounter=new Date(ltime);
			ndas.add(WithTestValues());
		}
    	
		return ndas;
	}
	public static NDA WithTestValues(){
		NDA _entity  = new NDA();
        _entity
        	.id(String.valueOf(idCounter))
        	.idNda(String.valueOf(idCounter))
        	.assetOid(String.valueOf(idCounter))
        	.assetName("Asset Name "+String.valueOf(idCounter))
        	.assetMrid("Asset MRID "+String.valueOf(idCounter))
        	.assetDs("Asset DS "+String.valueOf(idCounter))
        	.assetType("Asset Type "+String.valueOf(idCounter))
        	.assetTypeDs("Asset Type DS "+String.valueOf(idCounter))
        	.status("Status "+String.valueOf(idCounter))
        	.substation("Substation "+String.valueOf(idCounter))
        	.maintenanceArea("MA "+String.valueOf(idCounter))
        	.geographicalArea("GA "+String.valueOf(idCounter))
        	.nda_type("NDA TYPE"+String.valueOf(idCounter))
        	.nda_type_ds("NDA TYPE DS"+String.valueOf(idCounter))
        	.startDate(date())
        	.endDate(date());
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
}
