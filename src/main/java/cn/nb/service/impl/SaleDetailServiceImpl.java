package cn.nb.service.impl;

import cn.nb.bean.SaleDetail;
import cn.nb.dao.SaleDetailMapper;
import cn.nb.service.SaleDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("saleDetailService")
public class SaleDetailServiceImpl implements SaleDetailService {
@Resource
private SaleDetailMapper saleDetailMapper;//dao层的调用


    @Override
    public List<SaleDetail> findAllSaleDetail(int pageindex, int pagesize) {
        System.out.println("SaleDetailServiceImpl===>findAllSaleDetail");
        return saleDetailMapper.findAllSaleDetail(pageindex,pagesize);
    }

    @Override
    public List<SaleDetail> findAllSaleDetailByDate(int pageindex, int pagesize) {
        System.out.println("SaleDetailServiceImpl===>findAllSaleDetailByDate");
        return saleDetailMapper.findAllSaleDetailByDate(pageindex,pagesize);
    }

    @Override
    public int findCount() {
        System.out.println("SaleDetailServiceImpl===>findCount");
        return saleDetailMapper.findCount();
    }
}
