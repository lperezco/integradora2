package ui;

import java.util.Scanner;
import model.Controller;
import model.Community;
import model.Place;
import model.Species;
import java.util.Set;
import java.util.HashSet;



public class Ejecutable {
    private Controller controller;
    private Scanner scanner;
    private Community[] communities;
    private int communityCount;
    private static final int MAX_COMMUNITIES = 100; // Tú puedes definir el valor máximo que necesites

    public static void main(String[] args) {
        Ejecutable exe = new Ejecutable();
       // exe.controller = new Controller();
        exe.start();
    }

    public Ejecutable() {
        controller = new Controller();
        scanner = new Scanner(System.in);
        
    }

	public void start() {
			showMainMenu();
	}
  
  /**
     * Método que muestra el menú principal y permite al usuario seleccionar una
     * opción para interactuar con el sistema.
	 * import java.util.HashSet;
   */

	public void showMainMenu() {
		int option;
		do {
			System.out.println("=== Main Menu ===");
			System.out.println("1. Administrative Menu");
			System.out.println("2. Query Menu");
			System.out.println("3. Exit");
			System.out.print("Enter an option: ");

			option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
				case 1:
					showAdministrativeMenu();
					break;
				case 2:
					showQueryMenu();
					break;
				case 3:
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid option. Please enter a number from 1 to 3.");
					break;
			}
		} while (option != 3);
		communityCount = 0; // Asignación de communityCount fuera del switch
	}


    /**
     * Método que muestra el menú administrativo y permite al usuario realizar
     * acciones administrativas en el sistema.
     */
    public void showAdministrativeMenu() {
        int option;
        do {
            System.out.println("---Administrative Menu---");
            System.out.println("1. Enter a Community");
            System.out.println("2. Enter a Place");
            System.out.println("3. Enter and/or delete a product from a community");
            System.out.println("4. Enter a species into a place");
            System.out.println("5. Modify species data in a place");
            System.out.println("6. Create test cases");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    enterCommunity();
                    break;
                case 2:
                    enterPlace();
                    break;
                case 3:
                    enterDeleteProduct();
                    break;
                case 4:
                    enterSpecies();
                    break;
                case 5:
                    modifySpecies();
                    break;
                case 6:
                    createTestCases();
                    break;
                case 7:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number from 1 to 7.");
                    break;
            }
        } while (option != 7);
    }

    /**
     * Método para ingresar los detalles de una comunidad y agregarla al sistema.
     */
    public void enterCommunity() {
        System.out.println("Enter the details of the community:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Type (Afrocolombian, Indigenous, Raizal): ");
        String type = scanner.nextLine();
        System.out.print("Representative's name: ");
        String representative = scanner.nextLine();
        System.out.print("Representative's phone number: ");
        String representativePhone = scanner.nextLine();
        System.out.print("Number of inhabitants: ");
        int numberOfInhabitants = scanner.nextInt();
        scanner.nextLine();

        Community community = new Community(name, type, representative, representativePhone, numberOfInhabitants);

        controller.addCommunity(community);

        System.out.println("Community entered successfully.");
    }
	
	
	// Método para agregar una comunidad
	public void addCommunity(Community community) {
		// Verificar si la comunidad ya existe en la lista
		boolean communityExists = false;
		for (int i = 0; i < communityCount; i++) {
			if (communities[i].getName().equals(community.getName())) {
				communityExists = true;
				break;
			}
		}
		
		// Si la comunidad no existe, agregarla a la lista
		if (!communityExists) {
			// Verificar si hay espacio disponible en la lista
			if (communityCount < MAX_COMMUNITIES) {
				communities[communityCount] = community;
				communityCount++;
				System.out.println("Community added successfully.");
			} else {
				System.out.println("Cannot add more communities. The limit has been reached.");
			}
		} else {
			System.out.println("Community already exists.");
		}
	}


/**
 * Método para ingresar los detalles de un lugar y agregarlo al sistema.
 */
public void enterPlace() {
    System.out.println("Enter the details of the place:");
    System.out.print("Place name: ");
    String placeName = scanner.nextLine();
    String department = "";
    do {
        System.out.println("Department name:");
        System.out.println("1) Chocó");
        System.out.println("2) Valle del Cauca");
        System.out.println("3) Nariño");
        System.out.print("Enter the corresponding number for the department: ");
        int departmentOption = scanner.nextInt();
        scanner.nextLine();
        switch (departmentOption) {
            case 1:
                department = "Chocó";
                break;
            case 2:
                department = "Valle del Cauca";
                break;
            case 3:
                department = "Nariño";
                break;
            default:
                System.out.println("Invalid option. Please enter a number from 1 to 3.");
                break;
        }
    } while (department.equals(""));
    System.out.print("Square kilometers: ");
    double area = scanner.nextDouble();
    scanner.nextLine();
    String type = "";
    do {
        System.out.println("Type of place:");
        System.out.println("1) Protected area");
        System.out.println("2) National park");
        System.out.println("3) Private area");
        System.out.print("Enter the corresponding number for the type of place: ");
        int typeOption = scanner.nextInt();
        scanner.nextLine();
        switch (typeOption) {
            case 1:
                type = "Protected area";
                break;
            case 2:
                type = "National park";
                break;
            case 3:
                type = "Private area";
                break;
            default:
                System.out.println("Invalid option. Please enter a number from 1 to 3.");
                break;
        }
    } while (type.equals(""));
    System.out.print("Inauguration date: ");
    String inaugurationDate = scanner.nextLine();
    System.out.print("Access route to the photo of the place: ");
    String photo = scanner.nextLine();
    System.out.print("Name of the community that takes care of the place: ");
    String communityName = scanner.nextLine();
    System.out.print("Economic resources needed for habitat care: ");
    double economicResources = scanner.nextDouble();
    scanner.nextLine();

    // Buscar comunidad
    Community community = controller.findCommunity(communityName);
    if (community != null) {
        // Crear un nuevo objeto Place con los detalles proporcionados
        Place place = new Place(placeName, department, area, type, inaugurationDate, photo, community, economicResources);

        // Agregar el nuevo lugar al controlador
        controller.addPlace(place);

        System.out.println("Place entered successfully.");
    } else {
        System.out.println("The specified community was not found. Please enter a valid community.");
    }
}

	
    /**
     * Método para ingresar o eliminar un producto de una comunidad.
     */
    public void enterDeleteProduct() {
        // Implement method to enter or delete a product from a community
        System.out.println("Method to enter or delete a product from a community is not yet implemented.");
    }

    /**
     * Método para ingresar los detalles de una especie y agregarla al sistema.
     */
    public void enterSpecies() {
        System.out.println("Enter the details of the species:");
        System.out.print("Species name: ");
        String speciesName = scanner.nextLine();
        System.out.println("Select the type of species:");
        System.out.println("1) Fauna");
        System.out.println("2) Flora");
        System.out.print("Enter the corresponding number: ");
        int speciesTypeNumber = scanner.nextInt();
        scanner.nextLine();
        String speciesType;
        if (speciesTypeNumber == 1) {
            speciesType = "fauna";
        } else if (speciesTypeNumber == 2) {
            speciesType = "flora";
        } else {
            System.out.println("Invalid option. It will be set as 'unknown'.");
            speciesType = "unknown";
        }
        System.out.print("Access route to the species photo: ");
        String speciesPhoto = scanner.nextLine();
        System.out.print("Number of specimens in the place: ");
        int numberOfSpecimens = scanner.nextInt();
        scanner.nextLine();

        Species species = new Species(speciesName, speciesType, speciesPhoto, numberOfSpecimens);

        System.out.println("Species entered successfully.");
    }

    /**
     * Método para modificar los datos de una especie en un lugar.
     */
    /**
 * Método para modificar los datos de una especie en un lugar.
 */
public void modifySpecies() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the name of the place:");
    String placeName = scanner.nextLine();

    // Buscar el lugar por su nombre
    Place place = controller.findPlaceByName(placeName, controller.getPlaces());

    if (place != null) {
        System.out.println("Enter the name of the species to modify:");
        String speciesName = scanner.nextLine();

        // Buscar la especie en el lugar
        Species species = place.findSpeciesByName(speciesName);

        if (species != null) {
            // Solicitar al usuario que ingrese los nuevos datos de la especie
            System.out.println("Enter the new name of the species:");
            String newName = scanner.nextLine();
            System.out.println("Enter the new type of the species (Flora/Fauna):");
            String newType = scanner.nextLine();
            // Solicitar otros datos de la especie que deseas modificar

            // Modificar los datos de la especie
            species.setName(newName);
            species.setType(newType);
            // Modificar otros datos de la especie según sea necesario

            System.out.println("Species data modified successfully.");
        } else {
            System.out.println("The specified species was not found in the place.");
        }
    } else {
        System.out.println("The specified place was not found.");
    }
}

   /**
     * Método para crear casos de prueba en el sistema.
     */
    public void createTestCases() {
        // Crear algunas comunidades de ejemplo
        Community community1 = new Community("Comunidad 1", "Tipo 1", "Representante 1", "123456789", 100);
        Community community2 = new Community("Comunidad 2", "Tipo 2", "Representante 2", "987654321", 150);
        
        // Añadir comunidades a la lista de comunidades
        addCommunity(community1);
        addCommunity(community2);

        // lugares de ejemplo
        Place place1 = new Place("Lugar 1", "Departamento 1", 100.0, "Tipo 1", "2024-01-01", "photo1.jpg", community1, 1000.0);
        Place place2 = new Place("Lugar 2", "Departamento 2", 200.0, "Tipo 2", "2024-02-01", "photo2.jpg", community2, 1500.0);
        
        // lista de lugares
        addPlace(place1);
        addPlace(place2);

        // especies de ejemplo
        Species species1 = new Species("Especie 1", "Flora", "photo1.jpg", 50);
        Species species2 = new Species("Especie 2", "Fauna", "photo2.jpg", 30);
        
        // Añadir especies a los lugares
        place1.addSpecies(species1);
        place2.addSpecies(species2);

        System.out.println("Test cases created successfully.");
    }

    /**
     * Método que muestra el menú de consulta y permite al usuario realizar
     * consultas en el sistema.
     */
    public void showQueryMenu() {
        int option;
        do {
            System.out.println("---Query Menu---");
            System.out.println("1. Check information of a place");
            System.out.println("2. Check communities in a department");
            System.out.println("3. Check communities with specific problems");
            System.out.println("4. Check place with most species");
            System.out.println("5. Check top three largest places by area");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter the number of the option you want to perform: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    queryPlaceInformation();
                    break;
                case 2:
                    queryCommunitiesInDepartment();
                    break;
                case 3:
                    queryCommunitiesWithSpecificProblems();
                    break;
                case 4:
                    queryPlaceWithMostSpecies();
                    break;
                case 5:
                    queryTopThreeLargestPlacesByArea();
                    break;
                case 6:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number from 1 to 6.");
                    break;
            }
        } while (option != 6);
    }

    /**
 * Método para consultar la información de un lugar específico.
 */
public void queryPlaceInformation() {
    System.out.print("Enter the name of the place you want to have information: ");
    String placeName = scanner.nextLine();

    // Buscar el lugar por su nombre
    Place place = controller.findPlaceByName(placeName, controller.getAllPlaces());

    if (place != null) {
        System.out.println("Name place: " + place.getName());
        System.out.println("Department: " + place.getDepartment());
        System.out.println("Area: " + place.getArea() + " square kilometers");
        System.out.println("Photo URL: " + place.getPhotoUrl());
    } else {
        System.out.println("Place not found.");
    }
}

	
	/**
     * Método para consultar las comunidades en un departamento específico.
     */

	public void queryCommunitiesInDepartment() {
			System.out.print("Enter the name of the department you want to query: ");
			String departmentName = scanner.nextLine();

			
			Community[] communities = controller.findCommunitiesByDepartment(departmentName);


			if (communities != null && communities.length > 0) {

				// Nombres de la comunidad 
				Set<String> communityNames = new HashSet<>();
				for (Community community : communities) {
					communityNames.add(community.getName());
				}
				for (String name : communityNames) {
					System.out.println("Community: " + name);
				}
			} else {
				System.out.println("No communities were found in this department.");
			}
	}
		
		/**
		* Método para consultar comunidades con problemas específicos.
		*/

		public void queryCommunitiesWithSpecificProblems() {
			System.out.println("Communities with specific problems:");
			for (Community community : communities) {
				if (community.hasSpecificProblems()) {
					System.out.println(community.getName());
				}
			}
		}

		/**
		* Método para consultar el lugar con la mayor cantidad de especies.
		*/

		public void queryPlaceWithMostSpecies() {
    // Obtener todos los lugares del controlador
    Place[] places = controller.getAllPlaces();

    int maxSpeciesCount = 0;
    Place placeWithMostSpecies = null;

    for (Place place : places) {
        if (place.getNumberOfSpecies() > maxSpeciesCount) {
            maxSpeciesCount = place.getNumberOfSpecies();
            placeWithMostSpecies = place;
        }
    }

    if (placeWithMostSpecies != null) {
        System.out.println("Place with the most species: " + placeWithMostSpecies.getName());
    } else {
        System.out.println("No places found.");
    }
}

		/**
		 * Método para consultar los tres lugares más grandes por área.
		 */
		public void queryTopThreeLargestPlacesByArea() {
			// Crear un arreglo de lugares con un tamaño suficiente
			Place[] allPlaces = new Place[controller.getAllPlaces().length];
			sortPlacesByArea(allPlaces);

			// Tomar los primeros tres lugares del arreglo ordenado
			Place[] topThreeLargestPlaces = new Place[Math.min(allPlaces.length, 3)];
			System.arraycopy(allPlaces, 0, topThreeLargestPlaces, 0, topThreeLargestPlaces.length);

			// Mostrar los tres lugares más grandes por área
			System.out.println("The three largest places by area are:");
			for (Place place : topThreeLargestPlaces) {
				System.out.println(place.getName() + " - Area: " + place.getArea() + " square kilometers");
			}
		}

	
	public void addPlace(Place place) {
        
    }

    public void sortPlacesByArea(Place[] places) {
        
    }
	


}















