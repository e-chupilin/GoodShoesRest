package by.training.rest.service.business.factories;
import by.training.rest.service.business.enums.AccessType;
import by.training.rest.service.business.implementation.ShoesDaoMemory;
import by.training.rest.service.interfaces.ShoesDaoInterface;

public class ShoesDaoFactory {
		private static ShoesDaoInterface objShoes = null;

		public static ShoesDaoInterface getAccessObject(AccessType type) {
			switch (type) {
			
			case MEMORY: {
				if (objShoes == null) {
					objShoes = new ShoesDaoMemory();
				}
				return objShoes;
			}
			
			default:
				throw new RuntimeException("Unsupported dao type.");
			}
		}
	}