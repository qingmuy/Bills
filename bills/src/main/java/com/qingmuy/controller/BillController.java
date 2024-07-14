package com.qingmuy.controller;


import com.qingmuy.common.Result;
import com.qingmuy.domain.dto.AddNewBillDTO;
import com.qingmuy.domain.dto.BillPageQueryDTO;
import com.qingmuy.domain.dto.UpdateBillDTO;
import com.qingmuy.domain.result.PageResult;
import com.qingmuy.domain.vo.BillQueryVO;
import com.qingmuy.service.BillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bill")
@Tag(name = "账单接口")
public class BillController {

    @Resource
    BillService billService;

    /**
     * 新增账单
     */
    @Operation(summary = "新增账单")
    @PostMapping("/add")
    public Result<Boolean> addNewBill(@RequestBody AddNewBillDTO newBillDTO) {
        billService.addNewBill(newBillDTO);
        return Result.success();
    }

    @Operation(summary = "删除账单")
    @DeleteMapping
    public Result<Boolean> deleteBill(@RequestParam Long id) {
        billService.deleteBill(id);
        return Result.success();
    }

    @Operation(summary = "更新订单")
    @PutMapping
    public Result<Boolean> updateBill(@RequestBody UpdateBillDTO billDTO) {
        billService.updateBill(billDTO);
        return Result.success();
    }

    /**
     * 查询账单详情
     *
     * @param id 账单id
     * @return 账单详细信息
     */
    @Operation(summary = "查询账单详情")
    @PostMapping("/{id}")
    public Result<BillQueryVO> queryBillDetail(@PathVariable Long id) {
        BillQueryVO billQueryVO = billService.queryDetail(id);
        return Result.success(billQueryVO);
    }

    @Operation(summary = "分页查询订单数据")
    @PostMapping("/page")
    public Result<PageResult> pageQuery(BillPageQueryDTO billPageQueryDTO) {
        PageResult pageResult = billService.pageQuery(billPageQueryDTO);
        return Result.success(pageResult);
    }
}
