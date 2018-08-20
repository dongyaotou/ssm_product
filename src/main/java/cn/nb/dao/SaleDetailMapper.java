package cn.nb.dao;

import cn.nb.bean.SaleDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleDetailMapper {

    //查询销售信息 按照单笔总价进行排序
    public List<SaleDetail> findAllSaleDetail(@Param("pageindex") int pageindex,@Param("pagesize") int pagesize);
    //查询销售信息 按照销售日期降序排列
    public List<SaleDetail> findAllSaleDetailByDate(@Param("pageindex") int pageindex,@Param("pagesize") int pagesize);

    //查询总记录数
    public int findCount();

}
