package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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
		return (HashMap<Furniture, Integer>) this.furniture.entrySet().stream()
				.collect(Collectors.toMap(e -> Furniture.valueOf(e.getKey().toUpperCase()),
						e -> (int) (e.getValue() / (Furniture.valueOf(e.getKey().toUpperCase()).cost()))));
	}

	public float getTotalOrderCost() {
		return this.furniture.values().stream().reduce(0.0f, (a, b) -> a + b);

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