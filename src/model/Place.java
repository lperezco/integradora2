package model;

public class Place {
    private String name;
    private String department;
    private double area;
    private String type;
    private String inaugurationDate;
    private String photoUrl;
    private Community caretakerCommunity;
    private double economicResources;
    private Species[] speciesList;
    private int speciesCount;


    public Place(String placeName, String department, double area, String type, String inaugurationDate, String photo, Community caretakerCommunity, double economicResources) {
        this.name = name;
        this.department = department;
        this.area = area;
        this.type = type;
        this.inaugurationDate = inaugurationDate;
        this.photoUrl = photoUrl;
        this.caretakerCommunity = caretakerCommunity;
        this.economicResources = economicResources;
        this.speciesList = new Species[50]; 
        this.speciesCount = 0; 
    }
    // Constructor
    public String getName() {
    return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getArea() {
		return this.area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInaugurationDate() {
		return this.inaugurationDate;
	}

	public void setInaugurationDate(String inaugurationDate) {
		this.inaugurationDate = inaugurationDate;
	}


	public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

	public Community getCaretakerCommunity() {
		return this.caretakerCommunity;
	}

	public void setCaretakerCommunity(Community caretakerCommunity) {
		this.caretakerCommunity = caretakerCommunity;
	}

	public double getEconomicResources() {
		return this.economicResources;
	}

	public void setEconomicResources(double economicResources) {
		this.economicResources = economicResources;
	}
   
    public void addSpecies(Species species) {
        if (speciesCount < 50) {
            speciesList[speciesCount] = species;
            speciesCount++;
        } else {
            System.out.println("Cannot add more species. The limit has been reached");
        }
    }
	
	public Species findSpeciesByName(String speciesName) {
        for (Species species : speciesList) {
            if (species != null && species.getName().equalsIgnoreCase(speciesName)) {
                return species;
            }
        }
        return null;
    }
	
	public int getNumberOfSpecies() {
        if (speciesList != null) {
            return speciesList.length;
        } else {
            return 0;
        }
    }
	
}
