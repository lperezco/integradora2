package model;
public class Product {
    private String name;
    private double naturalIngredientsPercentage;
    private String type;
    private boolean handmade;

	// Constructor
	/**
     * Constructor de la clase Product.
     * 
     * @param name-Nombre del producto.
     * @param naturalIngredientsPercentage Porcentaje de ingredientes naturales del producto.
     * @param type-Tipo de producto.
     * @param handmade-Indica si el producto es hecho a mano o no.
     */
    public Product(String name, double naturalIngredientsPercentage, String type, boolean handmade) {
        this.name = name;
        this.naturalIngredientsPercentage = naturalIngredientsPercentage;
        this.type = type;
        this.handmade = handmade;
    }

    // Getters y  setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNaturalIngredientsPercentage() {
        return naturalIngredientsPercentage;
    }

    public void setNaturalIngredientsPercentage(double naturalIngredientsPercentage) {
        this.naturalIngredientsPercentage = naturalIngredientsPercentage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHandmade() {
        return handmade;
    }

    public void setHandmade(boolean handmade) {
        this.handmade = handmade;
    }

    
}
