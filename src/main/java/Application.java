import datasource.DataSource;
import datasource.impl.JsonDataSourceImpl;
import service.CategoryMapper;
import service.impl.CategoryMapperImpl;

import java.io.File;

/**
 * Created by khangtn on 9/2/2017.
 */
public class Application {
    public static void main(String[] args) {
        String connection = getExampleConnection();
        DataSource dataSource = new JsonDataSourceImpl(connection);
        CategoryMapper categoryMapper = new CategoryMapperImpl(dataSource);
        System.out.println(categoryMapper.getCategoryMapping("vn","tw",8));
    }

    private static String getExampleConnection() {
        ClassLoader classLoader = Application.class.getClassLoader();
        File file = new File(classLoader.getResource("country_mapping.json").getFile());
        return file.getAbsolutePath();
    }
}
