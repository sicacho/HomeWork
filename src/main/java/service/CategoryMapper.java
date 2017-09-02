package service;

/**
 * Created by khangtn on 9/2/2017.
 */
public interface CategoryMapper {
    public Integer getCategoryMapping(String sourceCountry, String destinationCountry, int categoryId);
}
