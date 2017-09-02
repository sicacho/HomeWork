package service.impl;

import datasource.DataSource;
import service.CategoryMapper;

/**
 * Created by khangtn on 9/2/2017.
 */
public class CategoryMapperImpl implements CategoryMapper {

    DataSource dataSource;

    public CategoryMapperImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Integer getCategoryMapping(String sourceCountry, String destinationCountry, int categoryId) {
        return dataSource.getCategoryMapping(sourceCountry,destinationCountry,categoryId);
    }


}
