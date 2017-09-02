import datasource.DataSource;
import datasource.impl.JsonDataSourceImpl;
import org.junit.Assert;
import org.junit.Test;
import service.CategoryMapper;
import service.impl.CategoryMapperImpl;

import java.io.File;

/**
 * Created by khangtn on 9/2/2017.
 */
public class TestJsonCategoryMapper {

    @Test
    public void testGetCategoryMapping() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("country_mapping.json").getFile());
        DataSource jsonDataSouce = new JsonDataSourceImpl(file.getAbsolutePath());
        CategoryMapper categoryMapper = new CategoryMapperImpl(jsonDataSouce);
        Integer result = categoryMapper.getCategoryMapping("vn","my",4);
        Assert.assertEquals(new Integer(128),result);
    }
}
