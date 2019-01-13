package com.ensa.batch;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.ensa.entities.Personne;


@Service
public class FilterReportProcessor implements ItemProcessor<Personne, Personne>{

	@Override
	public Personne process(Personne p) throws Exception {
		
		Personne pers = null; 
		
		LocalDate now = LocalDate.now();
	    LocalDate personDate = p.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	    
	    Period period = Period.between(personDate, now);

		if( period.getYears() < 30)
			pers=p;
		
		return pers;		
	}

}
