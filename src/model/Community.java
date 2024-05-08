package model;

public class Community {
   
	private String name;
    private String type;
    private String representativeName;
    private String representativePhone;
    private int population;
    private String[] majorProblems;
    private int maxProblems = 4; 
    private Product[] products;
    private int productCount;
    private final int MAX_PRODUCTS = 50;
    private String department;
    private Species[] speciesList; 
    private static final int MAX_SPECIES = 100;

    // Constructor
    public Community(String name, String type, String representativeName, String representativePhone, int population) {
        this.name = name;
        this.type = type;
        this.representativeName = representativeName;
        this.representativePhone = representativePhone;
        this.population = population;
        this.majorProblems = new String[maxProblems];
        this.products = new Product[MAX_PRODUCTS];
        this.productCount = 0;
        this.department = department;
        this.speciesList = new Species[MAX_SPECIES]; 
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public String getRepresentativePhone() {
        return representativePhone;
    }

    public void setRepresentativePhone(String representativePhone) {
        this.representativePhone = representativePhone;
    }

    public int getPopulation() {
        return population;
    }
	
	public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
	

    public void setPopulation(int population) {
        this.population = population;
    }

    public String[] getMajorProblems() {
        return majorProblems;
    }

    public void setMajorProblems(String[] majorProblems) {
        this.majorProblems = majorProblems;
    }
	
	// Método para ingresar un producto a la comunidad
    public void addProduct(Product product) {
        if (productCount < MAX_PRODUCTS) {
            this.products[productCount] = product;
            productCount++;
            System.out.println("Product added successfully to the community.");
        } else {
            System.out.println("Cannot add more products. The limit has been reached.");
        }
    }

    // Método para eliminar un producto de la comunidad
    public void removeProduct(String productName) {
        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equalsIgnoreCase(productName)) {
               
                for (int j = i; j < productCount - 1; j++) {
                    products[j] = products[j + 1];
                }
                productCount--;
                found = true;
                System.out.println("Product removed successfully from the community.");
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found in the community.");
        }
    }
	
	public boolean hasSpecificProblems() {
        return majorProblems != null && majorProblems.length > 0;
    }

    public int getNumberOfSpecies() {
        return speciesList != null ? speciesList.length : 0;
    }
   
}
