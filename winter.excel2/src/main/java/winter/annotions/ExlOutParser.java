package winter.annotions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shulin on 16/12/25.
 */
@Component
@Slf4j
public class ExlOutParser {

    /**
     * 解析注解
     *
     * @param clazz
     * @return
     * @throws Exception
     */
    public static List<ExlOutParseResult> parseExlOut(Class clazz) throws Exception {
        Object obj = clazz.newInstance();

        Field[] fields = obj.getClass().getDeclaredFields();
        List<ExlOutParseResult> exlOutParseResultList = new ArrayList<>();
        //解析类注解
        if (obj.getClass().isAnnotationPresent(ExlOut.class)) {
            ExlOut exlOut = (ExlOut) obj.getClass().getAnnotation(ExlOut.class);
            ExlOutParseResult exlOutParseResult = new ExlOutParseResult();
            exlOutParseResult.setAutoIncrement(exlOut.autoIncrement());
            exlOutParseResult.setColSeq(exlOut.colSeq());
            exlOutParseResult.setColName(exlOut.colName());
            exlOutParseResultList.add(exlOutParseResult);
        }
        //解析属性注解
        for (Field field : fields) {
            Annotation tmp = field.getAnnotation(ExlOut.class);
            if (tmp != null) {
                ExlOut exlOut = (ExlOut) tmp;
                ExlOutParseResult exlOutParseResult = new ExlOutParseResult();
                exlOutParseResult.setColName(exlOut.colName());
                exlOutParseResult.setColSeq(exlOut.colSeq());
                exlOutParseResult.setFieldName(field.getName());
                exlOutParseResult.setFieldType(field.getType());
                exlOutParseResult.setFormatStr(exlOut.dateFormat());
                exlOutParseResult.setAutoIncrement(exlOut.autoIncrement());
                exlOutParseResult.setEnumName(exlOut.enumName());
                exlOutParseResult.setEnumMethod(exlOut.enumMethod());
                exlOutParseResultList.add(exlOutParseResult);
            }
        }
        return exlOutParseResultList;
    }

}
