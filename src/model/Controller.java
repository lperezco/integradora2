package model;

public class Controller {
    private Community[] communities;
    private Place[] places;
    private int communityCount;
    private int placeCount;

    public Controller() {
        communities = new Community[50];
        places = new Place[50];
        communityCount = 0;
        placeCount = 0;
    }
    
    public Community[] getCommunities() {
        return communities;
    }
    
    public void addCommunity(Community community) {
        // Verificar si hay espacio disponible en el arreglo de communities
        if (communityCount < communities.length) {
            communities[communityCount] = community;
            communityCount++;
            System.out.println("Community added successfully.");
        } else {
            System.out.println("Cannot add more communities. The limit has been reached.");
        }
    }

    public Place[] getPlaces() {
        return places;
    }

    public String enterCommunity(String name, String type, String representativeName, String representativePhone, int population) {
        if (communityCount < 50) {
            communities[communityCount] = new Community(name, type, representativeName, representativePhone, population);
            communityCount++;
            return "Community entered successfully.";
        } else {
            return "There is no room for more communities.";
        }
    }

    public String enterPlace(String placeName, String department, double area, String type, String inaugurationDate, String photo, String communityName, double economicResources) {
        Community caretakerCommunity = findCommunity(communityName);
        if (caretakerCommunity != null) {
            if (placeCount < 50) {
                places[placeCount] = new Place(placeName, department, area, type, inaugurationDate, photo, caretakerCommunity, economicResources);
                addPlace(places[placeCount]);
                placeCount++;
                return "Place entered successfully.";
            } else {
                return "There is no room for more places.";
            }
        } else {
            return "The specified community was not found. Please enter a valid community.";
        }
    }

    public Community findCommunity(String name) {
        for (int i = 0; i < communityCount; i++) {
            if (communities[i].getName().equalsIgnoreCase(name)) {
                return communities[i];
            }
        }
        return null;
    }

    public void addPlace(Place place) {
        // Verificar si hay espacio disponible en el arreglo de places
        if (placeCount < places.length) {
            places[placeCount] = place;
            placeCount++;
            System.out.println("Place added successfully.");
        } else {
            System.out.println("Cannot add more places. The limit has been reached.");
        }
    }

    public void addPlace(Place place, Place[] places) {
        // Buscamos un espacio vacío en el arreglo para agregar el lugar
        for (int i = 0; i < places.length; i++) {
            if (places[i] == null) {
                places[i] = place;
                return; // Salimos del método después de agregar el lugar
            }
        }
        
        System.out.println("There is no room for more places.");
    }

    public Place findPlaceByName(String placeName, Place[] places) {
        for (Place place : places) {
            if (place != null && place.getName().equalsIgnoreCase(placeName)) {
                return place;
            }
        }
        return null;
    }


    public Community[] findCommunitiesByDepartment(String departmentName) {
        Community[] communitiesInDepartment = new Community[communityCount];
        int count = 0;
        for (int i = 0; i < communityCount; i++) {
            if (communities[i].getDepartment().equalsIgnoreCase(departmentName)) {
                communitiesInDepartment[count] = communities[i];
                count++;
            }
        }
        
        if (count < communityCount) {
            Community[] temp = new Community[count];
            System.arraycopy(communitiesInDepartment, 0, temp, 0, count);
            communitiesInDepartment = temp;
        }
        return communitiesInDepartment;
    }

    public String modifyCommunity(String name, String type, String representativeName, String representativePhone, int population) {
        Community communityToUpdate = findCommunity(name);
        if (communityToUpdate != null) {
            communityToUpdate.setType(type);
            communityToUpdate.setRepresentativeName(representativeName);
            communityToUpdate.setRepresentativePhone(representativePhone);
            communityToUpdate.setPopulation(population);
            return "Community modified successfully.";
        } else {
            return "The specified community was not found. Please enter a valid community.";
        }
    }

    public String modifyPlace(String placeName, String department, double area, String type, String inaugurationDate, String photo, String communityName, double economicResources) {
        Place placeToUpdate = findPlaceByName(placeName, places);
        if (placeToUpdate != null) {
            Community caretakerCommunity = findCommunity(communityName);
            if (caretakerCommunity != null) {
                placeToUpdate.setDepartment(department);
                placeToUpdate.setArea(area);
                placeToUpdate.setType(type);
                placeToUpdate.setInaugurationDate(inaugurationDate);
                placeToUpdate.setPhotoUrl(photo);
                placeToUpdate.setCaretakerCommunity(caretakerCommunity);
                placeToUpdate.setEconomicResources(economicResources);
                return "Place modified successfully.";
            } else {
                return "The specified community for the location was not found. Please enter a valid community.";
            }
        } else {
            return "The specified location was not found. Please enter a valid location.";
        }
    }

    public void deleteCommunity(String name) {
        for (int i = 0; i < communityCount; i++) {
            if (communities[i].getName().equalsIgnoreCase(name)) {
                for (int j = i; j < communityCount - 1; j++) {
                    communities[j] = communities[j + 1];
                }
                communities[communityCount - 1] = null;
                communityCount--;
                break;
            }
        }
    }

    public void deletePlace(String placeName) {
        for (int i = 0; i < placeCount; i++) {
            if (places[i].getName().equalsIgnoreCase(placeName)) {
                for (int j = i; j < placeCount - 1; j++) {
                    places[j] = places[j + 1];
                }
                places[placeCount - 1] = null;
                placeCount--;
                break;
            }
        }
    }
    
    public Place[] getAllPlaces() {
        return places;
    }
}
