package com.countryservice.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;


import com.countryservice.demo.beans.Country;
import com.countryservice.demo.controllers.AddResponse;

@Component
public class CountryService {
	
	private static final int id = 0;
	static HashMap<Integer,Country> countryIdMap;
	
	public CountryService()
	{
		countryIdMap=new HashMap<Integer,Country>();
		
		Country indiaCountry=new Country(1,"India","Delhi");
		Country usaCountry=new Country(2,"USA","Washington");
		Country ukCountry=new Country(3,"UK","London");
		
		countryIdMap.put(1, indiaCountry);
		countryIdMap.put(2, usaCountry);
		countryIdMap.put(3, ukCountry);
	}
	
	//Get all Country 
	public List getAllCountries()
	{
		List countries=new ArrayList(countryIdMap.values());
		return countries;
	}
	
	//get country by id
	public Country getCountrybyId(int id)
	{
		Country country= countryIdMap.get(id);
		return country;
	}
	
	//post/create
	public Country addCountry(Country country)
	{
		country.setId(getMaxId());
		countryIdMap.put(country.getId(), country);
		return country;
	}
	
	public static int getMaxId()
	{
		int max=0;
		for (int id:countryIdMap.keySet()) //doubt
			if(max<=id)
				max=id;
		return max+1;
			
	}
	
	//update
	public Country updateCountry(Country country)
	{
		if(country.getId()>0)
		{
		   countryIdMap.put(country.getId(), country);
		}
		return country;
	}
	
	//Delete
	public AddResponse deleteCountry(int id)
	{
		countryIdMap.remove(id);
		AddResponse res=new AddResponse();
		res.setMsg("country deleted");
		res.setId(id);
		return res;
	}
	
	
}
