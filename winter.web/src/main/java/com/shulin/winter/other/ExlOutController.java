package com.shulin.winter.other;

import com.shulin.winter.example.OrderInfoVo;
import com.shulin.winter.excel.ExcelExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shulin on 16/12/26.
 */
@Controller
@RequestMapping("exl")
public class ExlOutController {

    @Autowired
    private ExcelExportService<OrderInfoVo> excelExportService;

    @RequestMapping("toPage")
    public String toPage() {
        return "downExl";
    }

    @RequestMapping("out")
    public void exlOut(HttpServletResponse response) throws IOException {
        OutputStream outputStream = response.getOutputStream();
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        String fileName = "工单.xlsx";
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1"));
        Map<String, Object> params = new HashMap<>();
        params.put("offset", 0);
        params.put("limit", 1000);
        try {
            //从0开始，每次递增1000，总共查询7000个
            excelExportService.exportLargeExcel(OrderInfoVo.class, params, 5000, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            outputStream.close();
        }
    }
}
