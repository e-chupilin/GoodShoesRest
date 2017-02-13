package by.training.rest.service.interfaces;

import java.io.IOException;
import java.util.Collection;

import by.training.rest.service.business.beans.Shoes;

public interface ShoesDaoInterface {
	Collection<Shoes> getAll() throws IOException;
}
