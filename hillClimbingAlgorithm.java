public class hillClimbingAlgorithm {

    public static int maximumIterations = 1000;

    public void findShortestRoute(Route currentRoute)
    {
        Route neighborhoodSolution ;
        int iterationCounter = 0;
        System.out.println(currentRoute.printRoute()+" | Initial Distance : "+(int)currentRoute.getFullRouteDistance()+" km");
        while (iterationCounter < maximumIterations){
            neighborhoodSolution = getNeighborhoodSolution(new Route(currentRoute)); // on crée une solution voisine
            /* Pour ce problème, la fonction du coût est la distance totale dans tous le chemin
            *  Si le cout de la solution voisine est moins que la solution actuelle, on la garder et on continue le même travail
            *  jusqu'on atteint maximumIterations
            * */
            if(neighborhoodSolution.getFullRouteDistance() <= currentRoute.getFullRouteDistance()){
                System.out.println(currentRoute.printRoute()+" distance :"+(int)currentRoute.getFullRouteDistance()+" km better founded | iteration "+iterationCounter);
                iterationCounter=0;
                System.out.println(neighborhoodSolution.printRoute()+" new distance : "+(int)neighborhoodSolution.getFullRouteDistance()+" km | iteration "+iterationCounter);
                currentRoute = new Route(neighborhoodSolution);
            }else{
                System.out.println(currentRoute.printRoute()+" | iteration : "+iterationCounter);
                iterationCounter++;
            }
        }
        System.out.println(currentRoute.printRoute()+" | Full Distance : "+(int)currentRoute.getFullRouteDistance()+" km | <- minimum founded in "+iterationCounter +" iterations.");
    }



    // Tirer une des solutions du voisinage
    // Pour ce type de problème, on peut echanger l'emplacement de 2 villes.
    public Route getNeighborhoodSolution(Route route)
    {
        int random1 = 0 ;
        int random2 = 0 ;

        /* On choisis 2 villes différentes pour les échanger
           à partir du 0 jusqu'a la taille de la liste (nombre de villes)
           On choisissant 2 villes aléatoirement, et on les echange (swap) !
        */

        while(random1==random2){
            random1 = (int) (route.cities.size()* Math.random());
            random2 = (int) (route.cities.size()* Math.random());
        }
        City city_1 = route.cities.get(random1);
        City city_2 = route.cities.get(random2);
        route.cities.set(random2,city_1);
        route.cities.set(random1,city_2);
        return route;
    }
}
