package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FurnitureOrder implements FurnitureOrderInterface {
	private Map<String, Float> furniture;

	/**
	 * Initialize a new mapping of Furniture types to order quantities.
	 */
	FurnitureOrder() {
		this.furniture = new HashMap<String, Float>();
	}

	public void addToOrder(final Furniture type, final int furnitureCount) {
		this.furniture.put(type.label(), type.cost() * furnitureCount);
	}

	public HashMap<Furniture, Integer> getOrderedFurniture() {
		HashMap<Furniture, Integer> totalOrder = new HashMap<Furniture, Integer>();
		for (Entry<String, Float> e : this.furniture.entrySet()) {

			totalOrder.put(Furniture.valueOf(e.getKey().toUpperCase()),
					(int) (e.getValue() / (Furniture.valueOf(e.getKey().toUpperCase()).cost())));
		}
		return totalOrder;
	}

	public float getTotalOrderCost() {
		float total = 0.0f;
		for (float f : this.furniture.values()) {
			total = total + f;
		}
		return total;
	}

	public int getTypeCount(Furniture type) {
		if (this.furniture.get(type.label()) != null)
			return (int) (this.furniture.get(type.label()) / type.cost());
		return 0;
	}

	public float getTypeCost(Furniture type) {
		if (this.furniture.get(type.label()) != null)
			return this.furniture.get(type.label());
		return 0.0f;
	}

	public int getTotalOrderQuantity() {
		int totalOrder = 0;
		for (Entry<String, Float> e : this.furniture.entrySet()) {
			totalOrder = (int) (totalOrder + e.getValue() / (Furniture.valueOf(e.getKey().toUpperCase()).cost()));
		}
		return totalOrder;
	}
}