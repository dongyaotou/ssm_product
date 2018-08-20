package cn.nb.service.impl;

import cn.nb.bean.Sale;
import cn.nb.dao.SaleMapper;
import cn.nb.service.SaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("saleService")
public class SaleServiceImpl implements SaleService {
    @Resource
    private SaleMapper saleMapper;
    @Override
    public void addOrder(Sale sale) {
        saleMapper.addOrder(sale);
    }
}
