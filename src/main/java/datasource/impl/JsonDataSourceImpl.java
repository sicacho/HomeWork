package datasource.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import datasource.DataSource;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by khangtn on 9/2/2017.
 */
public class JsonDataSourceImpl implements DataSource {
    private ObjectMapper mapper = new ObjectMapper();
    private TypeReference<List<HashMap<String,Integer>>> typeRef = new TypeReference<List<HashMap<String,Integer>>>() {};
    private String connection;
    private HashMap<String,HashMap<String,Integer>> categoryCountryMappingDatabase;

    public JsonDataSourceImpl(String connection) {
        this.connection = connection;
        initDataBase();
    }


    private void initDataBase() {
        File fromJsonFile = new File(connection);
        categoryCountryMappingDatabase = new HashMap<String, HashMap<String, Integer>>();
        try {
            List<HashMap<String, Integer>> fromCategoryCountryMappingList = getListCategoryCountryMapping(fromJsonFile);
            buildCategoryCountryMappingDatabase(fromCategoryCountryMappingList);
        } catch (InvalidFormatException f) {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Build CategoryCountryMappingDatabase
     * CategoryCountryMappingDatabase is Document database with structure
     * key : country-categoryId ( sg-4 );
     * Value : countries and categoryIDs mapping with key's country and categoryId . Ex :
     * { sg-4 ->   {"vn": 4,"sg": 4,"tw": 4,"hk": 4,"my": 128,"ph": 4,"th": null} }
     */
    private void buildCategoryCountryMappingDatabase(List<HashMap<String, Integer>> categoryCountryList) {
        for (HashMap<String, Integer> CountryCategoryIDMap : categoryCountryList){
            for (Map.Entry<String,Integer> entry : CountryCategoryIDMap.entrySet()) {
                if(entry.getValue()!=null) {
                    categoryCountryMappingDatabase.put(buildSourceKey(entry.getKey(),entry.getValue()),CountryCategoryIDMap);
                }
            }
        }
    }

    private List<HashMap<String, Integer>> getListCategoryCountryMapping(File from) throws IOException {
        return mapper.readValue(from, typeRef);
    }

    public Integer getCategoryMapping(String sourceCountry, String destinationCountry, int categoryId) {
        String sourceKey = buildSourceKey(sourceCountry, categoryId);
        HashMap<String,Integer> CountryCategoryIdsMappingWithSourceKey = categoryCountryMappingDatabase.get(sourceKey);
        Integer destinationId = CountryCategoryIdsMappingWithSourceKey.get(destinationCountry);
        return destinationId;
    }

    private String buildSourceKey(String sourceCountry, int categoryId) {
        return sourceCountry+"-"+categoryId;
    }
}
