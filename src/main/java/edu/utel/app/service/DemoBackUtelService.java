package edu.utel.app.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.ws.spi.Invoker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.utel.app.rest.pojo.Item;

@Service
public class DemoBackUtelService {

	private static final Logger LOGGER = LoggerFactory.getLogger(Invoker.class);

	public List<Item> search(String query, boolean soloNuevos) {

		List<Item> items = new ArrayList<Item>();

		try {
			
			String url = "https://api.mercadolibre.com/sites/MLA/search?q=" + query;
			if(soloNuevos) {
				url += "&condition=new";				
			}
			
			RestTemplate restTemplate = new RestTemplate();
			LinkedHashMap mapa = restTemplate.getForObject(url, LinkedHashMap.class);
			List<Object> results = (List<Object>)mapa.get("results");
			for (Object result : results) {
				Item item = new Item();
				item.setId(((LinkedHashMap<String, String>)result).get("id"));
				item.setTitle(((LinkedHashMap<String, String>)result).get("title"));
				item.setPrice(Double.valueOf(String.valueOf(((LinkedHashMap<String, Object>)result).get("price"))));
				item.setCurrencyId(((LinkedHashMap<String, String>)result).get("currency_id"));
				item.setAvailableQuantity(((LinkedHashMap<String, Integer>)result).get("available_quantity"));
				item.setThumbnail(((LinkedHashMap<String, String>)result).get("thumbnail"));
				item.setCondition(((LinkedHashMap<String, String>)result).get("condition"));
				
				items.add(item);
			}

		} catch (Exception e) {

			LOGGER.error(" Error en Invoker: ", e);
			throw e;

		}
		
		return items;

	}

}
