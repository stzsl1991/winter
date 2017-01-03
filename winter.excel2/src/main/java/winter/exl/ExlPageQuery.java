package winter.exl;

import java.util.List;
import java.util.Map;

/**
 * Created by shulin on 16/12/25.
 */
public interface ExlPageQuery<K> {
    /**
     * 分页获取数据
     *
     * @param params
     * @return
     */
    public List<K> getBeansByPage(Map<String, Object> params);
}
