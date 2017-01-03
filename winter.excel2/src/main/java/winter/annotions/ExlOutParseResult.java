package winter.annotions;

import lombok.Getter;
import lombok.Setter;

/**
 * 解析注解后的对象
 * Created by shulin on 16/12/25.
 */
@Setter
@Getter
public class ExlOutParseResult implements Comparable {
    private int colSeq;
    private String colName;
    private String fieldName;
    private Class fieldType;
    private String formatStr;
    private Boolean autoIncrement;

    private String enumName;
    private String enumMethod;

    @Override
    public int compareTo(Object o) {
        ExlOutParseResult tmp = (ExlOutParseResult) o;
        if (colSeq < tmp.colSeq) {
            return -1;
        } else if (colSeq > tmp.colSeq) {
            return 1;
        } else {
            return 0;
        }
    }
}
