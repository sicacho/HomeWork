package datasource;

/**
 * Created by khangtn on 9/2/2017.
 */
public interface DataSource {
    Integer getCategoryMapping(String sourceCountry, String destinationCountry, int categoryId);
}
