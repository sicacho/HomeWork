import datasource.DataSource;
import datasource.impl.JsonDataSourceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

/**
 * Created by khangtn on 9/2/2017.
 */
public class TestJsonDataSouce {

    @Test
    public void testJsonDataSouce() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("country_mapping.json").getFile());
        DataSource jsonDataSouce = new JsonDataSourceImpl(file.getAbsolutePath());
        Assert.assertNotNull(jsonDataSouce.getCategoryMapping("vn","my",4));
    }
}
