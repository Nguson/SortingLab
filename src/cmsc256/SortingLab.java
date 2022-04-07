package cmsc256;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.ActorMovieIMDB;

import java.util.ArrayList;
import java.util.List;
public class SortingLab {
    public static void main(String[] args) throws Exception{
        Bridges bridges = new Bridges(0, "Nguyenms2@vcu.edu", "386889807102");
        DataSource ds = bridges.getDataSource();

        List<ActorMovieIMDB> movieData = null;

        try {

            movieData = ds.getActorMovieIMDBData(Integer.MAX_VALUE);

        }

        catch (Exception e) {

            System.out.println("Unable to connect to Bridges.");

        }

        for(int i = 0; i < 5; i++) {
            ActorMovieIMDB entry = movieData.get(i);
            System.out.println("" + i + ".  " + entry.getActor() + " was in " + entry.getMovie());
        }
        System.out.println("");
        ArrayList<ActorMovieIMDB> filteredMovieList = new ArrayList<>();
        ActorComparator comparer = new ActorComparator();
        for(ActorMovieIMDB actors : movieData){
            if(actors.getMovie().equals("Being_John_Malkovich_(1999)")){
                filteredMovieList.add(actors);
            }
        }
        filteredMovieList.sort(comparer);
        for(ActorMovieIMDB list: filteredMovieList){
            System.out.println(list.getActor());
        }
    }
}
