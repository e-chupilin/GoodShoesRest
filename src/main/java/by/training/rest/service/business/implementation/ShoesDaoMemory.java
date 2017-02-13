package by.training.rest.service.business.implementation;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import by.training.rest.service.business.beans.Shoes;
import by.training.rest.service.business.enums.Category;
import by.training.rest.service.business.enums.Rating;
import by.training.rest.service.interfaces.ShoesDaoInterface;

public class ShoesDaoMemory implements ShoesDaoInterface {
	private Collection<Shoes> shoesList = null;
	private static final Logger LOGGER = Logger.getLogger(ShoesDaoMemory.class);


	public ShoesDaoMemory() {
		super();
		shoesList = new ArrayList<Shoes>();
		shoesList.add(new Shoes.Builder(1).description("High quality. Best price !").category(Category.LOW_SHOES)
				.price(100).rating(Rating.FIVE).title("Gentelman shoes").labels("").build());
		LOGGER.info("Create shoes dao in memory. Quantity element: " + shoesList.size());
		LOGGER.info(shoesList.toArray()[0]);		
	}

	public Collection<Shoes> getAll() {
		return shoesList;
	}
}